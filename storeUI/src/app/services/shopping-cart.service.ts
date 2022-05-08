import { Injectable } from '@angular/core';
import { json } from 'body-parser';
import { Observable, of } from 'rxjs';
import { Product } from '../dtos/product';


const CART_ITEMS = 'shoppingCart';


@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  cartProducts: Product[] = [];

  constructor() { }

  shoppingCart(product: Product): Observable<Product[]> {
    var base64Image = product.base64Image;
    product.base64Image = '';
    var addProduct = true;
    if (this.cartProducts) {
      for (let p of this.cartProducts) {
        if (p.id == product.id) {
          if (p.productStock >= (p.amount + product.amount)) {
            p.amount += product.amount;
          }
          addProduct = false;
          break;
        }
      }
      if (addProduct) {
        this.cartProducts.push(product);
      }

      this.saveShoppingCart(this.cartProducts);
      product.base64Image = base64Image;
      const obsof1 = of(this.cartProducts);
      return obsof1;
    } else {
      return new Observable<Product[]>();
    }
  }

  getShoppingCart1(): Observable<Product[]> {
    const obsof1 = of(this.cartProducts);
    return obsof1;
  }

  public saveShoppingCart(cartProducts: Product[]): void {
    this.resetShoppingCart();
    window.sessionStorage.setItem(CART_ITEMS, JSON.stringify(cartProducts));
  }

  public resetShoppingCart(): void {
    window.sessionStorage.removeItem(CART_ITEMS);
  }

  public getShoppingCart(): Product[] {
    var x = window.sessionStorage.getItem(CART_ITEMS) as string;
    if (x) {
      this.cartProducts = JSON.parse(x);
    }
    return this.cartProducts;
  }


}
