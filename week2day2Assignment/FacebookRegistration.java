package week2day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();

	        // Load the URL
	        driver.get("https://en-gb.facebook.com/");

	        // Maximize the browser window
	        driver.manage().window().maximize();

	       

	        // Click on Create new account
	        driver.findElement(By.linkText("Create new account")).click();

	        // Enter First name
	        driver.findElement(By.name("firstname")).sendKeys("Abi");

	        // Enter Surname
	        driver.findElement(By.name("lastname")).sendKeys("Rami");

	        // Enter Mobile number or email
	        driver.findElement(By.name("reg_email__")).sendKeys("abi12345@gmail.com");

	        // Enter New password
	        driver.findElement(By.id("password_step_input")).sendKeys("Test@1234");

	        // Handle Date of Birth dropdowns
	        Select day = new Select(driver.findElement(By.id("day")));
	        day.selectByVisibleText("10");

	        Select month = new Select(driver.findElement(By.id("month")));
	        month.selectByVisibleText("May");

	        Select year = new Select(driver.findElement(By.id("year")));
	        year.selectByVisibleText("1995");

	        // Select Gender radio button (Female)
	        driver.findElement(By.xpath("//label[text()='Male']")).click();

	       

	         //Close browser
	       driver.close();
	    }
	

	}


