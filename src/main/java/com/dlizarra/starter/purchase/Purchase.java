package com.dlizarra.starter.purchase;

import com.dlizarra.starter.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "purchases")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //  @OneToOne(fetch = FetchType.EAGER)
  @Column(nullable = false)
  private String user;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Date purchasedAt;

  @Column(nullable = false)
  private int price;

  public Purchase() {
  }

  public Purchase(final Purchase purchase) {
    this.id = purchase.id;
    this.user = purchase.user;
    this.name = purchase.name;
    this.purchasedAt = purchase.purchasedAt;
    this.price = purchase.price;
  }
}
