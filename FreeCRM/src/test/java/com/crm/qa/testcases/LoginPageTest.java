package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	// Declaring the object at class level so it can be accessed through out the
	// class

	LoginPage loginPage;
	HomePage homePage;

	// Creat a constructor

	public LoginPageTest() {

		// We need to declare super keyword

		// Super keywords work is to goto the parent class and call the super class
		// constructor because here we need to initialise the properties also
		// It is compulspry to call the base class constructor before any test or to be
		// called

		super();
	}

	// In this class body we will define all the reqired annotations for the test

	@BeforeMethod

	public void setUp() {

		// Calling Initialization method from the base class
		// Once we call this method it will automatically go to th parent class where it
		// has been defined and it wont throw
		// 'Null pointer exception' because we have already defined the properties there

		initialization();

		// Creating object of login page class , So that we can access all the functions
		// and methods of login page class

		loginPage = new LoginPage();

	}

	@Test(priority = 1)

	public void loginPageTitleTest() {

		String title = loginPage.ValidateLoginPageTitle();

		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}

	@Test(priority = 2)

	public void crmLogoImageTest() {

		boolean flag = loginPage.ValidateCRMimage();

		Assert.assertTrue(flag);
	}

	@Test(priority = 3)

	public void loginTest() {

		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod

	public void tearDown() {

		driver.quit();
	}

}
