package com.dlizarra.starter.purchase;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(of = { "id", "user", "name", "purchasedAt", "price"})
@ToString(of = { "user", "name", "purchasedAt", "price" })
@Setter
@Getter
@Entity
@Table(name = "purchases")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //@OneToMany(fetch = FetchType.EAGER)
  @Column(nullable = false)
  // This should actually be a member variable of type User. I could not figure out how to model
  // the relationship mapping in JPA so I just stored user name as a string.
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
