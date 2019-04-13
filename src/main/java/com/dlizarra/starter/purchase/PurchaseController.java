package com.dlizarra.starter.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {
  @Autowired
  private PurchaseService purchaseService;

  @RequestMapping(value = "/purchases", method = RequestMethod.GET)
  public List<PurchaseDto> findAll() {
    return purchaseService.getPurchases();
  }

}
