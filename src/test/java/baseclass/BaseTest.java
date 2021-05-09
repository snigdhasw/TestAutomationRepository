package baseclass;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.AppConstants;
import utilities.CommonUtilities;

public class BaseTest {
	
	public static String reportTime;
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extentReports;
	// helps to generate the logs in test report.
	public static ExtentTest test;
	
	public static Properties webElementProp;
	public static Properties userAccountProp;
	public static Properties testDataProp;
	
	
	
	@BeforeSuite
	public void setup() throws Exception {
		initializeReport();
		loadWebElementProp();
		loadUserAccountProp();
		loadTestDataProp();
	}
	
    private void loadTestDataProp() throws Exception {
		
		FileInputStream file = new FileInputStream(AppConstants.TEST_DATA_PROP_PATH);
		testDataProp = new Properties();
		testDataProp.load(file);
		System.out.println("loadTestDataProp complete");
	}
	
	private void loadWebElementProp() throws Exception {
		
		FileInputStream file = new FileInputStream(AppConstants.WEB_ELEMENT_PROP_PATH);
		webElementProp = new Properties();
		webElementProp.load(file);
		System.out.println("loadUserAccountProp complete");
	}
	
    private void loadUserAccountProp() throws Exception  {
    	
		FileInputStream file = new FileInputStream(AppConstants.USER_ACC_PROP_PATH);
		userAccountProp = new Properties();
		userAccountProp.load(file);
		System.out.println("loadUserAccountProp complete");
	}
    
    public static String getWebElement(String webElementKey) throws Exception {
    	
		String value = webElementProp.getProperty(webElementKey);
		//System.out.println(webElementKey +" - "+value);
		return value;
	}
	
    public static String getUserAccElement(String userAccElementKey) throws Exception {
    
		String value = userAccountProp.getProperty(userAccElementKey);
		return value;
	}
    
    public static String getTestData(String testdata) throws Exception {

		String value = testDataProp.getProperty(testdata);
		return value;
	}
    
	@AfterSuite
	public void tearDown() {
		driver.close();
		extentReports.flush();
	}
	
	public static void initializeReport() {

		reportTime = new SimpleDateFormat("MM-dd-yyyy-HHmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(AppConstants.HTML_REPORT_PATH+"/"+reportTime+".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
	}
	
	public static void initializeDriver() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getWebElement("web.url"));
	}
	
   public static void login(SoftAssert sa) throws Exception {
		
		 
		initializeDriver();
		sa.assertEquals(driver.getTitle(), getTestData("salesforce.title"));
		test.info("page is loaded");

		WebElement username = driver.findElement(By.id(getWebElement("web.username.path")));
		username.clear();
		test.info("username field is cleared");
		CommonUtilities.sendingKeys(driver, username, 6, getUserAccElement("user.account"));
		test.info("username is entered");

		sa.assertNotNull(username, "scfdfvd");

		WebElement password = driver.findElement(By.id(getWebElement("web.pass.path")));
		password.clear();
		test.info("password field is cleared");
		
		sa.assertNotNull(password, "password is not null");
		
		CommonUtilities.sendingKeys(driver, password, 6, getUserAccElement("user.pass"));
		String s = password.getText();

		WebElement login = driver.findElement(By.id(getWebElement("login.button.path")));
		CommonUtilities.clickOn(driver, login, 6);
		
		 s = password.getText();
		sa.assertEquals(password.getText(), getUserAccElement("user.pass"));
		test.info("password is entered");
		
		
		try {

			driver.findElement(By.linkText("Remind Me Later")).click();

		} catch (Exception e1) {
			// e1.printStackTrace();
			System.out.println("Please ignore the error -> " + e1.getMessage());
		}
	}
	
	

}
