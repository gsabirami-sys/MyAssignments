package week6assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicParametrization extends BaseClass {

    

    @Test(dataProvider = "legalEntityData")
    public void createLegalEntity(String legalEntityName) throws InterruptedException {
    	
    	
          
	        // Click toggle menu
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	WebElement navigation = wait.until(
    	        ExpectedConditions.elementToBeClickable(
    	                By.xpath("//div[@role='navigation']")
    	        )
    	);

    	navigation.click();

	        // Click View All
	        driver.findElement(By.xpath("//button[text()='View All']")).click();
	        Thread.sleep(3000);

	        // Search Legal Entities
	        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']"))
	                .sendKeys("Legal Entities", Keys.ENTER);

	
	        driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();

	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//a[@title='New']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(legalEntityName);
	        driver.findElement(By.xpath("//button[text()='Save']")).click();
	        Thread.sleep(3000);

        // Verify Legal Entity Name
        String actualName = driver.findElement(By.xpath("(//lightning-formatted-text)[1]")).getText();
        Assert.assertEquals(actualName, legalEntityName);

        System.out.println("Legal Entity created successfully: " + actualName);
        driver.close();
    }


    // DataProvider Method
    @DataProvider(name = "legalEntityData")
    public String[][] fetchData() {
        return new String[][] {
                {"Salesforce Automation by Abi"},
                {"Salesforce Automation by Rami"}
        };
    }

  
  
}