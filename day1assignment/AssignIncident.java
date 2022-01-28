package week5.day1assignment;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends IncidentBaseClass {

		@Test
		public void assignIncident() throws InterruptedException, IOException {
			WebElement findElement = driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"));
								
			findElement.sendKeys("INC0010041");
			findElement.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
			//driver.findElement(By.id("sys_display.incident.caller_id")).click();
			driver.findElement(By.xpath("(//span[@class='icon icon-search'])[5]")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			for (String string : windowHandles) {
				//System.out.println(string);
				
			}
			List<String> child=new ArrayList<String>(windowHandles);
			String string = child.get(1);
			driver.switchTo().window(string);
			WebElement findElement1 = driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"));
			
			findElement1.sendKeys("Software");
			findElement1.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//a[text()='Software']")).click();

			//driver.switchTo().defaultContent();
			driver.switchTo().window(child.get(0));
			driver.switchTo().frame("gsft_main");
			
			driver.findElement(By.id("sysverb_update_bottom")).click();
			Thread.sleep(2000);
			
			String assignmentGroup = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[10]")).getText();
			System.out.println(assignmentGroup);

			if (assignmentGroup.equals("Software") == true) {
				System.out.println("Assignment Group is Software");
			} else {
				System.out.println("Assignment Group is not Software");
			}	

	}

}
