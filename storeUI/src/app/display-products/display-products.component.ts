import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../dtos/product';
import { CustomerService } from '../services/customer.service';
import { ShoppingCartService } from '../services/shopping-cart.service';

@Component({
  selector: 'app-display-products',
  templateUrl: './display-products.component.html',
  styleUrls: ['./display-products.component.css']
})
export class DisplayProductsComponent implements OnInit {

  public products : Product[] = [];
  public productQuantity!: FormGroup;
  error = "";
  errors = null;

  constructor(private service: CustomerService,  private shoppingCart : ShoppingCartService, private fb : FormBuilder) { }

  ngOnInit(): void {
    this.service.getProducts()
    .subscribe(
      products => {
        this.products = products;
      }, 
      err => { console.log(err) 
        this.error = "We could not find any product."
        this.errors = err;
      }
    );

    this.productQuantity = this.fb.group({
      quantity : [1, [Validators.required]],
    })
  }

  AddToCart(data : any, product: Product){   
    product.amount  = data.quantity;
     this.shoppingCart.shoppingCart(product).subscribe(result =>{
     });
  }





}
