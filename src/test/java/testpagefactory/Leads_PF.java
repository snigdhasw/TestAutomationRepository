package testpagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads_PF {
	
public Leads_PF(WebDriver driver) {
		
		PageFactory.initElements(driver,this); 
	}

//findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"))
@FindBy(xpath = "//*[@id=\"Lead_Tab\"]/a")
public WebElement leads;

//xpath("//*[@id=\"fcf\"]"));
@FindBy(xpath = "//*[@id=\"fcf\"]")
public WebElement leadsDropdown;

//xpath("//*[@id=\"userNavLabel\"]"))
@FindBy(xpath ="//*[@id=\"userNavLabel\"]")
public WebElement user;

//xpath("//a[@title = 'Logout']"
@FindBy(xpath ="//a[@title = 'Logout']")
public WebElement logout;

//xpath("//input[@value = ' Go! ']"
@FindBy(xpath ="//input[@value = ' Go! ']")
public WebElement leadsgo;

//getRecord = driver.findElement(By.xpath("//div[@class = 'x-grid-empty']"
@FindBy(xpath ="//div[@class = 'x-grid-empty']")
public WebElement getRecord;

}
