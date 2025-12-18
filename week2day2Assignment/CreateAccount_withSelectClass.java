package week2day2Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateAccount_withSelectClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
ChromeDriver driver=new ChromeDriver();
        //Load URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		// Login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("democsr2");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		 // Click CRM/SFA
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		// Click Accounts tab
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		
		 // ================= DYNAMIC ACCOUNT NAME =================
		String accountName = "TestAccount_" + System.currentTimeMillis();
        driver.findElement(By.id("accountName")).sendKeys(accountName);
        // Enter description
		
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		
		WebElement sourceDD = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		//instantiate the select class
		Select sel=new Select(sourceDD);
		sel.selectByIndex(3);
		//select computer software as industry
		WebElement industryDD = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
	
		Select sel1=new Select(industryDD);
		//Select "S-Corporation" as ownership using SelectByVisibleText
		sel1.selectByVisibleText("S-Corporation");
		WebElement corporation = driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		
		Select sel2=new Select(corporation);
		//sel1.selectByValue("Employee");
		sel2.selectByValue("LEAD_EMPLOYEE");
		//Select "Employee" as the source using SelectByValue
        WebElement compaign = driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		
		Select sel3=new Select(compaign);
		//sel1.selectByValue("e-commercecompaign");
		sel3.selectByIndex(6);
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex
		WebElement province = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select sel4=new Select(province);
		//sel1.selectByValue("province");
		sel4.selectByValue("TX");
		//create an account
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		//print the account name
		WebElement createdccountName = driver.findElement(
			    By.xpath("(//span[@class='tabletext'])[3]")
			);

			String savedAccountName = createdccountName.getText();
			System.out.println("Saved Account Name: " + savedAccountName);
		
		
	       driver.close();
	       //close the browser

	}

}
