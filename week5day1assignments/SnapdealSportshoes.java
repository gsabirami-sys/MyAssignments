package week5day1assignments;



import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealSportshoes {

    public static void main(String[] args) throws Exception {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Load the URL
        driver.get("https://www.snapdeal.com/");

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        // 2. Go to Men's Fashion
        WebElement mensFashion = driver.findElement(By.xpath("(//div[contains(@class,'sc-98d0cbe0-3')])[1]"));
        action.moveToElement(mensFashion).perform();

        // 3. Click Sports Shoes
        driver.findElement(By.xpath("//div[text()='Sports Shoes']")).click();

        // 4. Get count of sports shoes
        String count = driver.findElement(By.xpath("//span[@class='category-name category-count']"))
                             .getText();
        System.out.println("Sports Shoes Count: " + count);

        // 5. Click Training Shoes
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

        // 6. Sort products by Low to High
        driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
        driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();

        Thread.sleep(3000); // allow sorting to complete

        // 7. Verify sorting
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        List<Integer> originalPrices = new ArrayList<>();
        List<Integer> sortedPrices = new ArrayList<>();

        for (WebElement price : prices) {
            String text = price.getText().replaceAll("[^0-9]", "");
            if (!text.isEmpty()) {
                int value = Integer.parseInt(text);
                originalPrices.add(value);
                sortedPrices.add(value);
            }
        }

        Collections.sort(sortedPrices);

        if (originalPrices.equals(sortedPrices)) {
            System.out.println("Products are sorted correctly (Low to High)");
        } else {
            System.out.println("Sorting is incorrect");
        }

        // 8. Select price range 500-700
        driver.findElement(By.name("fromVal")).clear();
        driver.findElement(By.name("fromVal")).sendKeys("500");
        driver.findElement(By.name("toVal")).clear();
        driver.findElement(By.name("toVal")).sendKeys("700");
        driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();

       

        // 10. Verify applied filters
       List<WebElement> filters = driver.findElements(By.xpath("(//div[@class='filters']//a)[1]"));
       System.out.println("Applied Filters:");
       for (WebElement filter : filters) {
            System.out.println(filter.getText());
       }

        // 11. Mouse hover on first training shoe
        WebElement firstShoe = driver.findElement(By.xpath("(//div[normalize-space()='Quick View'])[1]"));
        action.moveToElement(firstShoe).perform();

        // 12. Click Quick View
        driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();

        // 13. Print cost and discount
        String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
        String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();

        System.out.println("Cost: Rs." + cost);
        System.out.println("Discount: " + discount);

        // 14. Take snapshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/trainingShoes.png");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot taken");

        // 15. Close current window (Quick View)
        driver.findElement(By.xpath("//div[contains(@class,'close')]")).click();

        // 16. Close main window
        driver.quit();
    }
}
