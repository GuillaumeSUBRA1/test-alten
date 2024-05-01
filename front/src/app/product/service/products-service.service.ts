import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private url: string = 'http://localhost:8080/products';
  optionRequete = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*'
    })
  };

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url + '/all');
  }

  public deleteByIds(ids: number[]): Observable<any> {
    return this.http.post<number[]>(this.url + '/delete',ids);
  }
  
  public save(product: Product): Observable<Product> {
    return this.http.patch<Product>(this.url + '/save', product);
  }
}
