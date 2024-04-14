import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
    selector: 'app-Products',
    templateUrl: './Products.component.html',
    styleUrls: ['./Products.component.css']
})
export class ProductsComponent implements OnInit{
    public Products : any;
    constructor(private http: HttpClient) {
    }
    title = 'ecom-app-angular';
    ngOnInit(): void {
        this.http.get("http://localhost:8087/Products").subscribe({
            next : data =>{
                 this.Products = data;
            },
            error : err => {
                console.log(err);
            }
        })
    }
}