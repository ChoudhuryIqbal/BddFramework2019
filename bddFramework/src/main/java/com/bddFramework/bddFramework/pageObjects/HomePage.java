package com.bddFramework.bddFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bddFramework.bddFramework.helper.Constants;
import com.bddFramework.bddFramework.helper.WaitHelper;


public class HomePage {

	private WebDriver driver;

	com.bddFramework.bddFramework.helper.WaitHelper waitHelper;


	@FindBy(xpath = "//span[contains(text(),' Administrator')]")
	public WebElement administrator;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Leads']")
	WebElement leadsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Organizations']")
	WebElement organizationsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Opportunities']")
	WebElement opportunitiesLInk;

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	WebElement leadsButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public LeadsCreationPage navigateToLeads() {
		leadsLink.click();
		return new LeadsCreationPage(driver);
	}

	public Organizations navigateToOrganizations() {
		organizationsLink.click();
		return new Organizations(driver);
	}

	public void navigateToContacts() {
		contactsLink.click();
	}

	public void navigateToOpportunities() {
		opportunitiesLInk.click();
	}
	
	public WebElement getAdministrator() {
		waitHelper.WaitForElement(administrator, Constants.getExplicitwait());
		return administrator;
	}


}
