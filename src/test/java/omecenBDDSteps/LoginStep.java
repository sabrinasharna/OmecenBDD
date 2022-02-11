package omecenBDDSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import omecenBDDPages.LoginPage;
import omecenBDDWebDriverManager.BrowserFactory;
import omecenBDDWebDriverManager.FileReadManager;
import omecenBDDWebDriverManager.PageObjectManager;

public class LoginStep{
	WebDriver driver;
	BrowserFactory browserFactory;
	FileReadManager fileReadManager;
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	
	@Given("user open application")
	public void user_open_application() {
		browserFactory= new BrowserFactory();
		driver=browserFactory.getDriver();
		//LoginPage lp= new LoginPage(driver);
		
		//lp.userName("admin");
	    
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		pageObjectManager = new PageObjectManager(driver);
		loginPage=pageObjectManager.getLoginPage();
		loginPage.userName("admin");
	   
	}

	@Then("I successfully login")
	public void i_successfully_login() {
	}

}
