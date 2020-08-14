package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	// Creating object n reference for respective pages and utils

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod

	public void setUp() {

		// Calling Initialization method from the base class
		// Once we call this method it will automatically go to th parent class where it
		// has been defined and it wont throw
		// 'Null pointer exception' because we have already defined the properties there

		initialization();

		// Creating object of login page class , So that we can access all the functions
		// and methods of login page class

		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {

		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title is not matched");
		System.out.println("The title of the page is:" + homePageTitle);

	}

	@Test(priority = 2)
	public void verifyUserName() {

		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifycorrectUserName());

	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {

		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
