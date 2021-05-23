package testcases;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseclass.BaseTest;
import testpagefactory.UsermenuDropdown_PF;
import utilities.CommonUtilities;

public class VerifyUserMenu extends BaseTest {

	UsermenuDropdown_PF uDropdown = null;

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extentReports.createTest(sTestMethod.getName());
		}
	
	@AfterMethod
	
	public void quitDriver() {
		driver.quit();
	}

	@Test
	public void tc05verifyUsermenuDropdown() {
		
		SoftAssert sa = new SoftAssert();

		try {

			login(sa);
			test.info("driver is initialize");
			uDropdown = new UsermenuDropdown_PF(driver);
			test.info("page factory is loaded");
			System.out.println("test");
			
			CommonUtilities.clickOn(driver, uDropdown.btn_Usermenu, 6);
			System.out.println(uDropdown.btn_Usermenu.getText());

			List<WebElement> list = uDropdown.list_UsermenuList;
			test.info("get the dropdown list from the web");
			String menuListFromWeb =  list.get(0).getText();
			
			System.out.println(" menuListFromWeb   "+menuListFromWeb);
			String[] menuListFromWebArray = menuListFromWeb.split("\n");
			Arrays.sort(menuListFromWebArray);
			
			if (!list.isEmpty()) {
				System.out.println("the test passed");
			}
			
			String userMenuListStr = getTestData("user.menu.list");
			test.info("successfully get the data from the Testdata");
			String[] userMenuTestDataList = userMenuListStr.split(",");
			Arrays.sort(userMenuTestDataList);
			
			sa.assertEquals(menuListFromWebArray,userMenuTestDataList);
			
			boolean isEqual = Arrays.equals(menuListFromWebArray, userMenuTestDataList);
			
			
			sa.assertTrue(isEqual);
		
			test.info("data is uccessfully compaired");
			test.pass("verifyUsermenuDropdown is passed");
			
			//sa.assertTrue(false);
			//sa.assertAll();

		} catch (Exception e) {
			e.printStackTrace();
			sa.assertTrue(false, e.getMessage());

		} finally {
			sa.assertAll();
		}
	}
	
	@Test
	public void tc07Mysettings() {
		
	 SoftAssert sa = new SoftAssert();
	 try {
	     login(sa);
	 
		test.info("driver is initialize");
		uDropdown = new UsermenuDropdown_PF(driver);
		test.info("page factory is loaded");
		System.out.println("test");
		
		CommonUtilities.clickOn(driver, uDropdown.btn_Usermenu, 8);
		System.out.println(uDropdown.btn_Usermenu.getText());
		sa.assertEquals(uDropdown.btn_Usermenu.getText(), getTestData("usermenu.level"));
		test.info("usermenu is clicked");
		
		
		CommonUtilities.clickOn(driver, uDropdown.mySettings, 8);
		
		sa.assertEquals(uDropdown.mySettings.getText(), getTestData("usermenu_setting"));
		test.info("my setting is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.personalinfo, 8);
		test.info("personalinfo is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.login_history, 8);
		test.info("login_history is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.downloadfile, 8);
		 
		boolean isFileExist = isFileExist();
		sa.assertTrue(isFileExist);
		test.info("File exists ");
		test.pass("test passed ");
		
		if(isFileExist) {
			deleteFiles();
			System.out.println("file is deleted");
			
		}
		
		
 }
	catch(Exception e) {
		sa.assertTrue(false ,e.getMessage());
	}
	 finally {
		 sa.assertAll();
	 }
	 
 }
	
	
	private boolean isFileExist() {
		boolean isFileExist = false;
		File folder = new File("/Users/snigdha/Downloads");
		File[] files = folder.listFiles();
		for(File file : files) {
			
			String str = file.getName();
			
			if(str.startsWith("LoginHistory")) {
				isFileExist = true;
				System.out.println("Download File Validation Pass");
			}
		}
		return isFileExist;
	}
	
	private void deleteFiles() throws Exception {
		
		File folder1 = new File(getTestData("filedownload_location"));
		File[] files1 = folder1.listFiles();
		for(File file : files1) {
			
			String str = file.getName();
			if(file.isFile()) {
				if(str.startsWith("LoginHistory")) {
					System.out.println("deleting files "+ str);
					test.info("the file has been deleted" + file.getName());
					file.delete();
					
				}
			}
		}
		
	}
	
	@Test
	public void tc08DeveloperConsole() {
		
		SoftAssert sa = new SoftAssert();
		try {
			
		login(sa);
		
		test.info("driver is initialize");
		uDropdown = new UsermenuDropdown_PF(driver);
		
		test.info("page factory is loaded");
		System.out.println("test");
		
		String firstTitle = driver.getTitle();
		System.out.println("   @@@@@@@@@@  "+firstTitle);
		
		CommonUtilities.clickOn(driver, uDropdown.btn_Usermenu, 6);
		System.out.println(uDropdown.btn_Usermenu.getText());
		sa.assertEquals(uDropdown.btn_Usermenu.getText(), getTestData("usermenu.level"));
		test.info("usermenu is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.devConsole, 6);
		test.info("dev control is clicked and new window is opened");
		
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("winHandleBefore " + winHandleBefore);
		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("winHandle " + winHandle);
			driver.switchTo().window(winHandle);
		}
		
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		String secondTitle = driver.getTitle();
		System.out.println("   @@@@@@@@@@  "+secondTitle);
		
		sa.assertEquals(firstTitle, secondTitle);
		test.pass("test is passed");
		
		
		}catch(Exception e) {
			
			sa.assertTrue(false, e.getMessage());
		}
		finally {
			sa.assertAll();
			
		}
		
	}
	
	@Test
	public void tc09Logout() {
		
		SoftAssert sa = new SoftAssert();
		try {
			
		login(sa);
		
		test.info("driver is initialize");
		uDropdown = new UsermenuDropdown_PF(driver);
		
		test.info("page factory is loaded");
		System.out.println("test");
		
		String firstTitle = driver.getTitle();
		System.out.println("   @@@@@@@@@@  "+firstTitle);
		
		CommonUtilities.clickOn(driver, uDropdown.btn_Usermenu, 6);
		System.out.println(uDropdown.btn_Usermenu.getText());
		sa.assertEquals(uDropdown.btn_Usermenu.getText(), getTestData("usermenu.level"));
		test.info("usermenu is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.logout, 6);
		
		System.out.println("22222" + driver.getCurrentUrl());
		test.info("logout is clicked");
		test.pass("test is passed");
		
}catch(Exception e) {
			
			sa.assertTrue(false, e.getMessage());
		}
		finally {
			sa.assertAll();
			
		}
		
	}
	

}
