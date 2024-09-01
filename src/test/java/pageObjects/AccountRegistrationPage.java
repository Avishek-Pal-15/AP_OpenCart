package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage  {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

//	By.xpath("//input[@id='input-firstname']");
//	By.xpath("//input[@id='input-lastname']");
//	By.xpath("//input[@id='input-email']");
//	By.xpath("//input[@id='input-telephone']");
//	By.xpath("//input[@id='input-password']");
//	By.xpath("//input[@id='input-confirm']");
//	By.xpath("//input[@value='0']");
//	By.xpath("//input[@name='agree']");
//	By.xpath("//input[@value='Continue']");
	


	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement fn;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement ln;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement ph;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement confirm;
	
	@FindBy(xpath="//input[@value='0']") 
	WebElement radioNo;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement agreeCheckbox;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement submit;
	
	@FindBy(xpath="//h1/following-sibling::p") 
	WebElement confMsg;
	
	public void setFN(String input) {
		fn.sendKeys(input);
	}
	
	public void setLN(String input) {
		ln.sendKeys(input);
	}
	
	public void setEmail(String input) {
		email.sendKeys(input);
	}
	
	public void setPH(String input) {
		ph.sendKeys(input);
	}
	
	public void setPwd(String input) {
		pwd.sendKeys(input);
	}
	
	public void setConfirm(String input) {
		confirm.sendKeys(input);
	}
	
	public void selectRadio() {
		radioNo.click();
	}
	
	public void agreeCheckbox() {
		agreeCheckbox.click();
	}
	
	public void submit() {
		submit.click();
	}
	
	public String getConfMsg() { 
		return confMsg.getText();
	}
	
	

}
