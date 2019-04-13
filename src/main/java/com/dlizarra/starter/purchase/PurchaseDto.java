package com.dlizarra.starter.purchase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@EqualsAndHashCode(of = { "id", "user", "name", "purchasedAt", "price"})
@ToString(of = { "user", "name", "purchasedAt", "price" })
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PurchaseDto {

  private Integer id;

  private String user;

  private String name;

  private Date purchasedAt;

  private double price;
}
