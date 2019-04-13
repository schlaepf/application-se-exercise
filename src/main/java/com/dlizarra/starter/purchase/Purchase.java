package com.dlizarra.starter.purchase;

import com.dlizarra.starter.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "purchases")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
//  @OneToOne(fetch = FetchType.EAGER)
  private String user;

  @Column(nullable = false)
  private LocalDateTime purchasedAt;

  @Column(nullable = false)
  private int price;

  public Purchase() {
  }

  public Purchase(final Purchase purchase) {
    this.id = purchase.id;
    this.user = purchase.user;
    this.purchasedAt = purchase.purchasedAt;
    this.price = purchase.price;
  }
}