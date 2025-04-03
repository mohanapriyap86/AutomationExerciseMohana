package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) 
	
	{
		this.driver = driver;
	}

	public void waitForElementToBeClickable(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	
	public void waitForVisibilityOfElement(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    
	}
	
	public void waitForPresenceOfAllElements(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findBy));
	}

}
