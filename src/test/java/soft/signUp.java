package soft;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class signUp {
	public String title;
	WebDriver driver;
	boolean t;
	@Given("user in the websites home page")
	public void user_in_the_websites_home_page() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
	
	}

	@When("user open sign-in page and click on create amazon account button and enter name {string} and mail {string} and password {string} country {string} phone {string} then click create buton")
	public void user_open_sign_in_page_and_click_on_create_amazon_account_button_and_enter_name_and_mail_and_password_country_phone_then_click_create_buton(String string, String string2, String string3, String string4, String string5) {
		  driver.findElement(By.id("nav-link-accountList")).click();
			try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
			
			driver.findElement(By.id("createAccountSubmit")).click();
			try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
			
			driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys(string);
			driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(string2);
			driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(string3);
			driver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys(string3);
			
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			try {Thread.sleep(30000);} catch (InterruptedException e2) {e2.printStackTrace();}
			
			driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/span[1]/span[1]/input[1]")).click();
			try {Thread.sleep(3000);} catch (InterruptedException e2) {e2.printStackTrace();}
			
			driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys(string5);
			Select s=new Select(driver.findElement(By.xpath("//select[@id='cvf_phone_cc_native']")));
			s.selectByValue(string4);
			
			try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
			driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/span[1]/span[1]/input[1]")).click();
			
			
			try {Thread.sleep(30000);} catch (InterruptedException e2) {e2.printStackTrace();}
			driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]/span[1]/input[1]")).click();
			
			try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
			title=driver.getTitle();
			driver.quit();
			}


	@Then("account will be created and user will be switched to {string} page")
	public void account_will_be_created_and_user_will_be_switched_to_page(String string) {
		t=title.contains(string);
		assertTrue(t);
	}
}
