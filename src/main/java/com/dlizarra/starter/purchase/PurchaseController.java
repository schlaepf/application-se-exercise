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

  @RequestMapping(value = "/purchase/{id}", method = RequestMethod.GET)
  public PurchaseDto findByID(@PathVariable int id) {
    return purchaseService.getPurchase(id);
  }

  @RequestMapping(value = "/purchase/{id}", method = RequestMethod.DELETE)
//  @ResponseStatus(HttpStatus.OK)
  public void create(@PathVariable int id) {
    purchaseService.deletePurchase(id);
  }

}
