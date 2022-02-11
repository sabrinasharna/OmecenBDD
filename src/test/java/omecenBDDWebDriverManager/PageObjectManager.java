package omecenBDDWebDriverManager;

import org.openqa.selenium.WebDriver;

import omecenBDDPages.LoginPage;
import omecenBDDPages.RegistrationPage;

public class PageObjectManager {
  private WebDriver driver;
  private LoginPage loginPage;
  private RegistrationPage registrationPage;
  
public PageObjectManager(WebDriver driver) {
	super();
	this.driver = driver;
}

public LoginPage getLoginPage() {
	return (loginPage==null)? loginPage=new LoginPage(driver):loginPage;
	
}
public RegistrationPage getRegistrationPage() {
	return (registrationPage==null)? registrationPage= new RegistrationPage(driver): registrationPage ;
	
}

}



