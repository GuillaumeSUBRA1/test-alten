import { NgModule } from '@angular/core';
import { ProductsComponent } from './products/products.component';
import { ProductsService } from './service/products-service.service';
import { ProductsRoutingModule } from './products-routing.module';
import { CommonModule } from '@angular/common';
import { PrimeNGModule } from 'app/shared/utils/primeng/primeng.module';
import { SharedModule } from 'app/shared/shared.module';
import { TagModule } from 'primeng/tag';
import { FormsModule } from '@angular/forms';
import { PanelModule } from 'primeng/panel';
import { ProductAdministrationComponent } from './product-administration/product-administration.component';

@NgModule({
    declarations: [
        ProductsComponent,
        ProductAdministrationComponent
    ],
    providers: [ProductsService],
    imports: [
      CommonModule,
      ProductsRoutingModule,
      PrimeNGModule,
      SharedModule,
      TagModule,
      FormsModule,
      PanelModule
    ],
})
export class ProductsModule {}
