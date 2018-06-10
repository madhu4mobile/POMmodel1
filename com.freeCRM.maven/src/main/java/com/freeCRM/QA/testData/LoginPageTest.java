/**
 * Test cases for Login Page test.
 */
package com.freeCRM.QA.testData;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.QA.base.TestBase;
import com.freeCRM.QA.pages.HomePage;
import com.freeCRM.QA.pages.LoginPage;

/**
 * @author Madhu
 *
 */
public class LoginPageTest extends TestBase {
	// Global object initialization
	LoginPage loginPage;  // loginPage obj is initialized
	HomePage homePage; // homePage obj is initiated
	public LoginPageTest() {  // in default constructor, the base class has to be initiated
		super();
	}

	@BeforeMethod
	public void setUp() {
	initialization();// here it call the supre class and gets the congi files and launches browser, maximizes etc...
	loginPage = new LoginPage(); // initialization of object here will be done and all the OR objects get initialized.
	}
	@Test
	public void loginPageTitleTest() { // for confirming page Title
		//String title = loginPage.validateLoginPageTitle();  // method to validate login page title
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		//Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		}
	@Test // for Logo Test
	public void siteLogoImageTest() {
		Boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test
	public void loginPageTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// this homePage object is initiated in Constructor for directing into HomePage.
	}

	@AfterMethod
	public void tearDown() {  // finally close the browser.
		driver.quit();
	}



}
