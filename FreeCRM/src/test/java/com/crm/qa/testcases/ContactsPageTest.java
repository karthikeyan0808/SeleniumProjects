package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";

	// Create a constructor

	public ContactsPageTest() {

		super();
	}

	@BeforeMethod

	public void setUp() {

		initialization();

		// Creating object of login page class , So that we can access all the functions
		// and methods of login page class
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactsPage = homePage.clickOnContactLink();

	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {

		contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "The contacts page label is missing");
	}

	@Test(priority = 2)
	public void selectContactsTest() {

		contactsPage.selectContactsByName("Abdul kattar");

	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {

		contactsPage.selectContactsByName("Abdul kattar");
		contactsPage.selectContactsByName("Aparna Sriram");

	}
	
	// Using data provider method to read the data from excel to pass into web application
	
	@DataProvider
	public Object[][] getTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(priority= 4 , dataProvider = "getTestData")
	public void ValidatecreateNewContact(String Title , String FirstName , String LastName , String Company) {
		
	
		homePage.clickOnNewContactsLink();
		
		// contactsPage.createNewContact("Mr.", "Sam", "Tom", "infy");
		
		contactsPage.createNewContact(Title ,FirstName, LastName, Company);
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
