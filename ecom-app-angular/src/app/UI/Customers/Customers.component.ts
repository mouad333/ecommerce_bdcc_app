import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
    selector: 'app-Customers',
    templateUrl: './Customers.component.html',
    styleUrls: ['./Customers.component.css']
})
export class CustomersComponent implements OnInit{
    public Customers : any;
    constructor(private http: HttpClient) {
    }
    title = 'ecom-app-angular';
    ngOnInit(): void {
        this.http.get("http://localhost:8087/Customers").subscribe({
            next : data =>{
                this.Customers = data;
            },
            error : err => {
                console.log(err);
            }
        })
    }
}