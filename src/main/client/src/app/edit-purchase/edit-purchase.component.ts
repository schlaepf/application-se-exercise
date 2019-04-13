import {Component, Input, OnInit} from '@angular/core';
import {Purchase} from "../model/Purchase";
import {User} from "../scratch/user";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-edit-purchase',
  templateUrl: './edit-purchase.component.html',
  styleUrls: ['./edit-purchase.component.css']
})
export class EditPurchaseComponent implements OnInit {

  purchase: Purchase;

  users: Array<User>;

  responseMessage: string;

  constructor(private httpClient: HttpClient, private route: ActivatedRoute) {
    this.loadUsers();
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.loadPurchase(params['id']);
    });
  }

  private loadUsers() {
    this.httpClient.get<User[]>("api/users")
      .subscribe(resp => {
        this.users = resp;
      });
  }

  private loadPurchase(id: number) {
    this.httpClient.get<Purchase>("api/purchase/" + id)
      .subscribe(resp => {
        this.purchase = resp;
        console.log(resp);
      });
  }

  private updatePurchase() {
    this.httpClient.put("api/purchase/" + this.purchase.id, this.purchase)
      .subscribe(resp => {
          this.responseMessage = "Update successful!";
        },
        err => {
          this.responseMessage = "There was an error while saving the purchase. Please try again.";
          console.log(err);
        });
  }

}
