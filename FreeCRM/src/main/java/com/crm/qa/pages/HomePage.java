package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Implementing page factory

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;

	// ----- xxxxx------//

	// Initializing page objects , All the above elements will be initialized here

	public HomePage() {

		PageFactory.initElements(driver, this); // This will initalize the driver which has been
												// defined and declared in the test base , This refers to the current
												// class methods

	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	// Here we are doing a chaining in the framework if we click on a click that
	// link should redirect us to the respective and
	// returns the particular page object and in that page we will start performing
	// our operations
	// In the following method we are clicking on contacts link and this link will
	// land us in the contact page object

	public ContactsPage clickOnContactLink() {

		contacts.click();

		// creating an object for the contactspage and returning the same as the
		// contacts link will land us on contacts page

		return new ContactsPage();

	}

	public DealsPage clickOnDealsLinks() {

		dealsLink.click();

		return new DealsPage();

	}

	public TasksPage clickOnTasksLinks() {

		taskLink.click();

		return new TasksPage();

	}

}
