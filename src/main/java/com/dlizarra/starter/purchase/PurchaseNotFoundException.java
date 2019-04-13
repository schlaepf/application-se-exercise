package com.dlizarra.starter.purchase;

public class PurchaseNotFoundException extends RuntimeException {
  public PurchaseNotFoundException(final Integer id) {
    super("Could not find Purchase with id: " + id);
  }
}
