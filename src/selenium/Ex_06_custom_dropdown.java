package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ex_06_custom_dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	

	
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
		//driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		explicitWait = new WebDriverWait(driver, 5);

		jsExecutor = (JavascriptExecutor) driver;
	}

	//@Test
	public void TC_01_Custom_dropdown() {
		
		WebElement parentLocator = driver.findElement(By.xpath("//div[text()='Dân tộc']/parent::div"));
		String expectedItem = "Thái";
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", parentLocator);
		explicitWait.until(ExpectedConditions.elementToBeClickable(parentLocator));
		parentLocator.click();
		sleepInSecond(2);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//span[@class='ng-option-label ng-star-inserted']")));
		List<WebElement> allItems = driver.findElements(By.xpath("//span[@class='ng-option-label ng-star-inserted']"));
		for (WebElement item : allItems) {
			System.out.println("Actual text:" + item.getText());
			
			if(item.getText().equals(expectedItem))
			{
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", item);
				sleepInSecond(2);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				sleepInSecond(2);
				break;
				
			}
		}
	}
	
	//@Test
		public void TC_02_Custom_edit_dropdown() {
			
			WebElement parentLocator = driver.findElement(
					By.xpath("//div[text()='Dân tộc']//following-sibling::div[@class='ng-input']//input"));
			String expectedItem = "Thái";
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", parentLocator);
			explicitWait.until(ExpectedConditions.elementToBeClickable(parentLocator));
			parentLocator.click();
			parentLocator.sendKeys("Tày");
			sleepInSecond(2);
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.xpath("//span[@class='ng-option-label ng-star-inserted']")));
			List<WebElement> allItems = driver.findElements(By.xpath("//span[@class='ng-option-label ng-star-inserted']"));
			for (WebElement item : allItems) {
				System.out.println("Actual text:" + item.getText());
				
				if(item.getText().equals(expectedItem))
				{
					jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", item);
					sleepInSecond(2);
					explicitWait.until(ExpectedConditions.elementToBeClickable(item));
					item.click();
					sleepInSecond(2);
					break;
					
				}
			}
		}
	//@Test
	public void  TC_03_Handle_HTML_in_Dropdown() {
//		Step 01 - Truy cập vào trang: https://demo.nopcommerce.com
		driver.get("https://demo.nopcommerce.com");
//		Step 02 - Click Register link trên Header
		
//		Step 03 -  Input các thông tin hợp lệ vào form
//		· Chọn các giá trị trong dropdown Date of birth:
//		· Day = 1
//		· Kiểm tra dropdown có 32 items
//		· Month = May
//		· Kiểm tra dropdown có 13 items
//		· Year = 1980
//		· Kiểm tra dropdown có 112 items
//		Step 04 - Click REGISTER button
//		Step 05 - Verify đã vào trang Home Page sau khi đăng kí thành công
//		Step 06 - Click vào trang My Account và kiểm tra ngày/ tháng/ năm nhập vào là đúng

	}
	
	@Test
	public void TC_04_Handle_custom_dropdown( ) {
//		Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/selectmenu/default.html
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		
//		Step 02 - Chọn item cuối cùng: số 19
		WebElement parentLocator = driver.findElement(By.id("number-button"));

		String expectedItem = "19";
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", parentLocator);
		explicitWait.until(ExpectedConditions.elementToBeClickable(parentLocator));
		parentLocator.click();
		sleepInSecond(2);
//		Step 03 - Kiểm tra item đã được chọn thành công
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-menu-item-wrapper']")));
		List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		for (WebElement item : allItems) {
		
			
			if(item.getText().equals(expectedItem))
			{
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", item);
				sleepInSecond(2);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				sleepInSecond(2);
				System.out.println("Actual text:" + item.getText());
				break;
				
			}
			
			
		}
}
	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}

	public void sleepInSecond(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}