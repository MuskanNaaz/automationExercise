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
import pages.RegistrationPage;

public class TC_Login_001 extends BaseClass {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public RegistrationPage registrationPage;

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
		
		Assert.assertTrue(loggedInMessage.equalsIgnoreCase(string));

		driver.close();

	}
	@Then("Error {string} is displayed")
	public void error_is_displayed(String string) {
	    String errorMessage = loginPage.incorrect_creds();
	   
	    Assert.assertTrue(errorMessage.equalsIgnoreCase(string));
	    driver.close();
	}
	
	@When("Enter user  {string} and email {string}")
	public void enter_user_and_email(String name, String new_email) throws InterruptedException {
	    loginPage.provide_New_Email_Password(name, new_email);
	    System.out.println("The Name :" + name + "The email is :" +new_email);
	}

	@When("clicks the signUp button")
	public void clicks_the_sign_up_button() throws InterruptedException {
	    registrationPage = loginPage.clickSignUp();
	}

	@Then("The user should enter in SignUp page {string} is displayed")
	public void the_user_should_enter_in_sign_up_page_is_displayed(String string) {
	    String account_details = registrationPage.account_Information();
	    System.out.println("The Logged in VALUE is "+account_details);
		System.out.println("The string Logged value is " + string);
	    Assert.assertTrue(account_details.equalsIgnoreCase(string));
	    driver.close();
	}


}
