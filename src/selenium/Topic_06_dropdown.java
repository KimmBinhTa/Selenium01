package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_dropdown {
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
		By itemLocator = By.xpath("//span[@class='ng-option-label ng-star-inserted']");
		String expectedItem = "Thái";
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", parentLocator);
		explicitWait.until(ExpectedConditions.elementToBeClickable(parentLocator));
		parentLocator.click();
		sleepInSecond(2);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemLocator));
		List<WebElement> allItems = driver.findElements(itemLocator);
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
	@Test
	public void  TC_03_Handle_HTML_in_Dropdown() {
//		Step 01 - Truy cập vào trang: https://demo.nopcommerce.com
		driver.get("https://demo.nopcommerce.com");
//		Step 02 - Click Register link trên Header
		WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
		register.click();
//		Step 03 -  Input các thông tin hợp lệ vào form
//		· Chọn các giá trị trong dropdown Date of birth:
//		· Day = 1
//		· Kiểm tra dropdown có 32 items
//		· Month = May
//		· Kiểm tra dropdown có 13 items
//		· Year = 1980
//		· Kiểm tra dropdown có 112 items
		WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
		gender.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstName.click();
		firstName.sendKeys("Alex");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
		lastName.click();
		lastName.sendKeys("Holly");
		//date
		Select dateOfBirth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		dateOfBirth.selectByVisibleText("1");
		sleepInSecond(2);
		List<WebElement> listDateOfBirth = dateOfBirth.getOptions();
		for(WebElement getList:listDateOfBirth)
		{
			Assert.assertEquals(32,dateOfBirth.getOptions().size() );
			System.out.println(dateOfBirth.getOptions().size());
		}
		//month
		Select monthOfBirth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthOfBirth.selectByVisibleText("May");
		sleepInSecond(2);
		List<WebElement> listMonthOfBirth = monthOfBirth.getOptions();
		for(WebElement getList:listMonthOfBirth)
		{
			Assert.assertEquals(13,monthOfBirth.getOptions().size() );
			System.out.println(monthOfBirth.getOptions().size());
		}
		//year
		Select yearOfBirth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yearOfBirth.selectByVisibleText("1980");
		sleepInSecond(2);
		List<WebElement> listYearOfBirth = yearOfBirth.getOptions();
		for(WebElement getList:listYearOfBirth)
		{
			Assert.assertEquals(112,yearOfBirth.getOptions().size() );
			System.out.println(yearOfBirth.getOptions().size());
		}
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.click();
		String randomEmail = "demo"+generateRandomNum()+"@gmail.com";
		email.sendKeys(randomEmail);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.click();
		password.sendKeys("12345678");
		

		WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmPassword.click();
		confirmPassword.sendKeys("12345678");
		
	
		
//		Step 04 - Click REGISTER button
		WebElement registerBtn = driver.findElement(By.xpath("//button[@id='register-button']"));
		registerBtn.click();
//		Step 05 - Verify đã vào trang Home Page sau khi đăng kí thành công
		driver.get("https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
		WebElement continueBtn = driver.findElement(By.xpath("//a[ contains(@class,'button-1')]"));
		continueBtn.click();
		String homepageUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://demo.nopcommerce.com/", homepageUrl);
////		Step 06 - Click vào trang My Account và kiểm tra ngày/ tháng/ năm nhập vào là đúng
//		WebElement myAccount= driver.findElement(By.xpath("//a[@class='ico-account']"));
//		myAccount.click();
//		driver.get("https://demo.nopcommerce.com/customer/info");
			
	}
	
	//@Test
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
	
	public void sleepInSecond(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int generateRandomNum() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}


}