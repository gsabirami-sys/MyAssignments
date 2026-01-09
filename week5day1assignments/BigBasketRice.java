package week5day1assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketRice {

    public static void main(String[] args) throws Exception {

        // 1. Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Maximize window
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
     // 4. Load URL
        driver.get("https://www.bigbasket.com/");
        String mainWindow = driver.getWindowHandle();


        // 3. Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
        
         // 5. Click on "Shop by Category"
        WebElement shopByCategory = driver.findElement(
                By.xpath("(//span[text()='Shop by'])[2]"));
        
        shopByCategory.click();
        Thread.sleep(3000);

        // 6. Mouse over "Foodgrains, Oil & Masala"
        WebElement foodGrains = driver.findElement(
                By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(foodGrains).perform();
        //Thread.sleep(4000);

        // 7. Mouse over "Rice & Rice Products"
        WebElement riceProducts = driver.findElement(
                By.xpath("(//a[text()='Rice & Rice Products'])"));
        actions.moveToElement(riceProducts).perform();

        // 8. Click on "Boiled & Steam Rice"
        WebElement boiledRice = driver.findElement(
                By.xpath("//a[text()='Boiled & Steam Rice']"));
        boiledRice.click();
      // Thread.sleep(10000);
        // 6. Filter by brand "bb Royal"
     
      		driver.findElement(By.id("i-bbRoyal")).click();
       // 7. Click "Tamil Ponni Boiled Rice"
      		
      		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"))).click();
      	// 8. Switch to product window
            Set<String> windows = driver.getWindowHandles();
            for (String win : windows) {
                if (!win.equals(mainWindow)) {
                    driver.switchTo().window(win);
                }
            }
            // 9. Select 5 Kg bag
            WebElement fiveKg = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//span[contains(text(),'5 kg')])[1]")));
            fiveKg.click();

            // 10. Get price
            WebElement price = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("(//span[contains(@class,'Label-sc-15v1nk5-0') and contains(@class,'jdJBSX')])[1]")));
            System.out.println("Rice Price: " + price.getText());

            // 11. Click Add button
            WebElement addBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//button[contains(text(),'Add')])[1]")));
            addBtn.click();

            // 12. Verify success message
            WebElement successMsg = 
                   driver.findElement(By.xpath("//p[contains(text(),'added to basket')]"));
            System.out.println("Success Message: " + successMsg.getText());

            // 13. Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/bigbasket.png");
            FileUtils.copyFile(src, dest);

            // 14. Close current window
            driver.close();

            // 15. Switch back to main window & close
            driver.switchTo().window(mainWindow);
            driver.quit();


    
       
        
    }
}
