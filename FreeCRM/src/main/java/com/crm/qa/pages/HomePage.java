package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Implementing page factory
	// @Cachelookup is used to improve the efficiency of the framework , the
	// webelements value will be stored in the cachememory
	// it will be called whenver the webelement is used and it will be corrupted if
	// the page is refreshed or dom structure changes

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	// @CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	//@FindBy(xpath = "//li[./a[text()='Contacts']]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	//@FindBy(xpath = "//li[./a[text()='Contacts'][not(contains(@style,'background'))]]//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

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

	public boolean verifycorrectUserName() {

		return userNameLabel.isDisplayed();
	}

	// Here we are doing a chaining in the framework if we click on a click that
	// link should redirect us to the respective and
	// returns the particular page object and in that page we will start performing
	// our operations
	// In the following method we are clicking on contacts link and this link will
	// land us in the contact page object

	public ContactsPage clickOnContactLink() {

		contactsLink.click();

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

	public void clickOnNewContactsLink() {

		/* Actions action = new Actions(driver); */

		/*
		 * action.moveToElement(contactsLink).build().perform();
		 * 
		 * newContactsLink.click();
		 */

		/*
		 * Actions action = new Actions(driver);
		 * 
		 * action.moveToElement(contactsLink).moveToElement(newContactsLink).click().
		 * build().perform();
		 */

		/* newContactsLink.click(); */

		/*
		 * Actions actions = new Actions(driver); WebElement contactsLink =
		 * driver.findElement(By.linkText("menulink"));
		 * actions.moveToElement(contactsLink);
		 * 
		 * 
		 * actions.moveToElement(newContactsLink); actions.click().build().perform();
		 */

		/*
		 * WebElement contactsLinks = contactsLink ;
		 * 
		 * Actions action = new Actions(driver);
		 * action.moveToElement(contactsLinks).perform();
		 * 
		 * action.moveToElement(newContactsLink).click().build().perform();
		 */

		/*
		 * WebElement contactsLinks = contactsLink ; Actions actions = new
		 * Actions(driver); actions.moveToElement(contactsLinks); try {
		 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 * actions.moveToElement(newContactsLink).click().build().perform();
		 */

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).perform();
		
		
		
		actions.moveToElement(newContactsLink).click().build().perform();

		System.out.println();

	}

}
