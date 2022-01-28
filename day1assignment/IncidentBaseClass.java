package week5.day1assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentBaseClass {
	public static ChromeDriver driver;
	public static String searchnumber;
	public static String incinum=searchnumber;
	@Parameters({"url","userName","password"})
	@BeforeMethod (alwaysRun = true)
	public void beforeMethod(String url,String user,String pwd) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.switchTo().frame("gsft_main");
		//driver.findElement(By.xpath("//button[@class='button-text']")).click();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys("incidents");
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[1]")).click();
		Thread.sleep(2000);
		
		
		
	}
@AfterMethod()

public void afterMethod() {
driver.close();
}

}
