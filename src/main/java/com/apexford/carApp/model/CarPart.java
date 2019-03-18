package com.apexford.carApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CarPart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long partID;
  private String make;
  private String model;
  private int year;

  public CarPart() {}

  public CarPart(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

}
