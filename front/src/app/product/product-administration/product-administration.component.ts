import { Component, OnInit } from '@angular/core';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { ProductsService } from '../service/products-service.service';
import { Product, categories, stock, tableColumns } from '../product.model';
import { CrudItemOptions } from 'app/shared/utils/crud-item-options/crud-item-options.model';
import { ControlType } from 'app/shared/utils/crud-item-options/control-type.model';
import { SnackbarService } from 'app/shared/utils/snackbar/snackbar.service';
import { catchError } from 'rxjs';

@UntilDestroy()
@Component({
  selector: 'app-product-administration',
  templateUrl: './product-administration.component.html',
  styleUrls: ['./product-administration.component.scss']
})
export class ProductAdministrationComponent implements OnInit {
  newProduct = Product;
  config: CrudItemOptions[];
  products: Product[];
  productEntity: Product;

  constructor(private productService: ProductsService, private snackbarService: SnackbarService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(){
    this.productService.findAll()
      .pipe(untilDestroyed(this))
      .subscribe(p => { this.products = p; this.getColumns() });
  }

  getColumns() {
    this.config = tableColumns.map((c) => {
      return {
        key: c,
        label: this.getlabel(c),
        type: this.getType(c),
        controlType: this.getControlType(c),
        options: this.getOptions(c),
        controlOptions: { hideOnCreate: this.getHideOnCreate(c), hideOnUpdate: this.getHideOnUpdate(c) },
        columnOptions: { sortable: true, filterable: true, default: this.getDefault(c) }
      };
    }
    );
  }

  getlabel(c: string): string {
    return c === 'inventoryStatus' ? 'inventory status' : c;
  }

  getControlType(c: string): ControlType {
    return c === 'category' || c === 'inventoryStatus' ? ControlType.SELECT : ControlType.INPUT;
  }

  getHideOnCreate(c: string): boolean {
    return c === 'id';
  }

  getHideOnUpdate(c: string): boolean {
    return c === 'id';
  }

  getDefault(c: string): boolean {
    return c === 'code' || c === 'name';
  }

  getType(c: string): string {
    return c === 'price' || c === 'quantity' || c === 'rating' ? 'number' : 'text';
  }

  getOptions(c: string) {
    if (c === 'category') {
      return categories.map((c) => { return { value: c, label: c } });
    }
    if (c === 'inventoryStatus') {
      return stock.map((c) => { return { value: c, label: c } });
    }
    return undefined;
  }

  save(product: Product) {
    this.productService.save(product)
    .pipe(untilDestroyed(this), catchError(async (_) => this.snackbarService.displayError("Saving failed")))
    .subscribe(data => {
      if(typeof data === 'object'){
        let itemToUpdate = this.products.findIndex((p) => p.id === data.id);
        if(itemToUpdate === -1){ this.products.push(data)}
        else {this.products[itemToUpdate] = data;}
      }
    });
  }

  delete(ids: number[]) {
    this.productService.deleteByIds(ids)
    .pipe(untilDestroyed(this), catchError(async (_) => this.snackbarService.displayError("Delete failed")))
    .subscribe((_) =>
      this.products = this.products.filter((p) => !ids.includes(p.id))
    );
  }
}
