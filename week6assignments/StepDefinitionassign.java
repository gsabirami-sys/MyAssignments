package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.*;

import java.time.Duration;

public class StepDefinitionassign {

    WebDriver driver;
    WebDriverWait wait;
    String accountName = "Testing cucumber";

    @Given("User launches Salesforce login page")
    public void launchSalesforce() {
    	 ChromeOptions options = new ChromeOptions();
         options.addArguments("--user-data-dir=C:\\SeleniumProfile");
        
       
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.get("https://login.salesforce.com");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @When("User enters username and password")
    public void enterCredentials() {
        driver.findElement(By.id("username")).sendKeys("abirami.testing@info.com");
        driver.findElement(By.id("password")).sendKeys("Abi@1993");
    }

    @When("User clicks on Login button")
    public void clickLogin() {
        driver.findElement(By.id("Login")).click();
    }

    @When("User clicks on toggle menu button")
    public void clickToggleMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='slds-icon-waffle']"))).click();
    }

    @When("User clicks View All and selects Sales")
    public void clickViewAllAndSales() {

        // Click View All
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='View All']"))).click();

        // Wait for Sales tile
        WebElement sales = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[text()='Sales']")
                )
        );

        // JS click for Salesforce stability
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", sales);
    }


    @When("User clicks on Accounts tab")
    public void clickAccountsTab() throws InterruptedException {

        Thread.sleep(3000);
           WebElement accounts=     driver.findElement(By.xpath("//one-app-nav-bar-item-root//a[@title='Accounts']"));
            

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accounts);
    }

    @When("User clicks on New button")
    public void clickNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='New']"))).click();
    }

    @When("User enters account name")
    public void enterAccountName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='Name']"))).sendKeys(accountName);
    }

    @When("User selects ownership as Public")
    public void selectOwnership() {
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    By statusDropdown = By.xpath("//button[@aria-label='Ownership']");
	    By activeOption   = By.xpath("//span[@title='Public']");

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].click();",
	        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown))
	    );

	    wait.until(ExpectedConditions.elementToBeClickable(activeOption)).click();
    }

    @Then("User clicks Save and verifies account name")
    public void saveAndVerify() {
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        String actualName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//lightning-formatted-text[@slot='primaryField']"))).getText();

        Assert.assertEquals(actualName, accountName);
        driver.quit();
    }
}
