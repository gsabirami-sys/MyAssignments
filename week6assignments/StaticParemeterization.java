package week6assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StaticParemeterization {
	public RemoteWebDriver driver;

	@Test
	@Parameters({"Browser", "url", "username", "password", "companyName", "description"})
	public void createLegalEntity(String Browser,
	                              String url,
	                              String username,
	                              String password,
	                              String companyName,
	                              String description) throws InterruptedException {

	    if (Browser.equalsIgnoreCase("chrome")) {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--user-data-dir=C:\\SeleniumProfile");
	        driver = new ChromeDriver(options);
	    }

	    driver.manage().window().maximize();

	    // Login
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(3000);

	    // App Launcher → Legal Entities
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    Thread.sleep(3000);
	    // Search Legal Entities
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']"))
                .sendKeys("Legal Entities", Keys.ENTER);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@title='New']")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(companyName);
        Thread.sleep(3000);
	    

	    // Enter Description only
	    driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);
	 //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    By statusDropdown = By.xpath("//label[normalize-space()='Status']/following::button[1]");
	    By activeOption   = By.xpath("//span[normalize-space()='Active']");

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].click();",
	        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown))
	    );

	    wait.until(ExpectedConditions.elementToBeClickable(activeOption)).click();



	    // Save
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    Thread.sleep(3000);

	    // Verify error message
	    String errorMsg = driver.findElement(
	        By.xpath("//div[contains(text(),'Complete this ')]"))
	        .getText();
	    System.out.println(errorMsg);

	    if (errorMsg.contains("Complete this field.")) {
    	    System.out.println("Validation message is displayed correctly");
    	} else {
    	    System.out.println("Validation message is NOT correct");
    	}
	   // driver.close();
	}

    }

