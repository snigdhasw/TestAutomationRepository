package testpagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UsermenuDropdown_PF {
	
    //WebDriver driver;
	public UsermenuDropdown_PF(WebDriver driver) {
		//this.driver = driver;
		//PageFactory.initElements(driver, UsermenuDropdown_PF.class);
		PageFactory.initElements(driver, this);
		
	}
	//userMenu
	@FindBy(id = "userNavLabel")
	public WebElement btn_Usermenu;
	
	//list of items under usermenu
	@FindBy(id = "userNav-menuItems")
	public List<WebElement> list_UsermenuList;
	
	//my setting under usermenu
	@FindBy(linkText = "My Settings")
	public WebElement mySettings;
	
	//personalinfo
	@FindBy(xpath = "//*[@id=\"PersonalInfo_font\"]")
	public WebElement personalinfo;
	
	//click on login history link
	@FindBy(xpath = "//*[@id=\"PersonalInfo_child\"]/div[8]")
	public WebElement login_history;
	
	//click to download the .csv file
	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement downloadfile;
	
	//ddeveloper console ;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[3]" )
	public WebElement devConsole;
	
	//logout from usermenu
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[5]")
	public WebElement logout;
	
	
	
	


}
