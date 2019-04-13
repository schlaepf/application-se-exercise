package com.dlizarra.starter.purchase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@EqualsAndHashCode(of = { "id", "user", "purchasedAt", "price"})
@ToString(of = { "user", "purchasedAt", "price" })
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PurchaseDto {

  private Integer id;

  private String user;

  private LocalDateTime purchasedAt;

  private int price;
}
