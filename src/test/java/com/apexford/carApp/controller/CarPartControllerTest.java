package com.apexford.carApp.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.apexford.carApp.model.CarPart;
import com.apexford.carApp.service.CarPartService;

@RunWith(SpringRunner.class)
public class CarPartControllerTest {
	
	@Mock CarPartService carService;
	
	@InjectMocks 
	CarPartController carPartController;
	String hello;

	/**
	 * to test the behaviors of listAllCarParts method of the controller.
	 */
	@Test
	public void testListAllCarParts() {
		//GIVE
		List<CarPart> fordCarPart = new ArrayList<>();
		CarPart cp1 = new CarPart();
		cp1.setMake("Ford");
		CarPart cp2 = new CarPart();
		cp2.setMake("Toyota");
		fordCarPart.add(cp1);
		fordCarPart.add(cp2);

		//WHEN
		when(carService.findAllCarParts()).thenReturn(fordCarPart);

		List<CarPart> result = carPartController.listAllCarParts();

		//THEN
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("Toyota", result.get(1).getMake());
	}
	/**
	 * to test the behaviors of searchByMake method of the controller.
	 */
	@Test
	public void testSearchByMake() {
		//GIVE
		String make1 = "Ford";
		List<CarPart> fordCarPart = new ArrayList<>();
		CarPart cp1 = new CarPart();
		cp1.setMake("Ford");
		fordCarPart.add(cp1);
		
		//WHEN
		when(carService.searchByMake(Mockito.anyString())).thenReturn(fordCarPart);
		
		List<CarPart> result = carPartController.searchByMake("Ford");
		
		//THEN
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Ford", result.get(0).getMake());
	}
	
	/**
	 * to test the behaviors of searchByModel method of the controller.
	 */
	@Test
	public void testSearchByModel() {
		//GIVE
		String make = "Fusion";
		List<CarPart> fordCarPart = new ArrayList<>();
		CarPart cp1 = new CarPart();
		cp1.setModel("Fusion");
		fordCarPart.add(cp1);
		
		//WHEN
		when(carService.searchByModel(Mockito.anyString())).thenReturn(fordCarPart);
		
		List<CarPart> result = carPartController.searchByModel("Fusion");
		
		//THEN
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Fusion", result.get(0).getModel());
	}
	
	/**
	 * to test the behavior of searchByYear method of the controller.
	 */
	@Test
	public void testSearchByYear() {
		//GIVE
		int makeYear = 2019;
		List<CarPart> fordCarPart = new ArrayList<>();
		CarPart cp1 = new CarPart();
		cp1.setYear(makeYear);
		fordCarPart.add(cp1);
		
		//WHEN
		when(carService.searchByYear(Mockito.anyInt())).thenReturn(fordCarPart);
		
		List<CarPart> result = carPartController.searchByYear(makeYear);
		
		//THEN
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(makeYear, result.get(0).getYear());
	}
	
	/**
	 * to test the behaviors of searchByPartID method of the controller.
	 */
	@Test
	public void testSearchByPartID() {
		//GIVE
		long partId = 1;
		CarPart cp1 = new CarPart();
		cp1.setPartID(partId);
		
		//WHEN
		when(carService.searchByPartID(Mockito.anyLong())).thenReturn(cp1);
		
		CarPart result = carPartController.searchByPartID(partId);
		
		//THEN
		Assert.assertEquals(cp1.getPartID(), result.getPartID());
	}
	
	/**
	 * to test the behavior of addCar method of the controller.
	 */
	@Test
	public void testAddCar() {
		//GIVE
		long partId = 1;
		CarPart cp1 = new CarPart();
		cp1.setPartID(partId);
		
		//WHEN
		when(carService.addCar(Mockito.any())).thenReturn(partId);
		
		long result = carPartController.addCar(cp1);
		
		//THEN
		Assert.assertEquals(partId, result);
	}
	
	/**
	 * to test the behavior of removeCar method of the controller.
	 */
	@Test
	public void testRemoveCar() {
		//GIVE
		long partId = 1;
		CarPart cp1 = new CarPart();
		cp1.setPartID(partId);
		
		//WHEN
		when(carService.removeCar(Mockito.anyLong())).thenReturn(cp1);
		
		CarPart result = carPartController.removeCar(partId);
		
		//THEN
		Assert.assertEquals(cp1, result);
	}

}
