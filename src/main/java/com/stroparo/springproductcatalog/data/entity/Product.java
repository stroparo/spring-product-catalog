package com.stroparo.springproductcatalog.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {
  
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "DESC")
  private String desc;
  
  @Column(name = "VALUE")
  private BigDecimal value;
  
  @Column(name = "DATE_CREATED")
  private LocalDateTime dateCreated;
  
  @Column(name = "ACTIVE")
  private boolean active;
}
