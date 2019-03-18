package com.apexford.carApp.service;

import com.apexford.carApp.model.CarPart;
import java.util.List;

public interface CarPartService {
  public Long addCar(CarPart carPart);

  public CarPart removeCar(Long id);

  public List<CarPart> searchByMake(String make);

  public List<CarPart> searchByModel(String model);

  public List<CarPart> searchByYear(int year);

  public CarPart searchByPartID(Long id);

  public List<CarPart> findAllCarParts();
}
