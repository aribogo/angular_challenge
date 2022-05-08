import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './general/nav-bar/nav-bar.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { RegisterProductComponent } from './register-product/register-product.component';
import { DisplayProductsComponent } from './display-products/display-products.component';
import { SafeHtml } from './helpers/safeHtml';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { SaleComponent } from './sale/sale.component';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    RegisterComponent,
    LoginComponent,
    RegisterProductComponent,
    DisplayProductsComponent,
    SafeHtml,
    ShoppingCartComponent,
    SaleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [ authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
