package testpagefactory;

import java.util.List;

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
	
	@FindBy(id = "userNavLabel")
	public WebElement btn_Usermenu;
	
	@FindBy(id = "userNav-menuItems")
	public List<WebElement> list_UsermenuList;
	
	


}
