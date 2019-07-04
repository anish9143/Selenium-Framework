package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BreachSummaryPage {

	// SAA elements

	@FindBy(xpath ="//*/div/table/tbody/tr/td[3]/div")
	//table/tbody[1]/tr[1]/td[3]/div/div[1]
	//*/div/table/tbody/tr/td[3]/div
	private WebElement IP1_SAA_VOL_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[3]/div/div[2]")

	private WebElement IP1_SAA_VOL_Amber_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[3]/div/div[1]")

	private WebElement IP1_SAA_VAR_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[3]/div/div[2]")

	private WebElement IP1_SAA_VAR_Amber_Progress;

	// TAA elements

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[4]/div/div[1]")

	private WebElement IP1_TAA_VOL_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[4]/div/div[3]")

	private WebElement IP1_TAA_VOL_Red_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[4]/div/div[1]")

	private WebElement IP1_TAA_VAR_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[4]/div/div[2]")

	private WebElement IP1_TAA_VAR_Amber_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[4]/div/div[3]")

	private WebElement IP1_TAA_VAR_Red_Progress;

	// Model elements

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[5]/div/div[1]")

	private WebElement IP1_Model_VOL_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[5]/div/div[3]")

	private WebElement IP1_Model_VOL_Red_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[5]/div/div[1]")

	private WebElement IP1_Model_VAR_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[5]/div/div[2]")

	private WebElement IP1_Model_VAR_Amber_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[5]/div/div[3]")

	private WebElement IP1_Model_VAR_Red_Progress;

	// Portfolio elements

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[6]/div/div[1]")

	private WebElement IP1_Portfolio_VOL_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[6]/div/div[2]")

	private WebElement IP1_Portfolio_VOL_Amber_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[1]/tr/td[6]/div/div[3]")

	private WebElement IP1_Portfolio_VOL_Red_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[6]/div/div[1]")

	private WebElement IP1_Portfolio_VAR_Green_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[6]/div/div[2]")

	private WebElement IP1_Portfolio_VAR_Amber_Progress;

	@FindBy(xpath = "//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[6]/div/div[3]")

	private WebElement IP1_Portfolio_VAR_Red_Progress;

	
	public BreachSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void click_IP1_SAA_VOL_Green_Progress() {
		IP1_SAA_VOL_Green_Progress.click();

	}

	public void click_IP1_SAA_VOL_Amber_Progress() {
		IP1_SAA_VOL_Amber_Progress.click();

	}

	public void click_IP1_TAA_VOL_Green_Progress() {
		IP1_TAA_VOL_Green_Progress.click();

	}

	public void click_IP1_TAA_VOL_Red_Progress() {
		IP1_TAA_VOL_Red_Progress.click();

	}

	public void click_IP1_Model_VOL_Green_Progress() {
		IP1_Model_VOL_Green_Progress.click();

	}

	public void click_IP1_Model_VOL_Red_Progress() {
		IP1_Model_VOL_Red_Progress.click();

	}

	public void click_IP1_Portfolio_VOL_Green_Progress() {
		IP1_Portfolio_VOL_Green_Progress.click();

	}

	public void click_IP1_Portfolio_VOL_Amber_Progress() {
		IP1_Portfolio_VOL_Amber_Progress.click();

	}

	public void click_IP1_Portfolio_VOL_Red_Progress() {
		IP1_Portfolio_VOL_Red_Progress.click();

	}

}
