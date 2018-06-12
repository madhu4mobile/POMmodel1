/**
 * This is the base class  -- Acts as parent class and all the other classes were
 */
package com.freeCRM.QA.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freeCRM.QA.utils.TestUtils;

import jdk.internal.jline.internal.Log;

/**
 * @author Madhu
 * This has the info of
 * maximize window, pageLoadTimeout,implicit wait, deleteAllCookies,
 * initiation of browser - Inheritance will be used here.
 *
 */
public class TestBase {
	// initialize the WebDriver drivers and Prop variable as globals.
	// so that, the driver and prop can be used inside the child classes also
	public static WebDriver driver;  // This is for webDriver drivers  -- to be made to be public to call from anywhere
	public static Properties prop;  // this is for properties

	public TestBase () // this is the default constructor
	{
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("M:\\WS\\POMmodel1\\com.freeCRM.maven\\src\\main\\java\\com\\"
						+ "freeCRM\\QA\\config\\config.properties");  // path of config prop is completed.
		prop.load(ip);
	} catch (FileNotFoundException e)
		{e.printStackTrace();}
	  catch (IOException e)
		{e.printStackTrace();}
	}

	public static void initialization() { // Here page initialization and primary set up.
		// initialize the browser ..
		String browserName = prop.getProperty("browser");  // we are getting the type of browser from config props. 
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "M:\\SelRel\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "M:\\SelRel\\geckodriver.exe");
			driver = new FirefoxDriver();  // driver is already initialized in the constructor.
		}
		// Initialize the page launch defaults like maximize and delete cookies... etc
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// to read the preset pageLoadTimeOut value from TestUtils class and use that here.
		/*String tempVar = prop.getProperty("pageLoadTimeOutDecided") // this reads the PageLoadTimoutValue as string from Config
		int pageLoadTimeOutTemp =Integer.parseInt(tempVar); // this converts the string to int and stores in tempVar*/
		// now use the value
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		// to read the preset Implicitly wait TimeOut value from TestUtils and use that here.
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// launch url
		driver.get(prop.getProperty("url"));
		//Log.info("Browser " + browserName + " is launched with URL " + prop.getProperty("url"));

	}







}
