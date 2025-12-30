package week4day2assignments;
import java.time.Duration;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class HandlePromptalert {

	    public static void main(String[] args) {

	       
	        WebDriver driver = new ChromeDriver();

	        // Load the URL
	        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

	        // Maximize the browser window
	        driver.manage().window().maximize();

	        // Add implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Switch to the iframe
	        driver.switchTo().frame("iframeResult");

	        // Click the "Try It" button
	        driver.findElement(By.xpath("//button[text()='Try it']")).click();

	        // Switch to alert
	        Alert alert = driver.switchTo().alert();

	        // --- OPTION 1: Click OK ---
	        alert.sendKeys("Abi");
	        alert.accept();

	        // --- OPTION 2: Click Cancel ---
	        // alert.dismiss();

	        // Verify the displayed text
	        String resultText = driver.findElement(By.id("demo")).getText();
	        System.out.println("Result Text: " + resultText);

	        // Validation
	        if (resultText.contains("Abi")) {
	            System.out.println("Alert action performed successfully");
	        } else {
	            System.out.println("Alert action failed");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}




