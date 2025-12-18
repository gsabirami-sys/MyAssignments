package week2day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaptureLeadDelete {
	public static void main(String[] args) {
	
	ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // 1. Load URL
    driver.get("http://leaftaps.com/opentaps/control/main");

    // 2. Login
    driver.findElement(By.id("username")).sendKeys("democsr2");
    driver.findElement(By.id("password")).sendKeys("crmsfa");
    driver.findElement(By.className("decorativeSubmit")).click();

    // 3. Click CRM/SFA
    driver.findElement(By.linkText("CRM/SFA")).click();

    // 4. Click Leads
    driver.findElement(By.linkText("Leads")).click();

    // ================= CREATE LEAD =================

    driver.findElement(By.linkText("Create Lead")).click();
    driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompany");
    driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Abi");
    driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Rami");
    driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9999999999");
    driver.findElement(By.className("smallSubmit")).click();

    // ================= FIND LEAD BY PHONE =================

    driver.findElement(By.linkText("Find Leads")).click();
    driver.findElement(By.xpath("//span[text()='Phone']")).click();
    driver.findElement(By.name("phoneNumber")).sendKeys("9999999999");
    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

    // Wait for results
    WebElement firstLead = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
            )
    );

    // Capture Lead ID
    String leadId = firstLead.getText();
    System.out.println("Captured Lead ID: " + leadId);

    // Click first resulting lead
    firstLead.click();

    // ================= DELETE LEAD =================

    driver.findElement(By.linkText("Delete")).click();

    // ================= VERIFY DELETION =================

    driver.findElement(By.linkText("Find Leads")).click();
    driver.findElement(By.name("id")).sendKeys(leadId);
    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

    // Verify message
    WebElement noRecordsMsg = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[text()='No records to display']")
            )
    );

    if (noRecordsMsg.isDisplayed()) {
        System.out.println("Lead successfully deleted");
    }

    //  Final step
    driver.quit();

}
}
