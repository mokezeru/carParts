package com.apexford.carApp.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import springfox.documentation.spring.web.plugins.Docket;

@RunWith(SpringRunner.class)
public class SwaggerConfigTest {
	
	@InjectMocks
	SwaggerConfig swaggerConfig;
	String hello;

	@Test
	public void testApi() {
		Assert.assertTrue(swaggerConfig.api() instanceof Docket);
	}

}
