import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { ProductsComponent } from './products/products.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { UppercaseDirective } from 'app/uppercase.directive';
import { ProductService } from 'app/product.service';


const appRoutes: Routes = [
  {path: 'products', component: ProductsComponent },
  {path: 'products/:id', component: EditProductComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListProductsComponent,
    ProductsComponent,
    EditProductComponent,
    UppercaseDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
