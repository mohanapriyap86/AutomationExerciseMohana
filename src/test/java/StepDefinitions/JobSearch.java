package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CareersPage_PF;
import pages.LandingPage_PF;

public class JobSearch {

	WebDriver driver;

	LandingPage_PF landingPage1;

	CareersPage_PF careersPage1;

	@Before
	public void browserSetup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {

		driver.get("https://risk.lexisnexis.co.uk/");
		
	}

	@When("User clicks on About Us link")
	public void user_clicks_on_about_us_link() {

		landingPage1 = new LandingPage_PF(driver);
		landingPage1.ClickCookieBtn();

		//driver.findElement(By.linkText("About Us")).click();

		landingPage1.ClickAboutUsLink();

	}

	@And("User clicks on Careers link")
	public void user_clicks_on__careers_link() {

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn More")));
		//driver.findElement(By.xpath("(//a[@class='score-button btn-clickable-area'])[3]")).click();
		landingPage1 = new LandingPage_PF(driver);
		landingPage1.CareersLink();
	}

	@And("User Navigates to Careers page")
	public void user_navigates_to_careers_page() {

		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}


	}

	@And("User clicks on Search all jobs button")
	public void user_clicks_on_Search_all_jobs_button() {


		//driver.findElement(By.id("onetrust-pc-btn-handler")).click();
		//driver.findElement(By.xpath("//button[text()='Confirm My Choices']")).click();
		//driver.findElement(By.xpath("//a[@class='score-button btn-red']")).click();
		careersPage1 = new CareersPage_PF(driver);
		careersPage1.ClickCookiesAndSearchBtn();


	}


	@And("^User enters a text (.*) in search box$")
	public void user_enters_a_text_in_search_box(String searchText) {

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-box-d3ba3a32752d48908f4061d0129326bf")));
		//driver.findElement(By.id("search-box-d3ba3a32752d48908f4061d0129326bf")).sendKeys(searchText);
		careersPage1 = new CareersPage_PF(driver);
		careersPage1.EnterTextInSearchBox(searchText);
	}

	@And("clicks search button")
	public void clicks_search_button() {

		//driver.findElement(By.id("search-box-button")).click();
		careersPage1 = new CareersPage_PF(driver);
		careersPage1.ClickSearchJobsBtn();

	}

	@Then("User should see at least one job result")
	public void user_should_see_at_least_one_job_result() {

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ais-hits--item']")));
		//List<WebElement> jobResults = driver.findElements(By.xpath("//div[@class='ais-hits--item']"));
		careersPage1 = new CareersPage_PF(driver);
		List<WebElement> jobResults = careersPage1.getSearchJobResults();
		//Assert.assertTrue(jobResults.size() > 0, "Test Failed: No search results found for 'Automation Tester'.");
		Assert.assertTrue("Test Failed: No search results found for 'Automation Tester'.", 
	            jobResults.size() > 0);



	}

	@After
	public void teardown()
	{

		driver.close();
		driver.quit();

	}


}
