package selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.Color;
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

public class Topic_08_radio_checkbox {
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
	public void TC_01_Default_checkbox_hide() {
		//div: click
		//input: isSelected()
		
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		By btnLocator = By.xpath("//input[@id='mat-radio-3-input']");
		CheckToCheckboxByJS(btnLocator);
		sleepInSecond(2);
		assertTrue(driver.findElement(btnLocator).isSelected());
		sleepInSecond(1);
		
	}
	//@Test
	public void TC_02_Custom_checkbox() {
		driver.get("https://docs.google.com/forms/d/1qFZ26rQUeGvPhoqfU6YZO0omVi0s_9EojiKx-UANhuI/viewform?edit_requested=true");
		WebElement btnEle = driver.findElement(By.xpath("//div[@id='i14']"));
		btnEle.click();
		String aria_checked = btnEle.getAttribute("aria-checked");
		assertEquals(aria_checked,"true");
		
		sleepInSecond(2);
	
	}
	
	//@Test
	public void TC_01_Button() {
//		Step 01 - Truy cập vào trang: https://www.fahasa.com/customer/account/create
		driver.get("https://www.fahasa.com/customer/account/create");
//		Step 02 - Navigate qua tab Đăng nhập
		WebElement loginTab = driver.findElement(By.xpath("//li[contains(@class, 'tab-login')]"));
		loginTab.click();
		
//		Step 03 - Verify “Đăng nhập” button là disabled
		WebElement loginBtnDisable = driver.findElement(By.xpath("//button[@class='fhs-btn-login']"));
		if(loginBtnDisable.isEnabled())
		{
			System.out.println("Button is enable");
		}else {
			System.out.println("Button is disable");
		}
		
		
//		Step 04 - Verify “Đăng nhập” button có background color là màu xám
		Color loginBtnColor = Color.fromString(driver.findElement(By.xpath("//button[@class='fhs-btn-login']"))
				.getCssValue("background-color"));
		//assert loginBtnColor.asRgba().equals("rgba(224, 224, 224, 1)");
		System.out.println(loginBtnColor);
//		Step 05 - Input dữ liệu hợp lệ vào Email/ Mật khẩu textbox
	
		
//		Step 06 - Verify “Đăng nhập” button là enabled
		
//		Step 07 - Verify “Đăng nhập” button có background color là màu đỏ

	}
	//@Test
	public void TC_02_Default_Checkbox_or_Radio_Button() {
//		Step 01 - Truy cập vào trang: https://demos.telerik.com/kendo-ui/checkbox/index 
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-pc-btn-handler']"));
		cookies.click();
//		Step 02 - Click vào checkbox: Dual-zone air conditioning
//		Step 03 - Kiểm tra checkbox đó đã chọn
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='eq5']"));
		
		if (checkBox.isSelected()) {

			System.out.println("checkbox đã được chọn");
		} else {
			System.out.println("checkbox chưa chọn");
			checkBox.click();
		}
		
//		Step 04 - Sau khi checkbox đã được chọn - bỏ chọn nó và kiểm tra nó chưa được chọn
		System.out.println("checkbox đã được chọn");
		checkBox.click();
		String verifyUncheck = (checkBox.isSelected()) ? "checkbox đã được chọn" : "It's wrong";
		System.out.println(verifyUncheck);
//		Step 05 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/styling/radios
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
//		Step 06 - Click vào radio button:  2.0 Petrol, 147kW
		WebElement radioBtn = driver.findElement(By.xpath("//input[@id='engine3']"));
		radioBtn.click();
		sleepInSecond(2);
//		Step 07 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
		if(radioBtn.isDisplayed()) {
			System.out.println("Radio is selected");
		}else {
			radioBtn.click();
		}
	}
	@Test
	public void TC_03_Custom_Checkbox_or_Radio_Button() {
//		Step 01 - Truy cập vào trang: docs.google.com 
		driver.get("https://docs.google.com/forms/d/1qFZ26rQUeGvPhoqfU6YZO0omVi0s_9EojiKx-UANhuI/edit?usp=forms_home&ths=true");
//		Step 02 - Kiểm tra ‘Thành phố Hà Nội’ radio button là chưa được chọn
//		Step 03 - Click chọn ‘Thành phố Hà Nội’ radio button
		WebElement city = driver.findElement(By.xpath("//span[text()='Thành phố Hà Nội']"));
		String cityAttribute = city.getAttribute("dir");
	    Assert.assertEquals(cityAttribute, "auto");
//		if() {
//			System.out.println("Thành phố Hà Nội radio button đã được chọn");
//		}else {
//			System.out.println("Thành phố Hà Nội radio button chưa được chọn");
//			
//		}
//		city.click();
//		sleepInSecond(2);
////		Step 04 - Kiểm tra ‘Thành phố Hà Nội’ radio button là đã được chọn 
//		String checkSelect = (city.()) ? "Thành phố HN đã được chọn" : "It's wrong";
//		System.out.println(checkSelect);
		
	}
	
	public void uncheckToCheckboxByJS(By locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locator));
		if(driver.findElement(locator).isSelected()) {
			 driver.findElement(locator).click();;
			sleepInSecond(1);
		}
	}
	public void CheckToCheckboxByJS (By locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(locator));
		if(!driver.findElement(locator).isSelected()) {
			jsExecutor.executeScript("arguments[0].click()", driver.findElement(locator));
			sleepInSecond(1);
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