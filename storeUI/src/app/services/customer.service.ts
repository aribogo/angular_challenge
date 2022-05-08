import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../dtos/product';
import { catchError, throwError } from 'rxjs';
import { TokenStorageService } from './token-storage.service';
import { Sale, SavedSale } from '../dtos/sale';
import { SaleItems } from '../dtos/saleItems';

const API_URL = 'http://localhost:8080/v1/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient, private token : TokenStorageService) { }

  registerProductOld(product: any) : Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(product);
    console.log(body)
    return this.http.post(API_URL + "customer/", body,{'headers':headers})
      .pipe(catchError(this.errorHandler))
  }

  registerProduct(product: any) : Observable<Product> {
    const headers = { 'content-type': 'application/json',
                      'Authorization': 'Bearer ' + `${this.token.getToken()}`} ;

    return this.http.post<any>(API_URL + "product/", product, {'headers':headers});
  }

  errorHandler(error : HttpErrorResponse){
    return throwError(error);
  }

  getProducts() : Observable<Product[]>{

    return this.http
  .get<Product[]>(API_URL+"product")

}

registerSale(sale: any) : Observable<Sale> {
  const headers = { 'content-type': 'application/json',
                    'Authorization': 'Bearer ' + `${this.token.getToken()}`} ;

  return this.http.post<any>(API_URL + "sales/", sale, {'headers':headers});
}


getSale() : Observable<SavedSale[]>{
  const headers = { 'content-type': 'application/json',
                    'Authorization': 'Bearer ' + `${this.token.getToken()}`} ;

  return this.http
.get<SavedSale[]>(API_URL+"sales", {'headers':headers});

}

getSaleItems(saleId : number) : Observable<SaleItems[]>{
  const headers = { 'content-type': 'application/json',
                    'Authorization': 'Bearer ' + `${this.token.getToken()}`
                     } ;


  return this.http
.get<SaleItems[]>(API_URL+"saleItems/"+saleId, {'headers':headers});

}

getProductById(productId : number) : Observable<Product>{
  const headers = { 'content-type': 'application/json',
                    'Authorization': 'Bearer ' + `${this.token.getToken()}`
                     } ;


  return this.http
.get<Product>(API_URL+"product/"+productId, {'headers':headers});

}


}


