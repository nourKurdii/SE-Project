package soft;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class signOutSteps {
	WebDriver driver;
	String title;
	
	@Given("user logs in")
	public void user_logs_in() 
	{

		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("noor.kurdi073@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("1234password");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
	/*	
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("1234password");
		try {Thread.sleep(30000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();*/
		
		try{Thread.sleep(3000);}catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@When("user hover on acount&lists button and press on sign out button")
	public void user_hover_on_acount_lists_button_and_press_on_sign_out_button() 
	{
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		actions.moveToElement(mainMenu);
		actions.build().perform();
		
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//a[@id='nav-item-signout']")).click();
		title=driver.getTitle();
		
		try {Thread.sleep(4000);} catch (InterruptedException e2) {e2.printStackTrace();}
		driver.quit();
		
	}

	@Then("user will be switched to {string} page")
	public void user_will_be_switched_to_page(String string)
	{
		assertEquals(title,string);
	}
}
