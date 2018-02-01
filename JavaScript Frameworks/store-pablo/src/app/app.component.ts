import { Component } from '@angular/core';
import { Product } from './product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent { 
  products : Product[] = [];
  title = 'app works!';

  constructor (){
  
    let p = new Product();
    p.id = 1;
    p.name = "ProdutoNome";
    this.products.push(p);
  
  }
}


