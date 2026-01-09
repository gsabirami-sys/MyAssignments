package week5day1assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTableassignment {

    public static void main(String[] args) {

        // 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://finance.yahoo.com/");
        driver.manage().window().maximize();

        // 2. Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Actions class
        Actions actions = new Actions(driver);

        // 4. Mouse hover on "More"
        WebElement more =
                driver.findElement(By.xpath("//span[text()='More']"));
        actions.moveToElement(more).perform();

        // 5. Click on "Crypto" submenu
     // JavaScript click for Crypto (bypass ads)
        WebElement crypto =
                driver.findElement(By.xpath("(//a[contains(@href,'crypto')])[6]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", crypto);

        // 6. Locate crypto table
        WebElement table =
                driver.findElement(By.xpath("//table"));

        // 7. Locate all rows
        List<WebElement> rows =
                table.findElements(By.xpath(".//tbody/tr"));

        System.out.println("Cryptocurrency Names:");

        // 8. Iterate rows and fetch crypto name column
        for (WebElement row : rows) {

            // Crypto name is in 2nd column
            WebElement cryptoName =
                    row.findElement(By.xpath("./td[2]"));

            System.out.println(cryptoName.getText());
        }

        // 9. Close browser
        driver.quit();
    }
}
