import { Component, OnInit } from '@angular/core';
import {Purchase} from "../model/Purchase";
import {HttpClient} from "@angular/common/http";
import {User} from "../scratch/user";

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.css']
})
export class PurchasesComponent implements OnInit {

  purchases: Array<Purchase>;

  constructor(private httpClient:HttpClient) {
    this.purchases = [];
    this.loadPurchases();
  }

  ngOnInit() {

  }

  private loadPurchases() {
    this.httpClient.get<Purchase[]>("api/purchases")
      .subscribe(resp => {
        this.purchases = resp;
        console.log(this.purchases);
      });
  }

  deletePurchase(id: number) {
    const purchaseToDelete = this.purchases[id];
    this.httpClient.delete("api/purchase/" + purchaseToDelete.id)
      .subscribe( resp => {
        console.log('Purchase successfully deleted!');
        this.purchases.splice(id, 1);
      }, err => {
        console.log('Purchase could not be deleted!');
      });
  }

}
