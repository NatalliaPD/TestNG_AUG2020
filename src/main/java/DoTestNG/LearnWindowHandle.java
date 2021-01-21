package DoTestNG;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	
	WebDriver driver;
	@Test
	
	public void init() throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
	driver.get("https://www.yahoo.com/");
	//driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	
	//to show how it works
	System.out.println(driver.getTitle());
	String handle = driver.getWindowHandle();
	System.out.println(handle);
	
	driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
	driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
	
	//to show how it works
	System.out.println(driver.getTitle());
	String handle2 = driver.getWindowHandle();
	System.out.println(handle2);
	
	driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
	
	Thread.sleep(2000);
	//to show how it works, not at work
	
	System.out.println(driver.getTitle());
	Set<String> handles = driver.getWindowHandles();
	System.out.println(handles);
	
	//use for loop again for another set of data to switch to another window
	for (String i : handles) {
		System.out.println(i);
		driver.switchTo().window(i);
		
		//to go back to the original window
		driver.switchTo().window(handle);
	}
		
		
	}

}
