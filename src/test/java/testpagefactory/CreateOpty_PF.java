package testpagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOpty_PF {
	
	public CreateOpty_PF(WebDriver driver) {
		
		PageFactory.initElements(driver,this); 
	
	}
	
	@FindBy(linkText = "Opportunities")
	public WebElement oppertunity;
	
	@FindBy(id = "fcf")
	public List<WebElement> select_Opportunities;
	

}
