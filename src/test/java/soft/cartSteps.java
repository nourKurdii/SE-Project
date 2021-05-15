package soft;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cartSteps {
	WebDriver driver;
	String cartQuantity;
	
	@Given("user logs in and one item is already added to the cart")
	public void user_logs_in_and_one_item_is_already_added_to_the_cart() 
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
		
	/*	driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("1234password");
		try {Thread.sleep(30000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		try{Thread.sleep(3000);}catch (InterruptedException e) {e.printStackTrace();}
		*/
	}

	@When("user opens the cart and presses delete button")
	public void user_opens_the_cart_and_presses_delete_button() 
	{
		
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		 try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[2]/div[1]/div[2]/div[4]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]")).click();
		try {Thread.sleep(3000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		cartQuantity=driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
		driver.quit();
	}

	@Then("cart quantity will be {string}")
	public void cart_quantity_will_be(String string)
	{
		assertEquals(cartQuantity,string);
	}
}