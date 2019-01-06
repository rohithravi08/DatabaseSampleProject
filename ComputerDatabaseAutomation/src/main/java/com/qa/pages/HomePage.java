package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	
	
	//page factory-object repository
	
	@FindBy(linkText="Play sample application — Computer database")
	WebElement link_home;
	
	@FindBy(xpath="//section[@id=\"main\"]/h1")
	WebElement txt_totalComputer;
	
	@FindBy(xpath="//a[@class=\"btn success\"]")
	WebElement btn_addComputer;
	
	@FindBy(xpath="//input[@id=\"searchsubmit\"]")
	WebElement btn_filterByName;
	
	@FindBy(xpath="//input[@id=\"searchbox\"]")
	WebElement txtBox_findComputer;
	
	@FindBy(xpath="//div[@class=\"well\"]/em")
	WebElement msg_NothingToDisplay;
	
	@FindBy(xpath="//div[@class=\"alert-message warning\"]")
	WebElement alert_computerAdded;
	
	@FindBy(xpath="//table[@class=\"computers zebra-striped\"]/tbody/tr[1]")
	WebElement searchElement;
	
	@FindBy(xpath="//table[@class=\"computers zebra-striped\"]/tbody/tr[1]/td[1]/a")
	WebElement searchFirstElement;
	
	@FindBy(xpath="//div[@class=\"well\"]/em")
	WebElement txt_nothingToDisplay;
	
	//initialising the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	public int numberOfComputerValdaton() {
		String totComputer=txt_totalComputer.getText();
		String[] arr=totComputer.split(" ");
		return Integer.parseInt(arr[0]);
	}
	public boolean addComputerButtonPresent() {
		return btn_addComputer.isDisplayed();
	}
	public AddComputer addComputer() {
		btn_addComputer.click();		
		return new AddComputer();
	}
	public boolean alertPresesnt() {
		return alert_computerAdded.isDisplayed();
	}
	public boolean nothingToDisplay() {
		return txt_nothingToDisplay.isDisplayed();
	}
	public String alertValidation() {
		return alert_computerAdded.getText();
	}
	public List<String> searchElement(String name) {
		List<String> computerValues = new ArrayList();
		txtBox_findComputer.sendKeys(name);
		btn_filterByName.click();
		List<WebElement> lst= searchElement.findElements(By.tagName("td"));
		for(WebElement list:lst) {
			computerValues.add(list.getText());
		}
		return computerValues;	
		
	}
	public EditComputer editComputer() {
		searchFirstElement.click();		
		return new EditComputer();
	}
	public void searchDeletedElement(String name) {
		txtBox_findComputer.sendKeys(name);
		btn_filterByName.click();				
	}
	public String nothingToDisplayError() {
		return txt_nothingToDisplay.getText();
	}
	
	
	
}
