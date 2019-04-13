package com.dlizarra.starter.purchase;

import java.util.List;

public interface PurchaseService {
  void createPurchase(PurchaseDto purchase);

  void updatePurchase(PurchaseDto user);

  void deletePurchase(Integer id);

  PurchaseDto getPurchase(Integer id);

  List<PurchaseDto> getPurchases();
}
