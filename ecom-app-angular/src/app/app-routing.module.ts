import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./UI/Products/Products.component";
import {CustomersComponent} from "./UI/Customers/Customers.component";
import {AuthGuard} from "./guards/auth.guard";


const routes: Routes = [
  { path: "Customers", component: CustomersComponent, canActivate : [AuthGuard] , data:{roles : ["USER"]}},
  { path: "Products", component: ProductsComponent , canActivate : [AuthGuard] , data:{roles : ["ADMIN"]}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
