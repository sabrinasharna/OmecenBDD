package omecenBDDSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import omecenBDDPages.LoginPage;
import omecenBDDWebDriverManager.BrowserFactory;
import omecenBDDWebDriverManager.FileReadManager;
import omecenBDDWebDriverManager.PageObjectManager;
import static org.junit.Assert.*;
public class LoginScenarioOutlineSteps {
	
	WebDriver driver;
	BrowserFactory browserFactory;
	FileReadManager fileReadManager;
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	
	@Given("validator open application")
	public void validator_open_application() {
		browserFactory= new BrowserFactory();
		driver=browserFactory.getDriver();
		LoginPage lp= new LoginPage(driver);
		
		lp.userName("admin");  
	}

	@When("validator enter {string} and enter {string} in the app")
	public void validator_enter_and_enter_in_the_app(String userName, String password) {
		pageObjectManager = new PageObjectManager(driver);
		loginPage=pageObjectManager.getLoginPage();
		loginPage.userName(userName);
		loginPage.getPassword(password);
	} 

	@Then("validator click login button")
	public void validator_click_login_button() {
		pageObjectManager = new PageObjectManager(driver);
		loginPage=pageObjectManager.getLoginPage();
		loginPage.getLogin();
	}

	@Then("validate successfully login message")
	public void validate_successfully_login_message() {
		
		String acutalURL="https://login.salesforce.com/";
    	String expectedURL=driver.getCurrentUrl();
    	System.out.println("Url is  "+expectedURL);
    	assertEquals(acutalURL, expectedURL);
		 driver.quit(); 
	}
}
