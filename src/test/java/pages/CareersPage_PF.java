package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CareersPage_PF extends AbstractComponent{
	
WebDriver driver;
	
	public CareersPage_PF(WebDriver driver)
	{
		
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
		
	}
	
	 //driver.findElement(By.id("onetrust-pc-btn-handler")).click();
	 
	 @FindBy(id="onetrust-pc-btn-handler")
		WebElement cookiesBtn1;
    
    //driver.findElement(By.xpath("//button[text()='Confirm My Choices']")).click();
	 
	 @FindBy(xpath="//button[text()='Confirm My Choices']")
		WebElement ConfirmChoicesBtn;
	 
	 //driver.findElement(By.xpath("//a[@class='score-button btn-red']")).click();
	 @FindBy(xpath="//a[@class='score-button btn-red']")
		WebElement SearchBtn;
	 
	 public void ClickCookiesAndSearchBtn()
	 {
		 cookiesBtn1.click();
		 ConfirmChoicesBtn.click();
		 SearchBtn.click();
		 
		 
	 }
	 
	//searchBox = driver.findElement(By.id("search-box-d3ba3a32752d48908f4061d0129326bf"));
     //searchBox.sendKeys("automation tester");
	 @FindBy(id="search-box-d3ba3a32752d48908f4061d0129326bf")
		WebElement SearchJobsText;
	 
	 //driver.findElement(By.id("search-box-button")).click();
	 @FindBy(id="search-box-button")
		WebElement SearchJobsBtn1;
	 
	 
	 By searcBtnWait = By.id("search-box-d3ba3a32752d48908f4061d0129326bf");
	 
	 public void EnterTextInSearchBox(String searchText)
	 {
		 waitForVisibilityOfElement(searcBtnWait);
		 SearchJobsText.sendKeys(searchText);
		 //SearchJobsBtn1.click();
		 
	 }
	 
	 public void ClickSearchJobsBtn()
	 {
		 SearchJobsBtn1.click();
	 }
	 
By SearchJobResults = By.xpath("//div[@class='ais-hits--item']");
	 
	 //List<WebElement> jobResults = driver.findElements(By.xpath("//div[@class='ais-hits--item']"));
	 
	 @FindBy(xpath="//div[@class='ais-hits--item']")
	 List<WebElement> jobResults;
	 
	 public List<WebElement> getSearchJobResults()
	 {
		 waitForPresenceOfAllElements(SearchJobResults);
		 return jobResults;
	 }
	 
	 
	

}
