package Maven;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJava {
	@Test(priority = 1)
	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("kippy@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password1");
		driver.findElement(By.id("send2")).click();

		// without thread.sleep the error msg will not be captured
		// only the elment will be loaded, implicit wait can only wait for element to
		// load but to capture whats inside the elements
		Thread.sleep(7000);

		String errMsg = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println("Error" + errMsg);
		AssertJUnit.assertEquals(errMsg, "Invalid login or password");
		driver.quit();

	}

	@Test(priority = 2,enabled=false)
	public void register() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		// driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		// instead of xpath using class name locator
		driver.findElement(By.className("account-icon")).click();
		driver.findElement(By.id("register")).click();

		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("kippy");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("lastname");
		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("kippy@gmail.com");

		// drop boxes
		Select drpCompany = new Select(driver.findElement(By.id("company_type")));
		drpCompany.selectByIndex(4);

		Select indRole = new Select(driver.findElement(By.id("individual_role")));
		indRole.deselectByVisibleText("Technical/developer");

		Select drpCountry = new Select(driver.findElement(By.id("country")));
		drpCountry.deselectByVisibleText("India");

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("password-confirmation")).clear();
		driver.findElement(By.id("password-confirmation")).sendKeys("password123");

		if (!driver.findElement(By.id("agree_terms")).isSelected()) {
			driver.findElement(By.id("agree_terms")).click();
		}

		// driver.findElement(By.xpath("")).click();

	}

}
