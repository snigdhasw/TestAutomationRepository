package testpagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOpty_PF {
	
	public CreateOpty_PF(WebDriver driver) {
		
		PageFactory.initElements(driver,this); 
	
	}
	
	@FindBy(linkText = "Opportunities")
	public WebElement oppertunity;
	
	@FindBy(id = "fcf")
	public List<WebElement> select_Opportunities;
	
	
	@FindBy(xpath = "//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
	public WebElement newOptny;
	
	@FindBy(id = "opp9")
	public WebElement closeDate;
	
	
	//driver.findElement(By.xpath("//*[@id=\"opp9\"]")).sendKeys("04/22/2021");
	//optny name 
	@FindBy(id = "opp3")
	public WebElement send_message;
	
	
	//driver.findElement(By.xpath("//*[@id=\"opp3\"]")).sendKeys("Rover just landed in the moon");
	
	//stage dropdown
	@FindBy(id = "opp11")
	public WebElement stage;
	//WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"opp11\"]"));
	//Select select = new Select(dropdown);
	//select.selectByIndex(2);
	
	//lead dropdown
	@FindBy(id = "opp6")
	public WebElement leadDropdown;
//	WebElement leadDropdown = driver.findElement(By.xpath("//*[@id=\"opp6\"]"));
//	Select select1 = new Select(leadDropdown);
//	select1.selectByIndex(2);
	
	//save button
	@FindBy(name = "save")
	public WebElement save;
	
	@FindBy(xpath = "//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h2")
	public WebElement valid;
	
	//WebElement opPipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
	@FindBy(linkText = "Opportunity Pipeline")
	public WebElement opPipeline;
	
	//*[@id="noTableContainer"]/div/div[1]/div[1]/div[1]/h1
	@FindBy(xpath = "//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")
	public WebElement validation2;
	
	//WebElement stuckOpt = driver.findElement(By.linkText("Stuck Opportunities"));
	@FindBy(linkText = "Stuck Opportunities")
	public WebElement stuckOpt;
	
	@FindBy(xpath = "//*[@id=\"report\"]/div[2]/div[2]/input[6]")
	public WebElement getRrport;
	
	//WebElement quaterlyReport = driver.findElement(By.id("quarter_q"))
	@FindBy(id = "quarter_q")
	public WebElement quaterlyReport ;
	
	

}
