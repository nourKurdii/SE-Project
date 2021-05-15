package soft;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps {
 String title;

@When("user enters {string} and {string}")
public void userEntersAnd(String string, String string2) 
{
	String mail=string;
	String pass=string2;
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();

	driver.get("https://www.amazon.com/");
	try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	
	driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
	try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	
	driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(mail);
	driver.findElement(By.xpath("//input[@id='continue']")).click();
	try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	
	driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
	
	driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
	try {Thread.sleep(30000);} catch (InterruptedException e) {e.printStackTrace();}
	
	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	
	try{Thread.sleep(3000);}catch (InterruptedException e) {e.printStackTrace();}
	title=driver.getTitle();
	try{Thread.sleep(2000);}catch (InterruptedException e) {e.printStackTrace();}
	driver.quit();
	
}

@Then("user will be switched to {string} main page")
public void uselWillBeSwitchedToMainPage(String string)
{
 assertTrue(title.contains(string));
}
}