package week2day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLeadAssignments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Enter the login and password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("democsr2");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		//click login button
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//click crm link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		//click create lead
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		WebElement accountText =
		        driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));

		accountText.clear();
		accountText.sendKeys("adi10");
		//Enter the firstname
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("keyav");
		//Enter the lastname
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("localtesting");
		//Enter the department name
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Test Department");
		//Enter the email id
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("test@info.com");
		//Enter the desciption
		 driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test Description");
		 
		
		
		//Dropdown xpath to select the element
		WebElement state = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		//instantiate the select class
		Select sel=new Select(state);
		//select the newyork in dropdown
		sel.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//click edit need to update the record
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		//change the lead description dynamically by using timestamp
		String descriptionedited = "TestAccount_" + System.currentTimeMillis();
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(descriptionedited);
       
       //After edited click to update 
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		//to print the current browser title
		String title=driver.getTitle();
		System.out.println(title);
		//Close the browser
		driver.close();
		 
		

	}

}
