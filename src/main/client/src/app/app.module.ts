import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ScratchComponent } from './scratch/scratch.component';
import {HttpClientModule} from "@angular/common/http";
import { CreatePurchaseComponent } from './create-purchase/create-purchase.component';
import { PurchasesComponent } from './purchases/purchases.component';
import {FormsModule} from "@angular/forms";

const appRoutes: Routes = [
  {
    path: 'purchases',
    component: PurchasesComponent
  },
  {
    path: 'createPurchase',
    component: CreatePurchaseComponent
  },
  { path: '',
    redirectTo: '/',
    pathMatch: 'full'
  }
];



@NgModule({
  declarations: [
    AppComponent,
    ScratchComponent,
    PurchasesComponent,
    CreatePurchaseComponent,
    PurchasesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes
    ),
    FormsModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
