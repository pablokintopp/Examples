import { Component, OnInit } from '@angular/core';
import { Product } from 'app/product';
import { ProductService } from 'app/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];

  constructor(
    private service: ProductService
  ) { }

  ngOnInit() {  
    this.products = this.service.getProducts();
  }

}
