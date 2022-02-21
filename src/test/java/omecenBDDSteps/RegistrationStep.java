package omecenBDDSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import omecenBDDPages.RegistrationPage;
import omecenBDDWebDriverManager.BrowserFactory;
import omecenBDDWebDriverManager.FileReadManager;
import omecenBDDWebDriverManager.PageObjectManager;

public class RegistrationStep {
	WebDriver driver;
	BrowserFactory browserFactory;
	FileReadManager fileReadManager;
	PageObjectManager pageObjectManager;
	RegistrationPage registrationPage;
	
	@Given("tester open application")
	public void tester_open_application() {
	   System.out.println("hello"); 
	   browserFactory = new BrowserFactory();
	   driver = browserFactory.getDriver();
	   
	}

	@When("tester fillup registration page")
	public void tester_fillup_registration_page() {
		pageObjectManager = new PageObjectManager(driver);
		registrationPage=pageObjectManager.getRegistrationPage();
		registrationPage.getSignUpLink();
		registrationPage.firstname("Sabrina");
		registrationPage.lastName("Sharna");
		registrationPage.jobTitle("Teacher");
		registrationPage.emailAddress("sharna.teacher@gmail.com");
		registrationPage.phoneNumber("703-656-8079");
		registrationPage.getCompEmpl();
		registrationPage.getEmpOpt();
		registrationPage.compName("ABC Company");
		registrationPage.compCountryName();
		registrationPage.compCountry();
		registrationPage.subAgreement();
		//registrationPage.freeTrial();
		
	    
	}

	@Then("tester validate success messeage")
	public void tester_validate_success_messeage() {
		System.out.println("implement this method");
	    

}
}