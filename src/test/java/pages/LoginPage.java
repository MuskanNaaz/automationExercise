package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	WebDriver driver;
	public HomePage homePage;
	public RegistrationPage registrationPage;

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
	
	@FindBy(xpath = "//p[text() ='Your email or password is incorrect!']")
	WebElement incorrectPassword;
	
	@FindBy(xpath = "//input[@value = 'signup']/following-sibling::button")
	WebElement signUpButton;
	
	@FindBy(name = "name")
	WebElement provideName;
	
	@FindBy(xpath = "//*[@class = 'signup-form']/form/input[3]")
	WebElement provideNewEmail;

	public void singUp_Login() {
		SignUp_Login.click();
	}

	public void provide_Email_Password(String email, String password) throws InterruptedException {
		provideEmail.sendKeys(email);
		providePassword.sendKeys(password);

		Thread.sleep(2000);

		homePage = new HomePage(driver);
		

	}
	
	public void provide_New_Email_Password(String name, String email) throws InterruptedException {
		provideName.sendKeys(name);
		provideNewEmail.sendKeys(email);

		Thread.sleep(2000);		

	}
	
	public RegistrationPage clickSignUp() throws InterruptedException {
		signUpButton.click();
		
		Thread.sleep(2000);
		registrationPage = new RegistrationPage(driver);
		
		return registrationPage;
	}

	public HomePage clickLogin() throws InterruptedException {
		Login.click();
		Thread.sleep(2000);

		homePage = new HomePage(driver);

		return homePage;

	}
	
	public String incorrect_creds() {
		return incorrectPassword.getText();
	}

}
