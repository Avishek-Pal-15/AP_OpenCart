package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@BeforeClass(groups={"Sanity", "Regression", "Master", "DataDriven"})
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws IOException { 
		BasicConfigurator.configure();
		logger = LogManager.getLogger(this.getClass());
		
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties(); 
		prop.load(file);
		
		switch(browser.toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver();
			break;
		case "firefox": 
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default: 
			System.out.println("Invalid browser provided: " + browser);
			return; 
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Sanity", "Regression", "Master", "DataDriven"})
	public void tearDown() { 
		driver.quit();
	}
	
	public static void waitUntilPageLoad(WebDriver driver, int timeout) {
		System.out.println("waiting for page load!");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\""));
	}
	
	public static String generateRandomString(int minLength, int maxLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int length = random.nextInt((maxLength - minLength) + 1) + minLength;
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
