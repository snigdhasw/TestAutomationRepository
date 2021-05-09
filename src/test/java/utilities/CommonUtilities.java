package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import baseclass.BaseTest;

public class CommonUtilities extends BaseTest{

  
	public static void clickOn(WebDriver driver, WebElement element, int time) {

		if (element.isDisplayed()) {

			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

			System.out.println("Element is clicked -  " + element);
		}

	}

	public static void sendingKeys(WebDriver driver, WebElement element, int time, String seedingValue) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(seedingValue);

	}
	
	
	
}
