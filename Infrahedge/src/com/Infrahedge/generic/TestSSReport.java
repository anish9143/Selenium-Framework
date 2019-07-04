package com.Infrahedge.generic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSSReport extends BaseTest {

	
	@Test
	public void testSampleSS()
	{
		driver.get("https://www.google.com");
		Assert.assertTrue(driver.getTitle().contains("Anish"));
	}
	
}
