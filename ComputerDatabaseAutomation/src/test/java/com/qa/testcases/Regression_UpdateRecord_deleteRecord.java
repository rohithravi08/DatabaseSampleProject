package com.qa.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddComputer;
import com.qa.pages.EditComputer;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;

public class Regression_UpdateRecord_deleteRecord extends TestBase{
	
	HomePage homepage;
	int numberOfComputer;
	AddComputer addcomputerPage;
	EditComputer editcomputerPage;
	TestUtil util;
	String computerName="XPS 13";
	String introducedDate="2017-05-20";
	String discontinuedDate="2019-04-20";
	String company="RCA";
	String new_computerName="XPS 13";
	String new_introducedDate="2017-05-25";
	String new_discontinuedDate="2020-04-22";
	String new_company="Netronics";
	List<String> old_values=null;
	List<String> new_values=null;
	
	
	//initialising property variables
	public Regression_UpdateRecord_deleteRecord() {
		super();
	}
	
	//initialising driver and loading the url
	@BeforeClass
	public void setup() {
		initialization();
		homepage=new HomePage();	
		addcomputerPage=new AddComputer();
		editcomputerPage=new EditComputer();
		util=new TestUtil();
	}
	
	//Pre-requisite
	//add a computer to the database
	@Test(priority=1)
	public void clickAddNewComputer(){		
		homepage.addComputer();
		addcomputerPage.enterValues(computerName, introducedDate, discontinuedDate, company);
		addcomputerPage.clickCreateComputer();
	}	
	
	//verify the search functionality
	@Test(priority=2)
	public void searchfunctionValidation() {
		old_values=homepage.searchElement(computerName);
		Assert.assertEquals(old_values.get(0), computerName);
		Assert.assertEquals(old_values.get(1), util.dateConversion(introducedDate));
		Assert.assertEquals(old_values.get(2), util.dateConversion(discontinuedDate));
		Assert.assertEquals(old_values.get(3), company);				
	}
	//click on the record displayed after searching
	@Test(priority=3)
	public void clickOnsearchRecord() {
		homepage.editComputer();
		boolean editlabeldisplay=editcomputerPage.displayEditComputerLabel();
		Assert.assertTrue(editlabeldisplay,"it's not navigated to the edit page");
	}
	//verify the fields and edit the fields
	@Test(priority=4)
	public void enterNewValues() {
		boolean computerNameLabel=editcomputerPage.displaycomputerNameLabel();
		Assert.assertTrue(computerNameLabel, "computerNameLabel is not displayed");
		boolean introducedDateLabel=editcomputerPage.displayintroducedDateLabel();
		Assert.assertTrue(introducedDateLabel, "introducedDateLabel is not displayed");
		boolean discontinuedDateLabel=editcomputerPage.displaydiscontinuedDateLabel();
		Assert.assertTrue(discontinuedDateLabel, "discontinuedDateLabel is not displayed");
		boolean companyLabel=editcomputerPage.displaycompanyLabel();
		Assert.assertTrue(companyLabel, "companyLabel is not displayed");
		boolean computerNameTextBox=editcomputerPage.displaycomputerNameTextBox();
		Assert.assertTrue(computerNameTextBox, "computerNameTextBox is not displayed");
		boolean introducedDateTextBox=editcomputerPage.displayintroducedDateTextBox();
		Assert.assertTrue(introducedDateTextBox, "introducedDateTextBox is not displayed");
		boolean discontinuedDateTextBox=editcomputerPage.displaydiscontinuedDateTextBox();
		Assert.assertTrue(discontinuedDateTextBox, "discontinuedDateTextBox is not displayed");
		boolean companyDropDown=editcomputerPage.displaycompanyDropDown();
		Assert.assertTrue(companyDropDown, "companyDropDown is not displayed");
		editcomputerPage.enterValues(new_computerName, new_introducedDate, new_discontinuedDate, new_company);	
	}
	//verify save button displayed and click on save button
	@Test(priority=5)
	public void clickonSaveButton() {
		boolean saveButtonStatus=editcomputerPage.displaySaveComputerButton();
		Assert.assertTrue(saveButtonStatus,"save button is not displayed");
		editcomputerPage.clickSaveComputer();		
	}
	//alert verification after editing the computer
	@Test(priority=6)
	public void alertValidation() {
		boolean alertStatus= homepage.alertPresesnt();
		Assert.assertTrue(alertStatus,"update computer alert not displayed");
		String alertText=homepage.alertValidation();
		Assert.assertEquals(alertText, "Done! Computer "+new_computerName+" has been updated", "alert content is wrong");
	}
	
	//verify the updated values
	@Test(priority=7)
	public void updatedValueValidation() {
		new_values=homepage.searchElement(new_computerName);		
		Assert.assertEquals(new_values.get(0), new_computerName);
		Assert.assertEquals(new_values.get(1), util.dateConversion(new_introducedDate));
		Assert.assertEquals(new_values.get(2), util.dateConversion(new_discontinuedDate));
		Assert.assertEquals(new_values.get(3), new_company);		
		
	}
	
	//click on the element and delete the record
	@Test(priority=8)
	public void deleteRecord() {
		homepage.editComputer();
		boolean deleteButtonDisplayStatus=editcomputerPage.displaydeleteButton();
		Assert.assertTrue(deleteButtonDisplayStatus,"delete button is not displayed");
		editcomputerPage.clickOnDeleteComputer();		
	}
	
	//alert verification after deleting the computer
	@Test(priority=9)
	public void alertValidationOnDelete() {
		boolean alertStatus= homepage.alertPresesnt();
		Assert.assertTrue(alertStatus,"update computer alert not displayed");
		String alertText=homepage.alertValidation();
		Assert.assertEquals(alertText, "Done! Computer has been deleted", "delete alert content is wrong");
	}
	//search the deleted record and verify the error message
	@Test(priority=10)
	public void errorValidation() {
		homepage.searchDeletedElement(new_computerName);
		boolean errorDisplayStatus=homepage.nothingToDisplay();
		Assert.assertTrue(errorDisplayStatus);
		String errroMessage= homepage.nothingToDisplayError();
		Assert.assertEquals(errroMessage, "Nothing to display","error message is wrong");
		
	}
	
	//close the driver	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
