import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { ProductAdministrationComponent } from './product-administration/product-administration.component';

const routes: Routes = [
  { path: '',redirectTo:'products', pathMatch:"full"},
  { path: 'products', component:ProductsComponent},
  { path: 'products-admin', component:ProductAdministrationComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})

export class ProductsRoutingModule {}
