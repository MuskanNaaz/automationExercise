package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text() = 'Enter Account Information']")
	WebElement accountInfo;
	
	public String account_Information() {
		System.out.println("Account Info is " + accountInfo.getText());
		return accountInfo.getText();
		
	}
}
