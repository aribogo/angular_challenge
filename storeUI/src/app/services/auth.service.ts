import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const LOG_IN = 'http://localhost:8080/v1/auth/';
const SIGN_UP = 'http://localhost:8080/v1/customer/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(LOG_IN, {
      username,
      password
    }, httpOptions);
  }

  register(name: string, email: string, cpf: string): Observable<any> {
    return this.http.post(SIGN_UP, {
      name,
      cpf,
      email
    }, httpOptions);
  }

}
