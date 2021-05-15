package soft;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class searchSteps {
	public String alert;
	public WebDriver driver;
	
	@Given("user has logged in")
	public void userHasLoggedIn() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		

		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("noor.kurdi073@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("1234password");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("1234password");
		try {Thread.sleep(30000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		try{Thread.sleep(3000);}catch (InterruptedException e) {e.printStackTrace();}
		
	}
	
	@When("user enters {string} in the search field and chose first laptop and change the quantity to {string} and add it to the cart")
	public void user_enters_in_the_search_field_and_chose_first_laptop_and_change_the_quantity_to_and_add_it_to_the_cart(String string, String string2) 
	{
		String search=string;
		String quantity=string2;
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(search + Keys.ENTER);
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/a[1]")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		Select quantityList =new Select(driver.findElement(By.name("quantity")));
		quantityList.selectByValue(quantity);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		try {Thread.sleep(10000);} catch (InterruptedException e2) {e2.printStackTrace();}
		
		
		alert=driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='attachAccessoryModal_feature_div']/div[@id='attach-dss-placeholder']/div[@id='attach-desktop-sideSheet']/div[@id='attach-accessory-pane']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]")).getText();
		driver.quit();
	}

	@Then("the item will be {string} successfully")
	public void the_item_will_be_successfully(String string) {
		assertEquals(alert,string);

	}

}
