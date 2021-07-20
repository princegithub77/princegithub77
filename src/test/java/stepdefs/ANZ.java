package stepdefs;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ANZ {
	 WebDriver driver;
	@Before
	public void before() throws Exception 
	{
	   String driverPath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"Driver"+File.separator+"chromedriver.exe";
       System.setProperty("webdriver.chrome.driver", driverPath);
       driver=new ChromeDriver();
       driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	   driver.manage().window().maximize();
	   WebDriverWait wait=new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnBorrowCalculater")));
	 }
	
	@When("I launch the ANZ Home loans calculators tools")
	public void i_launch_the_ANZ_Home_loans_calculators_tools() {
		driver.findElement(By.id("application_type_single")).click();
		WebElement numberOfDependants=driver.findElement(By.xpath("//select[@title='Number of dependants']"));
		Select select=new Select(numberOfDependants);
		select.selectByVisibleText("0");
		driver.findElement(By.id("borrow_type_home")).click();
		
		driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).sendKeys("80000");

		driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).sendKeys("10000");
		
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("500");
		
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).sendKeys("0");

		driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).sendKeys("100");
		
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).sendKeys("0");
		
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).sendKeys("10000");
		
		driver.findElement(By.id("btnBorrowCalculater")).click();

	}

	@Then("I verify the a borrowing estimate")
	public void i_verify_the_a_borrowing_estimate() {
		assertEquals(driver.getCurrentUrl(), "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
        String borrowResultTextAmount=driver.findElement(By.id("borrowResultTextAmount")).getText();
		assertEquals(borrowResultTextAmount, "$479,000.","borrowResultTextAmount different");

	}
	
	@When("Click on start over button")
	public void click_on_start_over_button() {
		driver.findElement(By.xpath("(//button[@class='start-over'])[1]")).click();
	}

	@Then("Verify the form")
	public void verify_the_form() {
		driver.findElement(By.id("btnBorrowCalculater")).isDisplayed();

	}
	@When("Entering only $1 for Living expenses")
	public void entering_only_$1_for_Living_expenses() {
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).click();
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("1");
		
		driver.findElement(By.id("btnBorrowCalculater")).click();

	}
	
	@Then("Verify the return message")
	public void verify_the_return_message() {
		String borrow__error__text=driver.findElement(By.className("borrow__error__text")).getText();
        assertEquals(driver.findElement(By.className("borrow__error__text")).getText(),borrow__error__text,"borrow error text mismatched");
	}

	@After
	public void closeDriver() {
		driver.close();
	}



}
