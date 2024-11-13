package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath = " //a[contains(text(),'Logged in as')]")
	WebElement Logged;
	
	
	
	public String Currently_Logged() {
		return Logged.getText();
	}
	

}
