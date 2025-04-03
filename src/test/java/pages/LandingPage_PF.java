package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage_PF extends AbstractComponent{
	
	
	
	WebDriver driver;
	
	public LandingPage_PF(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="onetrust-accept-btn-handler")
	WebElement CookieBtn;
	

	@FindBy(linkText="About Us")
	WebElement AboutUslink;
	
	public void ClickCookieBtn()
	{
		
		CookieBtn.click();
		
	}
	
	

	public void ClickAboutUsLink()
	{
		
		AboutUslink.click();
		
	}
	
	
	@FindBy(xpath="(//a[@class='score-button btn-clickable-area'])[3]")
	WebElement Careerslinks;
	
	By careersWait = By.linkText("Learn More");
	public void CareersLink()
	{
		waitForElementToBeClickable(careersWait);
		Careerslinks.click();
	}
	
	

}
