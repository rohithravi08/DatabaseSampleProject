package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class EditComputer extends TestBase{
	
	
	//page factory - Object repository
		@FindBy(xpath="//h1[text()=\"Edit computer\"]")
		WebElement txt_EditComputer;
		
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
		
		@FindBy(xpath="//input[@value=\"Save this computer\"]")
		WebElement btn_saveComputer;
		
		@FindBy(xpath="//a[text()=\"Cancel\"]")
		WebElement btn_cancel;
		
		@FindBy(xpath="//input[@value=\"Delete this computer\"]")
		WebElement btn_deleteComputer;
		
		
		
		//initialise 
		
		public EditComputer() {
			PageFactory.initElements(driver, this);
		}

		//actions
		
		public boolean displayEditComputerLabel() {		
			return txt_EditComputer.isDisplayed();
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
		
		public boolean displaySaveComputerButton() {		
			return btn_saveComputer.isDisplayed();
		}
		
		public boolean displaycancelButton() {		
			return btn_cancel.isDisplayed();
		}
		public boolean displaydeleteButton() {		
			return btn_deleteComputer.isDisplayed();
		}
		
		public void enterValues(String compNme,String introDate,String discontinueDate,String companyName) {
			txtbox_computerName.clear();
			txtbox_computerName.sendKeys(compNme);
			txtbox_introducedDate.clear();
			txtbox_introducedDate.sendKeys(introDate);
			txtbox_discontinuedDate.clear();
			txtbox_discontinuedDate.sendKeys(discontinueDate);
			
			Select dropDown =new Select(drpdown_company);
			dropDown.selectByVisibleText(companyName);
		}
		
		public HomePage clickSaveComputer() {		
			btn_saveComputer.click();
			return new HomePage();
		}
		public HomePage clickOnDeleteComputer() {
			btn_deleteComputer.click();
			return new HomePage();
		}
}
