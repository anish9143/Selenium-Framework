package com.Infrahedge.Scripts;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xslf.usermodel.XSLFSheet;

import org.eclipse.jetty.util.LazyList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.LogInPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class ValidLogin extends BaseTest {

	@Test
	public void testLogin() throws InterruptedException, IOException, AWTException {
		LogInPage l = new LogInPage(driver);
		String un = "Rashmi.L";
		String pw = "Jan@12345";
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		Thread.sleep(2000);

		l.clickAgreeButton(driver);

		Thread.sleep(5000);

		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		// Click on the new Barclays report image
		Thread.sleep(2000);
		// WebElement
		// Baeclays_IRF_Oct=driver.findElement(By.xpath("(//div[@class='row
		// license-monitor'])[1]"));
		//
		// wait.until(ExpectedConditions.visibilityOf(Baeclays_IRF_Oct));
		// Actions action =new Actions(driver);
		// action.moveToElement(Baeclays_IRF_Oct);
		Thread.sleep(2000);
		// Baeclays_IRF_Oct.click();
		l.clickBarclaysOctReport(driver);
		Thread.sleep(2000);
		// WebElement summary =
		// driver.findElement(By.xpath("//*[contains(text(),'BREACH
		// SUMMARY')]"));
		// Window handle
		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
		}

		// WebElement logo =
		// wait.until(ExpectedConditions.visibilityOf(summary));

		String title = driver.getTitle();
		System.out.println("title is-->" + title);

		// Click on BUK radio button
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		// System.out.println("Clicked the buk");

		// if (title.equalsIgnoreCase("Barclays IRF")) {
		// System.out.println("LogIn Sucessful !");
		// } else {
		// System.out.println("LogIn not successful !");
		//
		// }

		// IP1 green/success profiles check Vol

	}
}
