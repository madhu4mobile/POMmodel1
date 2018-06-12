/**
 *
 */
package com.freeCRM.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.QA.base.TestBase;

/**
 * @author Madhu
 *
 */
public class LoginPage extends TestBase { // login page is a child of TestBase class

	// As a first step, PageFactory or OR has to be defined here.
	@FindBy(name="username") // find the element of username box from Login page  --> Note, @Findby annotation donot end with ;
	WebElement username;
	@FindBy(name="password") // password field
	 WebElement password;

	@FindBy(xpath="//input[@type='submit']")  // xpath should start with "" and inside the attribute use ''
	WebElement loginButton;
	@FindBy(xpath="//input[@type='button']") // xpath for SignUp button
	WebElement signUpButton;
	// OR for Logo
	@FindBy(className="img-responsive") // Logo by class
	WebElement crmLogo;
	// OR for links
	@FindBy(xpath="//a[contains(text(),'Features']")
	WebElement featuresLink;
	@FindBy(xpath="//a[contains(text(),'SignUp']")
	WebElement signUpLink;
	@FindBy(xpath="//a[contains(text(),'Pricing']")
	WebElement pricingLink;
	@FindBy(xpath="//a[contains(text(),'Customers']")
	WebElement customersLink;
	@FindBy(xpath="//a[contains(text(),'Contact']")
	WebElement  contactLink;

	// Now init the PageFactory PageObjects
	public LoginPage() { // default constructor
		PageFactory.initElements(driver, this);  // this points to the current class object instead of LoginPage.username
		}
	//Actions
	public String validateLoginPageTitle() { // to display page title
		return driver.getTitle();
		}
	public Boolean validateLogo() {  // to check if Logo displayed
		return crmLogo.isDisplayed();
		}
	public HomePage login(String un, String pw) { // to enter the username and pw in the fields
		username.sendKeys(un);
		password.sendKeys(pw);
		Actions action = new Actions(driver);
		action.moveToElement(loginButton).click().perform();
		//loginButton.click();

		return new HomePage();  // going to return the object in Homepage.   ??????

	}
























}
