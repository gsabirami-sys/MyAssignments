package week2.day1Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeadAssignment {
	public static void main(String[] args)
	{
	ChromeDriver driver=new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("democsr2");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.className("inputBox")).sendKeys("infosys");
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Testing");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("test");
	driver.findElement(By.name("generalProfTitle")).sendKeys("test");
	driver.findElement(By.name("submitButton")).click();
	String title=driver.getTitle();
	System.out.println(title);
	driver.quit();

}
}