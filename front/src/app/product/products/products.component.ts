import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../service/products-service.service';
import { Product, sortKeyList, sortOptionList } from '../product.model';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { SearchParams, Sort } from 'app/shared/ui/list/search.model';

@UntilDestroy()
@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  sortOptions = sortOptionList;
  sortKeys = sortKeyList;
  sortKey:string;
  products: Product[] = [];

  constructor(private productService: ProductsService) { }

  ngOnInit(): void {
    this.productService.findAll()
      .pipe(untilDestroyed(this))
      .subscribe(p => this.products = p);
  }

  filtered(p: SearchParams) {
    this.sortKey = p.sortField;
  }

  onSortKeyChange() { }

  getSeverity(severity: String) {
    switch (severity) {
      case "INSTOCK": return "success";
      case "OUTOFSTOCK": return "danger";
      case "LOWSTOCK": return "warning";
      default: return null;
    }
  }
}
