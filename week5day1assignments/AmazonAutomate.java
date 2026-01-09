package week5day1assignments;
import java.io.File;
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

public class AmazonAutomate {

    public static void main(String[] args) throws Exception {

        // 1. Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Load the URL
        driver.get("https://www.amazon.in/");

        // 3. Maximize the browser
        driver.manage().window().maximize();

        // 4. Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 5. Search for "oneplus 9 pro"
        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys("oneplus 9 pro");
        driver.findElement(By.id("nav-search-submit-button"))
              .click();

        // 6. Get the price of the first product
        WebElement firstPrice = driver.findElement(
                By.xpath("(//span[@class='a-price-whole'])[1]")
        );
        String price = firstPrice.getText();
        System.out.println("First Product Price: ₹" + price);
      

     // 7. Get number of customer ratings for first product
        WebElement ratings = driver.findElement(
                By.xpath("(//span[contains(@class,'s-underline-text')])[1]")
        );

        System.out.println("Customer Ratings: " + ratings.getText());
        Thread.sleep(10000);
        // 8. Click first text link of first image
      WebElement firstProduct=   driver.findElement(
                By.xpath("//h2/span[text()='Back Cover for OnePlus 9 Pro(Silicone/Transparent)']/parent::h2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).click().perform();

        // 9. Switch to new window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }

        // 10. Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/oneplus9pro.png");
        FileUtils.copyFile(src, dest);

        // 11. Click Add to Cart
        driver.findElement(By.id("add-to-cart-button")).click();

        // 12. Get Cart Subtotal
        WebElement subtotal = driver.findElement(
                By.xpath("//span[@class='a-price sw-subtotal-amount']"));
        System.out.println("Cart Subtotal: " + subtotal.getText());

        // 13. Close browser
        driver.quit();
    }
}

