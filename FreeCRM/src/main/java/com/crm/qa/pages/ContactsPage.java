package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// Define Page factories

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	// Below is not a good practise
	/*
	 * @FindBy(xpath =
	 * "//a[text()='test2 test2']//parent::td[@class='detailstrow']///preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"
	 * ) WebElement ;
	 */

	@FindBy(name = "title")
	WebElement Title;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {

		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {

		driver.findElement(By.xpath("//a[text()='" + name
				+ "']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"))
				.click();
	}

	public void createNewContact(String title, String ftName, String lsName, String comp) {

		Select select = new Select(Title);

		select.selectByVisibleText(title);

		firstName.sendKeys(ftName);

		lastName.sendKeys(lsName);

		company.sendKeys(comp);

		saveBtn.click();

	}

}
