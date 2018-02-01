import { Input , Component, OnInit } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {  

  @Input() products: Product[] = [];

  constructor() { }

  ngOnInit() {
  }

}
