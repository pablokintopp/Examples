import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'app/product';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  product: Product;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    // this.route.snapshot.params['id'];
    this.product = new Product();
    this.product.id = 1;
    this.product.name = 'Produto teste';
  }

  save(){
    console.log('save');
  }

  
  get debug() : string {
    return JSON.stringify(this.product);
  }
  




}
