package org.springframework.amqp.tutorials;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String name;

  @Column
  private Integer qty;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "Product_Order",
      joinColumns = { @JoinColumn(name = "product_id") },
      inverseJoinColumns = { @JoinColumn(name = "order_id") }
  )
  private List<Order> orders = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}
