package selenium;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.Alert;

public class Topic_07_Alert {
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
		//driver.get("http://the-internet.herokuapp.com/javascript_alerts");
	}

	//@Test
	public void TC_01_Accept_alert() {
		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		Alert alert;
		jsAlertBtn.click();
		alert = driver.switchTo().alert();
		alert.accept();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
		
		
	}
	
	//@Test
	public void TC_02_Confirm_alert() {
		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		Alert alert;
		jsAlertBtn.click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");
		
		
	}
	//@Test
	public void TC_03_Prompt_alert() {
		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		String inputText = "Hello";
		String expectedResult = "You entered: " + inputText;
		Alert alert;
		jsAlertBtn.click();
		alert = driver.switchTo().alert();
		alert.sendKeys(inputText);
		boolean statusPrompt = defineOKBtn(alert,0);
		if(statusPrompt) {
			expectedResult = "You entered: " + inputText;
		}else {
			expectedResult = "You entered: null";
		}
		
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("result")).getText(),expectedResult);
		System.out.println(expectedResult);
		
	}
	//@Test
	public void TC_04_Authen_Alert_1() {
		//Truyền trực tiếp Username/Password
		String userName = "admin";
		String password = "admin";
		driver.get("https://" + userName +":"+ password +"@" + "the-internet.herokuapp.com/basic_auth");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//p")).getText(),
				"Congratulations! You must have the proper credentials.");
		
	}
	
	//@Test
	public void TC_05_Authen_Alert_2() {
		//Get attribute value rồi by pass qua đoạn authen
		String userName = "admin";
		String password = "admin";
		String basicAuth = driver.findElement(By.xpath("//a[text()='Basic Auth'])")).getAttribute("href");
		driver.get(getAuthenUrl(basicAuth,userName,password));
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//p")).getText(),
				"Congratulations! You must have the proper credentials.");
		
		
		
	}
	public String getAuthenUrl(String url, String userName, String password) {
		String[] link = url.split("//");
		url = link[0] + "//" + userName + ":" + password + "@" + link[1];
		return url;
	}
	
	public static boolean defineOKBtn(Alert alert, int status) {
		if (status==0)
		{
			alert.dismiss();
			return false;
		}
		else {
			alert.accept();
			return true;
		}
	}

	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}
	public void sleepInSecond (int timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}