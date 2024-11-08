package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.cucumber.java.it.Ed;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigDataClass;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;

	ConfigDataClass configData = new ConfigDataClass();

	
	
	public WebDriver initilization() throws InterruptedException {
		String browserName = configData.getBrowser();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		String baseUrl = configData.getUrl();
		driver.get(baseUrl);
		Thread.sleep(5000);
		return driver;
	}

	//@Test
	public LoginPage launchApplication() throws InterruptedException {
		driver = initilization();
		loginPage = new LoginPage(driver);
		return loginPage;

	}

}
