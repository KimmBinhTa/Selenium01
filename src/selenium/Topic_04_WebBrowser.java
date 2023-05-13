package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_WebBrowser {
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
		driver.get("http://live.techpanda.org/");
	}
	
	@Test
	public void TC_01_Verify_Url_get_Current_Url() {
		//Step 02 - Click MY ACCOUNT link tại footer
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		
		
		myAccount.click();

		String loginPageUrl = driver.getCurrentUrl();//Actual
		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/login/", loginPageUrl);
		WebElement createBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		createBtn.click();
		String registerUrl = driver.getCurrentUrl();
	}

	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}
}
