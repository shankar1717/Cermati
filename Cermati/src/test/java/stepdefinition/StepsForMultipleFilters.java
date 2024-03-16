package stepdefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsForMultipleFilters extends BaseClass {

	@Given("User navigates to eBay homepage")
	public void user_navigates_to_e_bay_homepage() {

		setUp();
		driver.get("https://www.ebay.com/");
	}

	@When("User selects {string} from the category dropdown")
	public void user_selects_from_the_category_dropdown(String string) {

		WebElement category = driver.findElement(By.xpath("//button[@id='gh-shop-a']"));
		category.click();

		// WebElement electronics =
		// driver.findElement(By.xpath("//a[@href='https://www.ebay.com/b/Electronics/bn_7000259124']"));
		// wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(electronics));
		// electronics.click();
		// driver.findElement(By.xpath("//input[@value='Search']")).click();
		// driver.findElement(By.xpath("(//a[text()='" + string + "'])[2]")).click();

	}

	@When("User selects Cell Phones & accessories")
	public void user_selects_cell_phones_accessories() {

		WebElement subCategory = driver.findElement(By.xpath("//a[text()='Cell phones & accessories']"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(subCategory));
		subCategory.click();

	}

	@When("User clicks on {string} in the left-hand side navigation")
	public void user_clicks_on_in_the_left_hand_side_navigation(String string) {
		WebElement navigation = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		navigation.click();

	}

	@When("User clicks on All Filters")
	public void user_clicks_on_all_filters() {
		WebElement allFilters = driver
				.findElement(By.xpath("//*[@class='brm b-refine-menu']//button[text()='All Filters']"));
		Actions a = new Actions(driver);
		a.moveToElement(allFilters).click().perform();

	}

	@When("User adds {int} filters: Condition, Price, and Item location")
	public void user_adds_filters_condition_price_and_item_location(int int1) throws Exception {

		// select condition
		WebElement conditionFilter = driver.findElement(By.xpath("//*[@id='c3-mainPanel-condition']"));
		conditionFilter.click();

		WebElement conditionElement = driver.findElement(By
				.xpath("//span[@class='cbx x-refine__multi-select-cbx'][normalize-space()='" + conditionValue + "']"));
		wait.until(ExpectedConditions.visibilityOf(conditionElement));
		conditionElement.click();
		Thread.sleep(2000);
		boolean isSelected = conditionElement.isEnabled();
		// Assertion to verify if the element is selected
		Assert.assertTrue(isSelected);

		// Thread.sleep(2000);
		// select price
		WebElement priceFilter = driver.findElement(By.xpath("//div[@id='c3-mainPanel-price']"));
		priceFilter.click();

		// driver.findElement(By.xpath("//div[@id='c3-mainPanel-price']//span[text()='Price']")).click();
		WebElement minPriceInput = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@aria-label='Minimum Value, US Dollar']")));
		minPriceInput.sendKeys(minPriceValue);

		WebElement maxPriceInput = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@aria-label='Maximum Value, US Dollar']")));
		maxPriceInput.sendKeys(maxPricevalue);
		// Thread.sleep(2000);

		// select item location
		WebElement locationFilter = driver.findElement(By.xpath("//div[@id='c3-mainPanel-location']"));
		locationFilter.click();

		WebElement locationCheckBox = driver.findElement(By.xpath("//input[@value='" + itemLocationValue + "']"));
		locationCheckBox.click();
		Thread.sleep(2000);

		boolean isEnabled = locationCheckBox.isEnabled();
		// Assertion to verify if the element is selected
		Assert.assertTrue(isEnabled);

		Thread.sleep(2000);

	}

	@When("User clicks on Apply")
	public void user_clicks_on_apply() {

		WebElement applyButton = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
		applyButton.click();
	}

	@Then("User verifies that the filter tags are applied")
	public void user_verifies_that_the_filter_tags_are_applied() {

		// Find and click on the button to view applied filters
		WebElement noOfFilters = driver
				.findElement(By.xpath("//li[@class='brm__item brm__item--applied']//button[@type='button']"));
		noOfFilters.click();

		// Print a separator for better readability
		System.out.println("======================================================================");

		// Find all the applied filters
		List<WebElement> appliedFilters = driver
				.findElements(By.xpath("//li[@class='brm__item brm__item--applied']//li"));
		System.out.println("No Of Filters Applied: " + appliedFilters.size());

		// Extract the text of the applied filters and store them in a list
		List<String> appliedFilterValues = new ArrayList<>();
		for (WebElement filter : appliedFilters) {
			// Get the text of the filter and trim any extra whitespace
			String filterText = filter.getText().trim();
			// Split the text into parts using ": " as a delimiter
			String[] parts = filterText.split(": ");
			// Check if there are multiple parts (indicating a filter name and value)
			if (parts.length > 1) {
				// Extract the filter value, remove "filter applied" if present, and trim any
				// extra whitespace
				appliedFilterValues.add(parts[1].replace("filter applied", "").trim());
			}
		}

		// Define the expected filters
		String[] expectedFilters = { conditionValue, "$100.00 to $500.00", itemLocationValue };

		// Additional logging for debugging purposes
		System.out.println("Expected Filters: " + Arrays.toString(expectedFilters));
		System.out.println("Applied Filters:  " + appliedFilterValues);

		// Assertion to verify if the applied filters match the expected values
		Assert.assertEquals(Arrays.asList(expectedFilters), appliedFilterValues);
		
		tearDown();
	}
}