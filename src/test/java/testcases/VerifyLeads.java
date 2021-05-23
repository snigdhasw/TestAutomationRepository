package testcases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import baseclass.BaseTest;
import testpagefactory.CreateOpty_PF;
import testpagefactory.Leads_PF;
import utilities.CommonUtilities;

public class VerifyLeads extends BaseTest{
	
	 Leads_PF  leadsPF;
	 
	 @BeforeMethod
		public void createReport(Method sTestMethod) {
			test = extentReports.createTest(sTestMethod.getName());
		}
	 @AfterMethod
		public void closeDriver() {
			driver.quit();
		}
	 
	 @Test
		public void tc20LeadsTab() {

			SoftAssert sa = new SoftAssert();
			try {
				login(sa);
				test.info("driver is initialize");
				leadsPF = new Leads_PF(driver);
				CommonUtilities.clickOn(driver, leadsPF.leads, 6);
				sa.assertNotNull(leadsPF.leads);
				System.out.println("leads button is clicked");
				test.pass("tc20LeadsTab is passed");
				
	 } catch (Exception e) {

			sa.assertTrue(false, e.getMessage());
		} finally {

			sa.assertAll();
		}
	 }
	@Test 
	 public void tc21LeadsSelectView() {

			SoftAssert sa = new SoftAssert();
			try {
				login(sa);
				test.info("driver is initialize");
				
				leadsPF = new Leads_PF(driver);
				CommonUtilities.clickOn(driver, leadsPF.leads, 6);
				sa.assertNotNull(leadsPF.leads);
				System.out.println("leads button is clicked");
				
				Thread.sleep(5000);
				CommonUtilities.clickOn(driver, leadsPF.leadsDropdown, 10);
				Select select = new Select( leadsPF.leadsDropdown);
				List<WebElement> dropDown = select.getOptions();

				List<String> list = new ArrayList<String> ();

				for (WebElement element : dropDown) {
					list.add(element.getText());
				}

				List<String> list1 = getString();

				System.out.println("list1 -> " + list1);
				System.out.println("list -> " + list);

				if (list.equals(list1)) {
				} else {
					System.out.println("the test failed");
				}
				
				sa.assertEquals(list, list1);
				test.pass("TC passed ");
				
	 } catch (Exception e) {

			sa.assertTrue(false, e.getMessage());
		} finally {

			sa.assertAll();
		}
	 }
	 
	 private List<String> getString() {

			String str = "All Open Leads,My Unread Leads," + "Recently Viewed Leads,Today's Leads,View - Custom 1,"
					+ "View - Custom 2";
			String[] temp = str.split(",");
			List<String> list = Arrays.asList(temp);
			
			return list;

		}
	 
	 @Test
	 public void tc22LeadsGo() {
		 SoftAssert sa = new SoftAssert();
		 try{
			 login(sa);
			 test.info("driver is initialize");
				
				leadsPF = new Leads_PF(driver);
				Thread.sleep(5000);
				CommonUtilities.clickOn(driver, leadsPF.leads, 6);
				//sa.assertNotNull(leadsPF.leads);
				System.out.println("leads button is clicked");
				
				Thread.sleep(5000);
				CommonUtilities.clickOn(driver, leadsPF.leadsDropdown, 6);
				Select select = new Select( leadsPF.leadsDropdown);
				select.selectByIndex(3);
				
				CommonUtilities.clickOn(driver, leadsPF.user, 6);
				Thread.sleep(5000);
				CommonUtilities.clickOn(driver, leadsPF.logout, 6);
				login(sa);
				 test.info("driver is initialize");
					Thread.sleep(5000);
					CommonUtilities.clickOn(driver,leadsPF.leads, 6);
//					sa.assertNotNull(leadsPF.leads);
//					System.out.println("leads button is clicked");
//					
//					CommonUtilities.clickOn(driver, leadsPF.leadsgo, 6);
//					sa.assertTrue(leadsPF.leadsgo.isEnabled());
//					
//					CommonUtilities.clickOn(driver, leadsPF.getRecord, 6);
//					sa.assertNotNull(leadsPF.getRecord);
//					
					test.pass("TC 22 is passed");
				
		 }catch(Exception e) {
					sa.assertTrue(false, e.getMessage());
				} finally {

					sa.assertAll();
				}
			 
		
	 }
	@Test 
		public void tc23LeadsTab() {

			SoftAssert sa = new SoftAssert();
			try {
				login(sa);
				test.info("driver is initialize");
				leadsPF = new Leads_PF(driver);
				
				CommonUtilities.clickOn(driver, leadsPF.leads, 6);
				sa.assertNotNull(leadsPF.leads);
				System.out.println("leads button is clicked");
				
				CommonUtilities.clickOn(driver, leadsPF.leadsDropdown, 10);
				Select select = new Select( leadsPF.leadsDropdown);
				select.selectByIndex(4);
				
				String  itext  = driver.findElement(By.xpath("//*[@id=\"fcf\"]/option[4]")).getText()	;
				System.out.println("the test passed sssssssssssssss" +itext );
				//sa.assertTrue(istrue);
				sa.assertEquals(itext, "Today's Leads");
				
				test.pass("tc23LeadsTab is passed");
				
	 } catch (Exception e) {

			sa.assertTrue(false, e.getMessage());
		} finally {

			sa.assertAll();
		}
	 }


}
