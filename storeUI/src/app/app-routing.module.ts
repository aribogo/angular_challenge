import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayProductsComponent } from './display-products/display-products.component';
import { LoginComponent } from './login/login.component';
import { RegisterProductComponent } from './register-product/register-product.component';
import { RegisterComponent } from './register/register.component';
import { SaleComponent } from './sale/sale.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: RegisterComponent},
  {path: 'register', component: RegisterProductComponent},
  {path: '', component: DisplayProductsComponent},
  {path: 'shopping-cart', component: ShoppingCartComponent},
  {path: 'orders', component: SaleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
