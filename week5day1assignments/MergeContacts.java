package week5day1assignments;
	import java.time.Duration;
	import java.util.Set;
    import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class MergeContacts {

	    public static void main(String[] args) throws InterruptedException {

	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Load the URL
	        driver.get("http://leaftaps.com/opentaps/control/login");

	        // Maximize the browser window
	        driver.manage().window().maximize();

	        // Add implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        // Enter username
	        driver.findElement(By.id("username")).sendKeys("democsr2");

	        // Enter password
	        driver.findElement(By.id("password")).sendKeys("crmsfa");

	        // Click Login button
	        driver.findElement(By.className("decorativeSubmit")).click();

	        // Click on CRM/SFA
	        driver.findElement(By.linkText("CRM/SFA")).click();

	        // Click on Contacts
	        driver.findElement(By.linkText("Contacts")).click();

	        // Click on Merge Contacts
	        driver.findElement(By.linkText("Merge Contacts")).click();

	        // Click widget of "From Contact"
	        driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();

	        // Handle window switch - From Contact
	        Set<String> windows = driver.getWindowHandles();
	        for (String window : windows) {
	            driver.switchTo().window(window);
	        }

	        // Click first resulting contact
	        driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

	        // Switch back to main window
	        driver.switchTo().window(windows.iterator().next());

	        // Click widget of "To Contact"
	        driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();

	        // Handle window switch - To Contact
	        Set<String> windows2 = driver.getWindowHandles();
	        for (String window : windows2) {
	            driver.switchTo().window(window);
	        }
	        // Click second resulting contact
	        driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();

	        // Switch back to main window
	        driver.switchTo().window(windows2.iterator().next());

	        // Click Merge button
	        driver.findElement(By.linkText("Merge")).click();

	        // Accept the alert
	        Alert alert = driver.switchTo().alert();
	        alert.accept();

	        // Verify the title
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "View Contact";

	        if (actualTitle.contains(expectedTitle)) {
	            System.out.println("Title verified successfully: " + actualTitle);
	        } else {
	            System.out.println("Title verification failed. Actual title: " + actualTitle);
	        }

	        // Close browser
	        driver.quit();
	    }
	}

