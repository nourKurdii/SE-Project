package soft;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class menuSteps {
	public String subTitle;

	@When("user press on menu and choose {string} submenu")
	public void user_press_on_menu_and_choose_submenu(String string) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement itemsUL= driver.findElement(By.xpath("//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]"));
		List<WebElement> itemsList = itemsUL.findElements(By.tagName("li"));
		for (WebElement li : itemsList) {
		if (li.getText().equals(string)) {
	     li.click();
		}
		
	}
		subTitle=driver.findElement(By.xpath("//div[contains(text(),'computers')]")).getText();
		
		WebElement computersUL= driver.findElement(By.xpath("//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[6]"));
		List<WebElement> computersLI=computersUL.findElements(By.tagName("li"));
		
		subTitle=computersLI.get(3).getText();
		computersLI.get(3).click();
		try {Thread.sleep(4000);} catch (InterruptedException e) {}
		driver.quit();
	}

	@Then("the forth item in Computers list will be {string}")
	public void the_forth_item_in_Computers_list_will_be(String string) 
	{
	assertEquals(subTitle,string);
	}
	}