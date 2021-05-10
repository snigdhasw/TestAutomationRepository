package testcases;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
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

}
