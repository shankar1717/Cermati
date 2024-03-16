package stepdefinition;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsForProductSearch extends BaseClass {
	//static WebDriver driver;
	WebDriverWait wait;


	@Given("User is on the eBay homepage")
	public void user_is_on_the_e_bay_homepage() {
		//		driver = new ChromeDriver();
		//		WebDriverManager.chromedriver().setup();
		//		driver.manage().window().maximize();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		setUp();
		driver.get("https://www.ebay.com/");


	}

	@When("User types {string} in the search bar")
	public void user_types_in_the_search_bar(String searchString) {
		WebElement searchInput = driver.findElement(By.xpath("//input[@type='text']"));
		searchInput.sendKeys(searchString);
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		searchInput.sendKeys(Keys.ENTER);

	}

	@When("User changes the search category and clicks Search")
	public void user_changes_the_search_category_and_clicks_search() {

		WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
		categoryDropdown.click();
		Select s = new Select(categoryDropdown);
		s.selectByVisibleText(categoryValue);
		// WebElement chosenCategory = driver.findElement(By.xpath("//option[text()='Computers/Tablets &
		// Networking']"));
		// chosenCategory.click();
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
		searchButton.click();
	}

	@Then("User verifies that the page loads completely")
	public void user_verifies_that_the_page_loads_completely() {
		//		String title = driver.getTitle();
		//		System.out.println("------Current Page Title:" + title);

		boolean pageLoadStatus = isPageLoaded();
		Assert.assertTrue(pageLoadStatus);
		//String message = pageLoadStatus ? "-------Page loaded completely." : "------Page did not load completely.";
		//System.out.println(message);
	}

	public boolean isPageLoaded() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.readyState").equals("complete");
	}



	@Then("User verifies that the first result name matches with the search string")
	public void user_verifies_that_the_first_result_name_matches_with_the_search_string() {
		WebElement firstResult = driver.findElement(By.xpath("//li[@id='item4d8cbf0397']//div[@class='s-item__title']"));
		String actualFirstResultName = firstResult.getText();
		System.out.println("-----ActualFirstResultName: " + actualFirstResultName );
		String expectedsearchString = searchTextValue.toLowerCase();
		System.out.println("-----ExpectedsearchString: "+ expectedsearchString);
		Assert.assertTrue(actualFirstResultName.toLowerCase().contains(expectedsearchString));
		// Assertion to check if the actualFirstResultName contains the expectedSearchString
	
		if (actualFirstResultName.toLowerCase().contains(expectedsearchString)) {
			System.out.println("-----First result name matches with the Expected search string.");
		} else {
			System.out.println("-----First result name does not match with the Expected search string.");
		}


		//All title=//div[@class='srp-river-results clearfix']//div[@class='s-item__title']
		//List<WebElement> results =driver.findElements(By.xpath("//div[@class='srp-river-results clearfix']//div[@class='s-item__title']"));
		//String firstResultText = results.get(0).getText(); // Get the text of the first result
		//System.out.println("-----firstResultText:"+ firstResultText );
		//Assert.assertTrue(firstResultText.toLowerCase().contains("macbook"));

		tearDown();
	}
}
