package week6assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public RemoteWebDriver driver;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preCondns(String Browser,String Url,String uName,String pWord) {
		 if (Browser.equalsIgnoreCase("chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--user-data-dir=C:\\SeleniumProfile");
	            driver = new ChromeDriver(options);
	        }
	        driver.manage().window().maximize();

        // Launch browser
	        driver.get(Url);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	    driver.findElement(By.id("username")).sendKeys(uName);
	        driver.findElement(By.id("password")).sendKeys(pWord);
	        driver.findElement(By.id("Login")).click();
	        
}
}