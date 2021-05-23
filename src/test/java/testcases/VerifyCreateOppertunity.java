package testcases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
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

	@Test
	public void tc15optnyDropdown() {

		SoftAssert sa = new SoftAssert();
		try {

			login(sa);
			test.info("driver is initialize");

			uDropdown = new CreateOpty_PF(driver);
			test.info("page factory is loaded");
			System.out.println("test");

			CommonUtilities.clickOn(driver, uDropdown.oppertunity, 6);

			// CommonUtilities.clickOn(driver, uDropdown.select_Opportunities, 6);
			List<WebElement> list = uDropdown.select_Opportunities;
			String menuListFromWeb = list.get(0).getText();
			System.out.println("23232323232323 " + menuListFromWeb);
			String[] menuListFromWebArray = menuListFromWeb.split("\n");
			Arrays.sort(menuListFromWebArray);
			
			sa.assertTrue(isAllOptListItemsExist(menuListFromWebArray), "All items are exist");
			test.info("All items are exist");

		} catch (Exception e) {

			sa.assertTrue(false, e.getMessage());
		} finally {

			sa.assertAll();
		}

	}

	private boolean isAllOptListItemsExist(String[] menuListFromWebArray) {

		String[] temp = getTestData("oppertunity_dropdown").split(",");
         Arrays.sort(temp);
		return Arrays.equals(menuListFromWebArray, temp);

	}

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
			//*[@id="bodyCell"]/div[1]/div[1]/div[1]/h2
			System.out.println(" vvvvvvvvvvv   "+uDropdown.valid.getText());
			sa.assertEquals("SapceX did a successful landing",uDropdown.valid.getText());
			test.pass("test is passed");
			
			
			
		}
		catch(Exception e) {
			
			sa.assertTrue(false,e.getMessage());
		}
		finally {
			sa.assertAll();
		}
		
		
		
	}

	@Test
	public void tc17OptPipeline() {
	
		
		SoftAssert sa = new SoftAssert();
		try {
			
			login(sa);
			test.info("driver is initialize");

			uDropdown = new CreateOpty_PF(driver);
			test.info("page factory is loaded");
			System.out.println("tc17OptPipeline test");
			Thread.sleep(5000);
			
			CommonUtilities.clickOn(driver, uDropdown.oppertunity, 6);
			test.info("oppertunity is clicked");
			
			CommonUtilities.clickOn(driver, uDropdown.opPipeline, 6);
			test.info("oppertunitypipeline is clicked");
			Thread.sleep(5000);
			
			System.out.println(uDropdown.validation2.getText());
			sa.assertEquals(uDropdown.validation2.getText(), "Opportunity Pipeline");
			test.pass("Test is passed");
			
		}
		catch(Exception e) {
			
			sa.assertTrue(false, e.getMessage());			
		}
		
		finally {
			
			sa.assertAll();
		}
		
	}

	@Test
	public void tc18StuckOppertunity() {
		SoftAssert sa = new SoftAssert();
	  try {
		  login(sa);
		  test.info("driver is initialize");

			uDropdown = new CreateOpty_PF(driver);
			test.info("page factory is loaded");
			System.out.println("tc17OptPipeline test");
			Thread.sleep(5000);
			
			CommonUtilities.clickOn(driver, uDropdown.oppertunity, 6);
			test.info("oppertunity is clicked");
			
			CommonUtilities.clickOn(driver, uDropdown.stuckOpt, 6);
			test.info("StuckOppertunity is clicked");
			
			//CommonUtilities.clickOn(driver, uDropdown.getRrport, 6);
			test.info("StuckOppertunity is clicked");
			sa.assertNotNull( uDropdown.getRrport," the element is not null");
			
			test.pass("Test is pass");
			
			
		  
	  }
	  catch(Exception e) {
		  sa.assertFalse(true, e.getMessage());
	  }
	  
	  finally {
		  sa.assertAll();
	  }
	
	}

	@Test
	public void tc19QuaterlySummery() {
		SoftAssert sa = new SoftAssert();
		try {
			login(sa);
			test.info("driver is initialize");

			uDropdown = new CreateOpty_PF(driver);
			test.info("page factory is loaded");
			System.out.println("tc19QuaterlySummery test");
			Thread.sleep(5000);

			CommonUtilities.clickOn(driver, uDropdown.oppertunity, 6);
			test.info("oppertunity is clicked");

			CommonUtilities.clickOn(driver, uDropdown.quaterlyReport, 6);
			test.info("quaterlyReport is accessed");

			Select select = new Select(uDropdown.quaterlyReport);
			List<WebElement> dropdown = select.getOptions();

			List<String> list = new ArrayList<String>();
			for (WebElement element : dropdown) {
				list.add(element.getText().trim());
			}

			String str = "Current FQ,Current and Next FQ, Next FQ,Previous FQ, Current and Next 3 FQ, Current FY,Current and Next FY, Current and Previous FY,Previous FY, Next FY";
			String[] str1 = str.split("," );
			
			List<String> list1 = Arrays.asList(str1);
			
			List<String> list2 = new ArrayList();
			for(String s : list1) {
				list2.add(s.trim());
			}
			
			if (list.equals(list2)) {
				System.out.println("Quaterly Report passed");
			} else {
				System.out.println("Quaterly Report failed");
			}
			
			sa.assertEquals(list, list2);

			test.pass("Test is pass");

		} catch (Exception e) {
			sa.assertFalse(true, e.getMessage());
		}

		finally {
			sa.assertAll();
		}

	}

}
