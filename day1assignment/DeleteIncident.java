package week5.day1assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends IncidentBaseClass {

	@Test
	public void deleteIncident() throws InterruptedException, IOException {
		WebElement findElement = driver.findElement(By.xpath("//table[@id='incident_table']/thead/tr[2]//div/div/div/input"));
		findElement.sendKeys("INC0010022");
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='INC0010022']")).click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.close();

}
}
