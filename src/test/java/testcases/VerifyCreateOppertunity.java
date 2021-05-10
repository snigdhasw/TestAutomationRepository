package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseclass.BaseTest;
import testpagefactory.CreateOpty_PF;
import utilities.CommonUtilities;

public class VerifyCreateOppertunity extends BaseTest {

	CreateOpty_PF uDropdown;

	@BeforeMethod
	public void createReport(Method sTestMethod) {
		test = extentReports.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

//	@Test
//	public void tc15optnyDropdown() {
//
//		SoftAssert sa = new SoftAssert();
//		try {
//
//			login(sa);
//			test.info("driver is initialize");
//
//			uDropdown = new CreateOpty_PF(driver);
//			test.info("page factory is loaded");
//			System.out.println("test");
//
//			CommonUtilities.clickOn(driver, uDropdown.oppertunity, 6);
//
//			// CommonUtilities.clickOn(driver, uDropdown.select_Opportunities, 6);
//			List<WebElement> list = uDropdown.select_Opportunities;
//			String menuListFromWeb = list.get(0).getText();
//			System.out.println("23232323232323 " + menuListFromWeb);
//			String[] menuListFromWebArray = menuListFromWeb.split("\n");
//			Arrays.sort(menuListFromWebArray);
//			
//			sa.assertTrue(isAllOptListItemsExist(menuListFromWebArray), "All items are exist");
//			test.info("All items are exist");
//
//		} catch (Exception e) {
//
//			sa.assertTrue(false, e.getMessage());
//		} finally {
//
//			sa.assertAll();
//		}
//
//	}
//
//	private boolean isAllOptListItemsExist(String[] menuListFromWebArray) {
//
//		String[] temp = getTestData("oppertunity_dropdown").split(",");
//         Arrays.sort(temp);
//		return Arrays.equals(menuListFromWebArray, temp);
//
//	}
	
	@Test
	public void tc16CreateNewOptny() {
		
		
		SoftAssert sa = new SoftAssert();
		try {
			

			login(sa);
			test.info("driver is initialize");

			uDropdown = new CreateOpty_PF(driver);
			test.info("page factory is loaded");
			System.out.println("test");
			Thread.sleep(5000);
			CommonUtilities.clickOn(driver, uDropdown.oppertunity, 6);
			test.info("oppertunity is clicked");
			
			CommonUtilities.clickOn(driver, uDropdown.newOptny, 6);
			test.info("New oppertunity is clicked");
			
			CommonUtilities.sendingKeys(driver, uDropdown.closeDate, 6, "05/10/2021");
			System.out.println("xxxxxxxx 05/10/2021");
			test.info("closing date has been  entered");
			
			
			CommonUtilities.sendingKeys(driver, uDropdown.send_message, 6, "SapceX did a successful landing");
			System.out.println("xxxxxxxx SapceX did a successful landing");
			test.info("massage has been send");
			
			Select select = new Select(uDropdown.stage);
			select.selectByIndex(2);
			test.info("stage has been selected");
			
			Select select1 = new Select(uDropdown.leadDropdown);
			select1.selectByIndex(2);
			test.info("lead dropdown has been selected");
			
			CommonUtilities.clickOn(driver, uDropdown.save, 6);
			Thread.sleep(5000);
			test.info("changes have been saved");
			
			//*[@id="bodyCell"]/div[1]/div[1]/div[1]/h2
			
			
			
		}
		catch(Exception e) {
			
			sa.assertTrue(false,e.getMessage());
		}
		finally {
			sa.assertAll();
		}
		
		
		
	}

}
