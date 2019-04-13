import { Component, OnInit } from '@angular/core';
import {User} from "../scratch/user";
import {HttpClient} from "@angular/common/http";
import {Purchase} from "../model/Purchase";

@Component({
  selector: 'app-create-purchase',
  templateUrl: './create-purchase.component.html',
  styleUrls: ['./create-purchase.component.css']
})
export class CreatePurchaseComponent implements OnInit {

  selectedUser: User;
  productName: string;
  purchasedAt: Date;
  price: number;

  purchase: Purchase;

  users: Array<User>;

  responseMessage: string;

  constructor(private httpClient:HttpClient) {
    this.users = [];
    this.purchase = new Purchase();
    this.loadUsers();
  }

  ngOnInit() {
  }

  private loadUsers() {
    this.httpClient.get<User[]>("api/users")
      .subscribe(resp => {
        this.users = resp;
      });
  }

  postPurchase() {
    this.httpClient.post("/api/purchase", this.purchase).subscribe(
      resp => {
        this.responseMessage = "Purchase successfully saved!";
      },
      err => {
        this.responseMessage = "There was an error while saving the purchase. Please try again.";
      }
    );
  }

}
