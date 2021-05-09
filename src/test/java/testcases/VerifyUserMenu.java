package testcases;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

//	@Test
//	public void tc05verifyUsermenuDropdown() {
//		
//		SoftAssert sa = new SoftAssert();
//
//		try {
//
//			login(sa);
//			test.info("driver is initialize");
//			uDropdown = new UsermenuDropdown_PF(driver);
//			test.info("page factory is loaded");
//			System.out.println("test");
//			
//			CommonUtilities.clickOn(driver, uDropdown.btn_Usermenu, 6);
//			System.out.println(uDropdown.btn_Usermenu.getText());
//
//			List<WebElement> list = uDropdown.list_UsermenuList;
//			test.info("get the dropdown list from the web");
//			String menuListFromWeb =  list.get(0).getText();
//			
//			System.out.println(" menuListFromWeb   "+menuListFromWeb);
//			String[] menuListFromWebArray = menuListFromWeb.split("\n");
//			Arrays.sort(menuListFromWebArray);
//			
//			if (!list.isEmpty()) {
//				System.out.println("the test passed");
//			}
//			
//			String userMenuListStr = getTestData("user.menu.list");
//			test.info("successfully get the data from the Testdata");
//			String[] userMenuTestDataList = userMenuListStr.split(",");
//			Arrays.sort(userMenuTestDataList);
//			
//			sa.assertEquals(menuListFromWebArray,userMenuTestDataList);
//			
//			boolean isEqual = Arrays.equals(menuListFromWebArray, userMenuTestDataList);
//			
//			
//			sa.assertTrue(isEqual);
//		
//			test.info("data is uccessfully compaired");
//			test.pass("verifyUsermenuDropdown is passed");
//			
//			//sa.assertTrue(false);
//			//sa.assertAll();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			sa.assertTrue(false, e.getMessage());
//
//		} finally {
//			sa.assertAll();
//		}
//	}
	
	@Test
	public void tc07Mysettings() {
		
	 SoftAssert sa = new SoftAssert();
	 try {
	     login(sa);
	 
		test.info("driver is initialize");
		uDropdown = new UsermenuDropdown_PF(driver);
		test.info("page factory is loaded");
		System.out.println("test");
		
		CommonUtilities.clickOn(driver, uDropdown.btn_Usermenu, 6);
		System.out.println(uDropdown.btn_Usermenu.getText());
		sa.assertEquals(uDropdown.btn_Usermenu.getText(), getTestData("usermenu.level"));
		test.info("usermenu is clicked");
		
		
		CommonUtilities.clickOn(driver, uDropdown.mySettings, 6);
		
		sa.assertEquals(uDropdown.mySettings.getText(), getTestData("usermenu_setting"));
		test.info("my setting is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.personalinfo, 6);
		test.info("personalinfo is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.login_history, 6);
		test.info("login_history is clicked");
		
		CommonUtilities.clickOn(driver, uDropdown.downloadfile, 6);
		
		
		
		File folder = new File("/Users/snigdha/Downloads");
		File[] files = folder.listFiles();
		for(File file : files) {
			
			String str = file.getName();
			
			if(str.startsWith("LoginHistory")) {
				sa.assertTrue(str.startsWith("LoginHistory"));
				System.out.println("Download File Validation Pass");
			}
		}
		
		File folder1 = new File(getTestData("filedownload_location"));
		File[] files1 = folder1.listFiles();
		for(File file : files1) {
			
			String str = file.getName();
			if(file.isFile()) {
				if(str.startsWith("LoginHistory")) {
					System.out.println("deleting files "+ str);
					file.delete();
				}
			}
		}
	 
	
	 
	 }
	catch(Exception e) {
		sa.assertTrue(false ,e.getMessage());
	}
	 finally {
		 sa.assertAll();
	 }
	 
	 
	 
	
	
  }

}
