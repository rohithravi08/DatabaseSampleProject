package com.qa.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddComputer;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;

public class Regression_AddNewComputer_SearchFunctionality extends TestBase{
	
	HomePage homepage;
	int numberOfComputer;
	AddComputer addcomputerPage;
	TestUtil util;
	String computerName="surface pro";
	String introducedDate="2018-05-20";
	String discontinuedDate="2019-05-20";
	String company="RCA";
	
	
	//initialising property variables
	public Regression_AddNewComputer_SearchFunctionality() {
		super();
	}
	
	//initialising driver and loading the url
	@BeforeClass
	public void setup() {
		initialization();
		homepage=new HomePage();	
		addcomputerPage=new AddComputer();
		util=new TestUtil();
	}
	//Home page title validation
	@Test(priority=1)
	public void homepageTitleValidation() {
		String title=homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Computers database","title is not correct");			
	}
	//storing the default number of computer into a global variable
	@Test(priority=2)
	public void numberOfComputer() {
		numberOfComputer=homepage.numberOfComputerValdaton();			
	}
	//verify add computer button present and navigate to new page
	@Test(priority=3)
	public void clickAddNewComputer(){
		boolean buttonStatus=homepage.addComputerButtonPresent();
		Assert.assertTrue(buttonStatus,"button is not displayed");
		homepage.addComputer();
		boolean addComputerLabelstatus=addcomputerPage.displayAddComputerLabel();
		Assert.assertTrue(addComputerLabelstatus, "It's not navigated to addComputer Page");
	}
	//verify all the fields and buttons, and enter values to the fields
	@Test(priority=4)
	public void enterValues()  {
		boolean computerNameLabel=addcomputerPage.displaycomputerNameLabel();
		Assert.assertTrue(computerNameLabel, "computerNameLabel is not displayed");
		boolean introducedDateLabel=addcomputerPage.displayintroducedDateLabel();
		Assert.assertTrue(introducedDateLabel, "introducedDateLabel is not displayed");
		boolean discontinuedDateLabel=addcomputerPage.displaydiscontinuedDateLabel();
		Assert.assertTrue(discontinuedDateLabel, "discontinuedDateLabel is not displayed");
		boolean companyLabel=addcomputerPage.displaycompanyLabel();
		Assert.assertTrue(companyLabel, "companyLabel is not displayed");
		boolean computerNameTextBox=addcomputerPage.displaycomputerNameTextBox();
		Assert.assertTrue(computerNameTextBox, "computerNameTextBox is not displayed");
		boolean introducedDateTextBox=addcomputerPage.displayintroducedDateTextBox();
		Assert.assertTrue(introducedDateTextBox, "introducedDateTextBox is not displayed");
		boolean discontinuedDateTextBox=addcomputerPage.displaydiscontinuedDateTextBox();
		Assert.assertTrue(discontinuedDateTextBox, "discontinuedDateTextBox is not displayed");
		boolean companyDropDown=addcomputerPage.displaycompanyDropDown();
		Assert.assertTrue(companyDropDown, "companyDropDown is not displayed");
		addcomputerPage.enterValues(computerName, introducedDate, discontinuedDate, company);	
		
	}
	//click on create computer button
	@Test(priority=5)
	public void clickOncreateComputer()  {
		addcomputerPage.clickCreateComputer();		
	}
	//alert verification after adding the computer
	@Test(priority=6)
	public void alertValidation() {
		boolean alertStatus= homepage.alertPresesnt();
		Assert.assertTrue(alertStatus,"create computer alert not displayed");
		String alertText=homepage.alertValidation();
		Assert.assertEquals(alertText, "Done! Computer "+computerName+" has been created", "alert content is wrong");
	}
	//verify the number of computer displaying on homepage changes after adding a new computer
	@Test(priority=7)
	public void noOfComputerValidation() {
		int newNumberOfComputer=homepage.numberOfComputerValdaton();
		Assert.assertEquals(newNumberOfComputer, (numberOfComputer+1),"new number is wrong");
	}
	//verify the search functionality
	@Test(priority=8)
	public void searchfunctionValidation() {
		List<String> values=homepage.searchElement(computerName);
		Assert.assertEquals(values.get(0), computerName);
		Assert.assertEquals(values.get(1), util.dateConversion(introducedDate));
		Assert.assertEquals(values.get(2), util.dateConversion(discontinuedDate));
		Assert.assertEquals(values.get(3), company);				
	}
	
	//close the driver	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
