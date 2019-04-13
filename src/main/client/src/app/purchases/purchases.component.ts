import {Component, OnDestroy, OnInit} from '@angular/core';
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
  sumOfAllPurchases: number;

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
        this.calculateSumOfAllPurchases();
        console.log(this.purchases);
      });
  }

  private calculateSumOfAllPurchases() {
    this.sumOfAllPurchases = 0;
    this.purchases.forEach(purchase => this.sumOfAllPurchases += purchase.price);
  }

  deletePurchase(id: number) {
    const purchaseToDelete = this.purchases[id];
    this.httpClient.delete("api/purchase/" + purchaseToDelete.id)
      .subscribe( resp => {
        console.log('Purchase successfully deleted!');
        this.purchases.splice(id, 1);
        this.calculateSumOfAllPurchases();
      }, err => {
        console.log('Purchase could not be deleted!');
      });
  }
}
