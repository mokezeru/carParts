package com.apexford.carApp.service.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
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
import com.apexford.carApp.repository.CarPartRepository;

@RunWith(SpringRunner.class)
public class CarPartServiceImplTest {
	
	@Mock CarPartRepository carRepository;
	
	@InjectMocks
	CarPartServiceImpl CarPartService;
	String hello;

	/**
	 * to test the behaviour of addCar method of the service.
	 */
	@Test
	public void testAddCar() {
		//GIVEN
		long partId = 1;
		 CarPart carPart = new CarPart("Ford","Fusion",2019);
		 carPart.setPartID(partId);
		 
		 //WHEN
		 when(carRepository.save(Mockito.any())).thenReturn(carPart);
		 
		 long result = CarPartService.addCar(carPart);
		 
		 //THEN
		 Assert.assertEquals(partId, result);
	}
	
	/**
	 * to test the behavior of removeCar method of the service.
	 */
	@Test
	public void testRemoveCar() {
		//GIVEN
		long partId = 1;
		 CarPart carPart = new CarPart("Ford","Fusion",2019);
		 carPart.setPartID(partId);
		 
		 //WHEN
		 when(carRepository.findByPartID(Mockito.anyLong())).thenReturn(carPart);
		 doNothing().when(carRepository).deleteById(Mockito.anyLong());
		 
		 CarPart result = CarPartService.removeCar(partId);
		 
		 //THEN
		 Assert.assertEquals(carPart, result);
	}

	/**
	 * to test the behaviors of listAllCarParts method of the service.
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
		when(carRepository.findAll()).thenReturn(fordCarPart);

		List<CarPart> result = CarPartService.findAllCarParts();

		//THEN
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("Toyota", result.get(1).getMake());
	}


	/**
	 * to test the behaviors of searchByMake method of the service.
	 */
	@Test
	public void testSearchByMake() {
		//GIVE
		String make = "Ford";
		List<CarPart> fordCarPart = new ArrayList<>();
		CarPart cp1 = new CarPart();
		cp1.setMake("Ford");
		fordCarPart.add(cp1);
		
		//WHEN
		when(carRepository.findByMake(Mockito.anyString())).thenReturn(fordCarPart);
		
		List<CarPart> result = CarPartService.searchByMake("Ford");
		
		//THEN
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Ford", result.get(0).getMake());
	}
	
	/**
	 * to test the behavior of searchByModel method of the service.
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
		when(carRepository.findByModel(Mockito.anyString())).thenReturn(fordCarPart);
		
		List<CarPart> result = CarPartService.searchByModel("Fusion");
		
		//THEN
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Fusion", result.get(0).getModel());
	}
	
	/**
	 * to test the behaviors of searchByYear method of the service.
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
		when(carRepository.findByYear(Mockito.anyInt())).thenReturn(fordCarPart);
		
		List<CarPart> result = CarPartService.searchByYear(makeYear);
		
		//THEN
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(makeYear, result.get(0).getYear());
	}
	
	
	/**
	 * to test the behavior of searchByPartID method of the service.
	 */
	@Test
	public void testSearchByPartID() {
		//GIVE
		long partId = 1;
		CarPart cp1 = new CarPart();
		cp1.setPartID(partId);
		
		//WHEN
		when(carRepository.findByPartID(Mockito.anyLong())).thenReturn(cp1);
		
		CarPart result = CarPartService.searchByPartID(partId);
		
		//THEN
		Assert.assertEquals(cp1.getPartID(), result.getPartID());
	}

}
