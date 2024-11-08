package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	WebDriver driver;
	public HomePage homePage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@class  = 'nav navbar-nav']/li[4]/a")
	WebElement SignUp_Login;

	@FindBy(name = "email")
	WebElement provideEmail;

	@FindBy(name = "password")
	WebElement providePassword;

	@FindBy(xpath = "//*[text()= 'Login']")
	WebElement Login;

	public void singUp_Login() {
		SignUp_Login.click();
	}

	public void provide_Email_Password(String email, String password) throws InterruptedException {
		provideEmail.sendKeys(email);
		providePassword.sendKeys(password);

		Thread.sleep(2000);

		homePage = new HomePage(driver);
		

	}

	public HomePage clickLogin() throws InterruptedException {
		Login.click();
		Thread.sleep(2000);

		homePage = new HomePage(driver);

		return homePage;

	}

}
