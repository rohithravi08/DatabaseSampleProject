package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class AddComputer extends TestBase{
	
	//page factory - Object repository
	@FindBy(xpath="//h1[text()=\"Add a computer\"]")
	WebElement txt_addComputer;
	
	@FindBy(xpath="//label[text()=\"Computer name\"]")
	WebElement lbl_computerName;
	
	@FindBy(xpath="//label[text()=\"Introduced date\"]")
	WebElement lbl_introducedDate;
	
	@FindBy(xpath="//label[text()=\"Discontinued date\"]")
	WebElement lbl_discontinuedDate;
	
	@FindBy(xpath="//label[text()=\"Company\"]")
	WebElement lbl_company;
	
	
	
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement txtbox_computerName;
	
	@FindBy(xpath="//input[@id=\"introduced\"]")
	WebElement txtbox_introducedDate;
	
	@FindBy(xpath="//input[@id=\"discontinued\"]")
	WebElement txtbox_discontinuedDate;
	
	@FindBy(xpath="//select[@id=\"company\"]")
	WebElement drpdown_company;
	
	@FindBy(xpath="//input[@value=\"Create this computer\"]")
	WebElement btn_createComputer;
	
	@FindBy(xpath="//a[text()=\"Cancel\"]")
	WebElement btn_cancel;
	
	
	
	
	//initialise 
	
	public AddComputer() {
		PageFactory.initElements(driver, this);
	}

	//actions
	
	public boolean displayAddComputerLabel() {		
		return txt_addComputer.isDisplayed();
	}
	public boolean displaycomputerNameLabel() {		
		return lbl_computerName.isDisplayed();
	}
	public boolean displayintroducedDateLabel() {		
		return lbl_introducedDate.isDisplayed();
	}
	public boolean displaydiscontinuedDateLabel() {		
		return lbl_discontinuedDate.isDisplayed();
	}
	public boolean displaycompanyLabel() {		
		return lbl_company.isDisplayed();
	}
	
	

	public boolean displaycomputerNameTextBox() {		
		return txtbox_computerName.isDisplayed();
	}
	public boolean displayintroducedDateTextBox() {		
		return txtbox_introducedDate.isDisplayed();
	}
	public boolean displaydiscontinuedDateTextBox() {		
		return txtbox_discontinuedDate.isDisplayed();
	}
	public boolean displaycompanyDropDown() {		
		return drpdown_company.isDisplayed();
	}
	
	public boolean displaycreateComputerButton() {		
		return btn_createComputer.isDisplayed();
	}
	
	public boolean displaycancelButton() {		
		return btn_cancel.isDisplayed();
	}
	
	public void enterValues(String compNme,String introDate,String discontinueDate,String companyName) {
		txtbox_computerName.sendKeys(compNme);
		txtbox_introducedDate.sendKeys(introDate);
		txtbox_discontinuedDate.sendKeys(discontinueDate);
		
		Select dropDown =new Select(drpdown_company);
		dropDown.selectByVisibleText(companyName);
	}
	
	public HomePage clickCreateComputer() {		
		btn_createComputer.click();
		return new HomePage();
	}
	
}
