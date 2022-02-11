package omecenBDDWebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import omecenBDDenum.DriverType;
import omecenBDDenum.EnvironmentType;

public class BrowserFactory {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	//private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	//private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	
	public BrowserFactory() {
		driverType=FileReadManager.getInstance().getConfogFileReader().getBrowser();
		environmentType=FileReadManager.getInstance().getConfogFileReader().getEnvironment();
	}
	public WebDriver getDriver() {
		if (driver==null) createDriver();
		return driver;
		
	}
	
	private WebDriver createDriver() {
		switch(environmentType) {
		case LOCAL: driver= createLocalDriver();
		break;
		
		case REMOTE: driver= createRemoteDriver();
		break;
		
		}
		return driver;
		
	}
	
	private WebDriver createRemoteDriver() {
		switch (driverType) {
		case CHROME : 
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setBrowserName(BrowserType.CHROME);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case FIREFOX : 
			DesiredCapabilities cap1= new DesiredCapabilities();
			cap1.setBrowserName(BrowserType.FIREFOX);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap1);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			break;
		case EDGE : 
			DesiredCapabilities cap2= new DesiredCapabilities();
			cap2.setBrowserName(BrowserType.EDGE);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap2);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			break;


		
		}
		if(FileReadManager.getInstance().getConfogFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReadManager.getInstance().getConfogFileReader().getImplicitlyWait()));
		driver.get(FileReadManager.getInstance().getConfogFileReader().getApplicationUrl());
		return driver;
	}
	
	public WebDriver createLocalDriver() {
		switch(driverType){
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			break;
		case EDGE :
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			break;
			
		}
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
		//driver.get("https://inventory.omecen.com/");
		//return driver;
		if(FileReadManager.getInstance().getConfogFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReadManager.getInstance().getConfogFileReader().getImplicitlyWait()));
		driver.get(FileReadManager.getInstance().getConfogFileReader().getApplicationUrl());
		return driver;
		
	}

}
