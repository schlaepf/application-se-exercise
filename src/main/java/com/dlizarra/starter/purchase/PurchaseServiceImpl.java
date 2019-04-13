package com.dlizarra.starter.purchase;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{
  @Autowired
  private PurchaseRepository purchaseRepository;

  @Autowired
  private OrikaBeanMapper mapper;

  @Transactional
  @Override
  public void createPurchase(final PurchaseDto purchaseDto) {
    final Purchase purchase = mapper.map(purchaseDto, Purchase.class);
    purchaseRepository.save(purchase);
  }

  @Override
  public void updatePurchase(PurchaseDto user) {

  }

  @Override
  public void deletePurchase(Integer id) {

  }

  @Override
  public PurchaseDto getPurchase(Integer id) {
    return null;
  }

  @Override
  public List<PurchaseDto> getPurchases() {
    return null;
  }
}
