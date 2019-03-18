package com.apexford.carApp.repository;

import com.apexford.carApp.model.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {
  public List<CarPart> findByMake(String make);

  public List<CarPart> findByModel(String model);

  public List<CarPart> findByYear(int year);

  public CarPart findByPartID(Long id);
}
