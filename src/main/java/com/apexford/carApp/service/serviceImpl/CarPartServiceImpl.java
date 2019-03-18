package com.apexford.carApp.service.serviceImpl;

import com.apexford.carApp.model.CarPart;
import com.apexford.carApp.repository.CarPartRepository;
import com.apexford.carApp.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarPartServiceImpl implements CarPartService {

  @Autowired
  private CarPartRepository carPartRepository;

  @Override
  public Long addCar(CarPart carPart) {
    carPart = carPartRepository.save(carPart);
    Long carPartPartID = carPart.getPartID();
    return carPartPartID;
  }

  @Override
  public CarPart removeCar(Long id) {
    CarPart carPart = carPartRepository.findByPartID(id);
    carPartRepository.deleteById(carPart.getPartID());
    return carPart;
  }

  @Override
  public List<CarPart> searchByMake(String make) {
    return carPartRepository.findByMake(make);
  }

  @Override
  public List<CarPart> searchByModel(String model) {
    return carPartRepository.findByModel(model);
  }

  @Override
  public List<CarPart> searchByYear(int year) {
    return carPartRepository.findByYear(year);
  }

  @Override
  public CarPart searchByPartID(Long id) {
    return carPartRepository.findByPartID(id);
  }

  @Override
  public List<CarPart> findAllCarParts() {
    return carPartRepository.findAll();
  }
}
