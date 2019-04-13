package com.dlizarra.starter.purchase;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
  public void updatePurchase(Integer id, PurchaseDto purchaseDto) {
    final Purchase newPurchase = mapper.map(purchaseDto, Purchase.class);
    purchaseRepository.save(newPurchase);
  }

  @Override
  public void deletePurchase(Integer id) {
    purchaseRepository.delete(id);
  }

  @Transactional(readOnly = true)
  @Override
  public PurchaseDto getPurchase(Integer id) {
    return mapper.map(find(id), PurchaseDto.class);
  }

  @Transactional(readOnly = true)
  @Override
  public List<PurchaseDto> getPurchases() {
    final List<Purchase> purchases = purchaseRepository.findAll(new Sort("id"));
    final List<PurchaseDto> purchaseDto = new ArrayList<PurchaseDto>();
    purchases.forEach(x -> purchaseDto.add(mapper.map(x, PurchaseDto.class)));

    return purchaseDto;
  }

  @Transactional(readOnly = true)
  private Purchase find(Integer id) {
    final Optional<Purchase> userOpt = purchaseRepository.findOne(id);
    return userOpt.orElseThrow(() -> new PurchaseNotFoundException(id));
  }
}
