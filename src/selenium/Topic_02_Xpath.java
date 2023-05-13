package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClassABC() {
		// Khai báo chromedriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		// Khởi tạo driver để điều khiển browser
		driver = new ChromeDriver();
		// Set timeout để tìm element
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Phóng to cửa sổ
		driver.manage().window().maximize();
		// Mở 1 trang web lên
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_() {
		
		WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Log in']"));
		
		loginBtn.click();
		
		WebElement emailTxb = driver.findElement(By.id("Email"));
		
		WebElement passwordTxb = driver.findElement(By.id("Password"));
		
		emailTxb.click();
		emailTxb.sendKeys("abc@gmail.com");
		
		passwordTxb.click();
		passwordTxb.sendKeys("123123");
		
		WebElement myAccountEle = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My account']"));
		
		AssertJUnit.assertTrue(myAccountEle.isDisplayed());
		
	}


	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}
}