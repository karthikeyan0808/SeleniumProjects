package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// All the object and methods of login page will be coded here

	// Page factory - Object repository , We need to use @FindBy annotation inorder
	// to use this method

	@FindBy(name = "username")

	WebElement username;

	@FindBy(name = "password")

	WebElement password;

	// Building Xpath

	@FindBy(xpath = "//input[@type='submit']")

	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign up')]")

	WebElement signUp;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")

	WebElement crmLogo;

	// Creating constructor

	// initElements = initElemets is initialize elements

	// this keyword is used to point the current class object

	// **** Initializing page objects ******

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions

	// This will get the page title
	public String ValidateLoginPageTitle() {

		return driver.getTitle();
	}

	// This will return true or false
	public boolean ValidateCRMimage() {

		return crmLogo.isDisplayed();

	}

	// Creating a method for login and passing two variables

	// Here we are using the return type as homepage because the login page method
	// will
	// land into homepage once succesfully logged in so the return type is homepage

	public HomePage Login(String un, String pwd) {

		// Using the element created in pagefactory , So we dont need to write up code
		// lik driver.find element
		username.sendKeys(un);

		password.sendKeys(pwd);

		loginBtn.click();

		return new HomePage();
	}

}
