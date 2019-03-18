package com.apexford.carApp.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.meanbean.test.BeanTester;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CarPartTest {

	@Test
	public void testSettersAndGetters() {
		BeanTester carPartTester = new BeanTester();
		carPartTester.testBean(CarPart.class);
	}

}
