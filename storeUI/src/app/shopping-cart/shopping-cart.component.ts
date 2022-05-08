import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../dtos/product';
import { Sale, SaleList } from '../dtos/sale';
import { CustomerService } from '../services/customer.service';
import { ShoppingCartService } from '../services/shopping-cart.service';



@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  sale: Sale = new Sale();
  cartproducts: Product[] = [];
  public zipCodeForm!: FormGroup;
  productTotal: number = 0;
  error: string = "";
  errors = null;
  productFromDataBase!: Product;

  constructor(private shoppingCartService: ShoppingCartService, private fb: FormBuilder, private customerService: CustomerService) { }

  ngOnInit(): void {
    this.cartproducts = this.shoppingCartService.getShoppingCart();
    if (this.cartproducts) {
      for (let cp of this.cartproducts) {
        this.customerService.getProductById(cp.id).subscribe(
          result => {
            this.productFromDataBase = result;
            cp.base64Image = this.productFromDataBase.base64Image;
          }
        );
      }
    }

    if (this.cartproducts) {
      for (let cartProduct of this.cartproducts) {
        cartProduct.priceTotal = (cartProduct.amount * cartProduct.price);
        this.productTotal += (cartProduct.amount * cartProduct.price);
      };
    }

    this.zipCodeForm = this.fb.group({
      zipCode: ["", [Validators.required]],
    });
  }

  checkOut(data: any) {

    this.sale.zipCode = data.zipCode;
    if (this.cartproducts) {
      for (let cartProduct of this.cartproducts) {
        var idString = cartProduct.id.toString();

        this.sale.listOfProducts.push({ id: idString, quantity: cartProduct.amount })
      }
      console.log(this.sale);

      this.customerService.registerSale(this.sale)
        .subscribe(result => {
          this.shoppingCartService.resetShoppingCart();
          this.cartproducts = [];
          this.productTotal = 0;
        },
          err => {
            this.error = "Problems trying to register sale. Verify your data or try again later."
            this.errors = err;
          }
        );
    }

  }

}







