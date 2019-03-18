package com.apexford.carApp.controller;

import com.apexford.carApp.model.CarPart;
import com.apexford.carApp.service.CarPartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/carparts")
public class CarPartController {

  @Autowired
  private CarPartService caprPartService;

  @ApiOperation(value = "Displays list of car parts")
  @GetMapping(value = "/list")
  public List<CarPart> listAllCarParts() {
    return caprPartService.findAllCarParts();
  }

  @ApiOperation(value = "Search car part by make")
  @GetMapping(value = "/make/{make}")
  public List<CarPart> searchByMake(@PathVariable String make) {
    return caprPartService.searchByMake(make);
  }

  @ApiOperation(value = "Search car part by model")
  @GetMapping(value = "/model/{model}")
  public List<CarPart> searchByModel(@PathVariable String model) {
    return caprPartService.searchByModel(model);
  }

  @ApiOperation(value = "Search car part by year")
  @GetMapping(value = "/year/{year}")
  public List<CarPart> searchByYear(@PathVariable int year) {
    return caprPartService.searchByYear(year);
  }

  @ApiOperation(value = "Search car part by id")
  @GetMapping(value = "/partID/{id}")
  public CarPart searchByPartID(@PathVariable Long id) {
    return caprPartService.searchByPartID(id);
  }

  @ApiOperation(value = "Add new car part")
  @PostMapping
  public Long addCar(@Valid @RequestBody CarPart carPart) {
    System.out.println(carPart);
    Long partId = caprPartService.addCar(carPart);
    return partId;
  }

  @ApiOperation(value = "Delete car part by id")
  @DeleteMapping(value = "/{id}")
  public CarPart removeCar(@PathVariable Long id) {
    return caprPartService.removeCar(id);
  }
}
