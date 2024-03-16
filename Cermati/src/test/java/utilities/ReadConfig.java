package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop = new Properties();

	public ReadConfig() {

		try {
			FileInputStream source = new FileInputStream(
					System.getProperty("user.dir") + "/configuration/config.properties");
			prop.load(source);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getCondition() {
		return prop.getProperty("Condition");
	}

	public String getMinPrice() {
		return prop.getProperty("MinPrice");
	}

	public String getMaxPrice() {
		return prop.getProperty("MaxPrice");
	}

	public String getItemLocation() {
		return prop.getProperty("ItemLocation");
	}

	public String getCategoryDropdown() {
		return prop.getProperty("CategoryDropdown");
	}

	public String getSearchText() {
		return prop.getProperty("SearchText");

	}

	public String getURL() {
		return prop.getProperty("url");
	}

}
