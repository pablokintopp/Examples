import { Injectable } from '@angular/core';
import { Product } from 'app/product';

@Injectable()
export class ProductService {
    
    constructor() { }

        getProducts(){

            let products: Product[] = [];

            let p1 = new Product();
            p1.id = 1;
            p1.name = 'macarrão';

            let p2 = new Product();
            p2.id = 2;
            p2.name = 'Feijão';

            let p3 = new Product();
            p3.id = 3;
            p3.name = 'Arroz';

            let p4 = new Product();
            p4.id = 4;
            p4.name = 'Banana';

            products.push(p1, p2, p3, p4);

            return products;
        }
}