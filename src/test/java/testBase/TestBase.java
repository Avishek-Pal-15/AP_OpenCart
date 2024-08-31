package testBase;

import java.time.Duration;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() { 
		BasicConfigurator.configure();
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
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
