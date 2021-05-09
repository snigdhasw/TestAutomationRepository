package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseclass.BaseTest;
import listener.Testlisteners;
import utilities.CommonUtilities;

@Listeners(Testlisteners.class)
public class VerifyLogin extends BaseTest {

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extentReports.createTest(sTestMethod.getName());
	}

	@Test
	public void tc01login() throws Exception {

		SoftAssert sa = new SoftAssert();
		Thread.sleep(5000);
		initializeDriver();

		System.out.println("Github changes testing111");
		
		sa.assertEquals(driver.getTitle(), getTestData("salesforce.title"));

		WebElement username = driver.findElement(By.id(getWebElement("web.username.path")));

		username.clear();

		CommonUtilities.sendingKeys(driver, username, 6, getUserAccElement("user.account"));

		// sa.assertNotNull(username.getText(), getUserAccElement("user.account"));
		sa.assertNotNull(username, "scfdfvd");

		test.info("Username is entered");

		WebElement password = driver.findElement(By.id(getWebElement("web.pass.path")));
		password.clear();
		test.info("Password is Empty");
		CommonUtilities.sendingKeys(driver, password, 6, getUserAccElement("user.pass"));
		test.info("password is entered");
		sa.assertNotNull(username, "scfdfvd");

		WebElement login = driver.findElement(By.id(getWebElement("login.button.path")));
		CommonUtilities.clickOn(driver, login, 6);
		test.pass("Login is success");

		sa.assertAll();

		System.out.println("Successfuly Logged in");

		try {

			driver.findElement(By.linkText(getWebElement("remindmelater"))).click();

		} catch (Exception e1) {
			// e1.printStackTrace();
			System.out.println("Please ignore the error -> " + e1.getMessage());
		}
	}

	@Test
	public void tc02LoginToSF() throws Exception {

		SoftAssert sa = new SoftAssert();
		initializeDriver();
		sa.assertEquals(driver.getTitle(), getTestData("salesforce.title"));
		test.info("page is loaded");

		WebElement username = driver.findElement(By.id(getWebElement("web.username.path")));
		username.clear();
		test.info("username field is cleared");
		CommonUtilities.sendingKeys(driver, username, 6, reportTime);
		test.info("username is entered");

		sa.assertNotNull(username, "scfdfvd");

		WebElement password = driver.findElement(By.id(getWebElement("web.pass.path")));
		password.clear();
		test.info("password field is cleared");
		sa.assertNull(password, "password filed is null");
		CommonUtilities.clickOn(driver, password, 6);
		sa.assertEquals(password.getText(), getUserAccElement("user.pass"));
		test.info("password is entered");

		WebElement login = driver.findElement(By.id(getWebElement("login.button.path")));
		CommonUtilities.clickOn(driver, login, 6);

		test.pass("Login to SF is passed");

	}
	
	@Test
	
	public void tc03RememberMe()  {
		try {
			
		SoftAssert sa = new SoftAssert();
		login(sa);
		test.info("Sucessfully logged in");
		//System.out.println("******************"+getWebElement("usermenu.logout"));
		WebElement usermenu = driver.findElement(By.id(getWebElement("usermenu.dropdown")));
		sa.assertFalse(usermenu.isEnabled());
		CommonUtilities.clickOn(driver, usermenu, 6);
		
		WebElement lOut =driver.findElement(By.linkText(getWebElement("usermenu.logout")));
		System.out.println("IS ENABLED ****"+usermenu.isEnabled());
		sa.assertFalse(usermenu.isEnabled());
		CommonUtilities.clickOn(driver, lOut, 6);

        WebElement element = driver.findElement(By.id(getWebElement("web.username.path")));
        
		sa.assertNotNull(element , "username is not null");	
		test.pass("rememberMe is passed ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tc04Forgotpass() {
		SoftAssert sa = new SoftAssert();
		
		try {
			
		initializeDriver();
		test.info("driver is initialize");
		WebElement forgotpass = driver.findElement(By.id(getWebElement("we.id.forgotpassword")));
		//System.out.println("&&&&&&&&&&&&  "+forgotpass.isEnabled());
	    sa.assertTrue(forgotpass.isEnabled());
	    CommonUtilities.clickOn(driver, forgotpass, 6);
	    test.info("click on the forgotpassword link");
		

		WebElement username = driver.findElement(By.id(getWebElement("we.forgotpass.uid")));
		//System.out.println("&&&&&&&&&&&&  "+username.isEnabled());
		sa.assertTrue(username.isDisplayed());
		username.clear();
		CommonUtilities.sendingKeys(driver, username, 6, getUserAccElement("user.account"));
		test.info("entrt uid in the textfield");
		
		WebElement cont = driver.findElement(By.id(getWebElement("we.fp.cont")));
		//System.out.println("&&&&&&&&&&&&  "+username.isEnabled());
		CommonUtilities.clickOn(driver, cont, 6);
		test.info("sucessfully click on the continue");
		
		WebElement ele = driver.findElement(By.linkText(getWebElement("we.rtrntolog")));
		//System.out.println("SSSSSSSSSSSS"+ele.getText());
		sa.assertEquals(ele.getText(), "Return to Login");
		test.pass("forgotpass testcase is passed");
		
		
		
		}
		
		catch(Exception e) {
	
		    e.printStackTrace();
		
		}
		
	}
	
	
}