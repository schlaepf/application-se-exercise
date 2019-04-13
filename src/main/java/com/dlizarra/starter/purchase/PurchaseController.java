package com.dlizarra.starter.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {
  @Autowired
  private PurchaseService purchaseService;

  @RequestMapping(value = "/purchases", method = RequestMethod.GET)
  public List<PurchaseDto> findAll() {
    return purchaseService.getPurchases();
  }

  @RequestMapping(value = "/purchase", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody PurchaseDto purchaseDto) {
    purchaseService.createPurchase(purchaseDto);
  }

}
