package stepDefinitation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class TC_Login_001 extends BaseClass {
	
	public LoginPage loginPage;
	public HomePage homePage;

	@Given("I landed on Login page")
	public void i_landed_on_login_page() throws InterruptedException {
		loginPage = launchApplication();
		loginPage.singUp_Login();

	}

	@When("Logged in the username {string} and pasword {string}")
	public void logged_in_the_username_and_pasword(String email, String passWord) throws InterruptedException {
		loginPage.provide_Email_Password(email, passWord);
	}

	@When("clicks the login button")
	public void clicks_the_login_button() throws InterruptedException {
		homePage = loginPage.clickLogin();

	}

	@Then("the user should landed on the Features Items page and see feature Page {string}")
	public void the_user_should_landed_on_the_features_items_page_and_see_feature_page(String string) {
		String loggedInMessage = homePage.Currently_Logged();
		System.out.println("The Logged in VALUE is "+loggedInMessage);
		System.out.println("The string Logged value is " + string);
		Assert.assertTrue(loggedInMessage.equalsIgnoreCase(string));

		driver.close();

	}

}
