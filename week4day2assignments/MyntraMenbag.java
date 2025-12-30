package week4day2assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraMenbag {

    public static void main(String[] args) throws InterruptedException {

        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Load Myntra
        driver.get("https://www.myntra.com/");

        // Search for "bags" and press ENTER
        driver.findElement(By.xpath("//input[@class='desktop-searchBar']"))
              .sendKeys("bags", Keys.ENTER);

        Thread.sleep(3000);

        // Click Gender -> Men
        driver.findElement(By.xpath("//label[text()='Men']")).click();
        Thread.sleep(2000);

        // Click Category -> Laptop Bag
        driver.findElement(By.xpath("//label[text()='Laptop Bag']")).click();
        Thread.sleep(3000);

        // Print count of items found
        String count = driver.findElement(By.xpath("//span[@class='title-count']"))
                             .getText();
        System.out.println("Total items found: " + count);

        // Get list of brand names (COMMON XPATH)
        List<WebElement> brandList = driver.findElements(
                By.xpath("//h3[@class='product-brand']")
        );

        System.out.println("\nBrands List:");
        for (WebElement brand : brandList) {
            System.out.println(brand.getText());
        }

        // Get list of bag names (COMMON XPATH)
        List<WebElement> bagNameList = driver.findElements(
                By.xpath("//h4[@class='product-product']")
        );

        System.out.println("\nBag Names List:");
        for (WebElement bag : bagNameList) {
            System.out.println(bag.getText());
        }

        // driver.quit(); // optional
    }
}
