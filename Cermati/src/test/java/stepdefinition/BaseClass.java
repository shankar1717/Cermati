package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public WebDriverWait wait;
	ReadConfig rd = new ReadConfig();

	//config
	public String conditionValue = rd.getCondition();
	public String minPriceValue = rd.getMinPrice();
	public String maxPricevalue = rd.getMaxPrice();
	public String itemLocationValue = rd.getItemLocation();
	public String categoryValue = rd.getCategoryDropdown();
	public String searchTextValue = rd.getSearchText();

	public static void setUp() {
		// Setting up Chrome WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
