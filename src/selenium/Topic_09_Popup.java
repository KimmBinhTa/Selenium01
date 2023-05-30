package selenium;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;

import java.util.List;
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

public class Topic_09_Popup {
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
		
	}

	
	
	//@Test
	public void TC_01_Fixed_Popup_in_DOM() {
//		Step 01 - Truy cập vào trang: https://ngoaingu24h.vn/ 
		driver.get("https://ngoaingu24h.vn/");
//		Step 02 - Kiểm tra popup Đăng nhập không hiển thị
		WebElement loginPopUp = driver.findElement(By.xpath("//div[@class='modal fade in']//div[@class='modal-dialog']"));
		String verifyLoginPopUp = (loginPopUp.isDisplayed()) ? ("Login pop-up is displayed") : ("Login pop-up is undisplayed");
		System.out.println(verifyLoginPopUp);
//		Step 03 - Click vào Đăng nhập button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='btn-v1 btn-login-v1 buttonLoading'][1]"));
		loginBtn.click();
//		Step 04 - Kiểm tra popup Đăng nhập hiển thị
		
		System.out.println(verifyLoginPopUp);
//		Step 05 - Nhập thông tin vào username/ password = automation
		WebElement userName = driver.findElement(By.xpath("//input[@id='account-input']"));
		userName.click();
		userName.sendKeys("Andre12");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password-input']"));
		password.click();
		password.sendKeys("123456");
		
//		Step 06 - Click Đăng nhập button
		
		loginBtn.click();
//		Step 07 - Verify message hiển thị: Tài khoản không tồn tại!
		WebElement mess = driver.findElement(By.xpath("//div[text()='Tài khoản không tồn tại!']"));
		Assert.assertEquals(mess.getText(), "Tài khoản không tồn tại!");


		}
		
	//@Test
	public void TC_02_Fixed_Popup_in_DOM() {
//		Step 01 - Truy cập vào trang: https://kyna.vn/ 
		driver.get("https://kyna.vn/");
//		Step 02 - Click Đăng Nhập button
		WebElement loginBtn = driver.findElement(By.xpath("//a[@class='login-btn']"));
		loginBtn.click();
//		Step 03 - Kiểm tra popup Login hiển thị
		WebElement loginPopUp = driver.findElement(By.xpath("//div[@class='k-popup-account-mb-content']"));
		String verifyLoginPopUp = (loginPopUp.isDisplayed()) ? ("Login pop-up is displayed") : ("Login pop-up is undisplayed");
		System.out.println(verifyLoginPopUp);
//		Step 04 - Nhập thông tin vào form
//		· Email: automation@gmail.com
//		· Mật khẩu: 123456
		WebElement email = driver.findElement(By.xpath("//input[@id='user-login']"));
		email.click();
		email.sendKeys("automation@gmail.com");
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='user-password']"));
		pass.click();
		pass.sendKeys("123456");
		

//		Step 05 - Click Đăng nhập button
		WebElement loginBtnAction = driver.findElement(By.xpath("//input[@id='user-password']"));
		loginBtnAction.click();
//		Step 06 - Verify message hiển thị
		WebElement mess = driver.findElement(By.xpath("//div[@id='password-form-login-message']"));
		Assert.assertEquals(mess.getText(),"Sai tên đăng nhập hoặc mật khẩu");
//		Step 07 - Click vào Close button
		WebElement closeBtn = driver.findElement(By.xpath("//button[@class='k-popup-account-close close']"));
		closeBtn.click();
//		Step 08 - Kiểm tra popup Login không còn hiển thị
		System.out.println(verifyLoginPopUp);

	}
	
	//@Test
	public void TC_03_Fixed_Popup_Not_in_DOM() {
//		Step 01 - Truy cập vào trang: https://tiki.vn/ 
		driver.get("https://tiki.vn/");
//		Step 02 - Click Đăng Nhập/ Đăng Kí
		WebElement loginBtn = driver.findElement(By.xpath("//div[@data-view-id='header_header_account_container']"));
		loginBtn.click();
//		Step 04 - Click 'Đăng nhập bằng email' link
		WebElement emailLoginLink = driver.findElement(By.xpath("//p[@class='login-with-email']"));
		emailLoginLink.click();
//		Step 05 - Không nhập dữ liệu và click Đăng nhập
		WebElement loginBtnAction = driver.findElement(By.xpath("//input[@type='password']/parent::div//following-sibling::button"));
		loginBtnAction.click();
//		Step 06 - Verify text hiển thị
		WebElement emailMess = driver.findElement(By.xpath("//span[text()='Email không được để trống']"));
		assertEquals(emailMess.getText(), "Email không được để trống");
		
		WebElement passMess = driver.findElement(By.xpath("//span[text()='Mật khẩu không được để trống']"));
		assertEquals(passMess.getText(), "Mật khẩu không được để trống");
		
//		Step 07 - Click để close popup đi
		WebElement closeBtn = driver.findElement(By.xpath("//button[@class='btn-close']"));
		closeBtn.click();
//		Step 08 - Verify popup không còn hiển thị (findElements)
		List<WebElement> loginPopUp = driver.findElements(By.xpath("//div[contains(@class, 'Content ReactModal')]"));
		
		if (loginPopUp.size() > 0) {
			System.out.println(" Pop-up is displayed");
		}else {
			System.out.println("Size popup of Login: " +loginPopUp.size() +" & Pop-up is undisplayed");
		}
	
	}
	//@Test
	public void TC_04_Fixed_Popup_Not_in_DOM() {
//		Step 01 - Truy cập vào trang: https://www.facebook.com/ 
		driver.get("https://www.facebook.com/");
//		Step 02 - Click Create New Account button
		WebElement createBtn = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createBtn.click();
//		Step 03 - Verify Register popup hiển thị
		WebElement popUp = driver.findElement(By.xpath("//div[@class='_3ixn']"));
		String verifyPopUp = (popUp.isDisplayed()) ? ("Pop-up is displayed") : ("Pop-up is undisplayed");
		System.out.println(verifyPopUp);
//		Step 04 - Click Close popup đi
		WebElement closeBtn = driver.findElement(By.xpath("//img[@class='_8idr img']"));
		closeBtn.click();
//		Step 05 - Verify Register popup không còn hiển thị
		List<WebElement> popUpList = driver.findElements(By.xpath("//div[@class='_3ixn']"));
		if (popUpList.size() > 0) {
			System.out.println(" Pop-up is displayed");
		}else {
			System.out.println("Size popup of Login: " +popUpList.size() +" & Pop-up is undisplayed");
		}


	}
	//@Test
	public void TC_05_Random_Popup_In_DOM () {
//		Step 01 - Truy cập vào trang:  https://www.javacodegeeks.com/ 
		driver.get("https://www.javacodegeeks.com/");
//		Step 02 - Kiểm tra popup trong 2 trường hợp
//		· Có xuất hiện
		WebElement popUp = driver.findElement(By.xpath("//div[@id='lepopup-popup-125']"));
		String verifyPopUp = (popUp.isDisplayed()) ? ("Pop-up is displayed") : ("Pop-up is undisplayed");
		System.out.println(verifyPopUp);
//		· Nhập email hợp lệ và click Get the Books
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter your e-mail address']"));
		email.click();
		email.sendKeys("Automation@gmail.com");
//		· Không xuất hiện - chuyển qua step 03 (Element của popup vẫn còn trong DOM)
		
//		Step 03 - Nhập dữ liệu vào Search textbox với từ khóa Selenium
		WebElement searchTbx = driver.findElement(By.xpath("//input[@id='search-input']"));
		searchTbx.click();
		searchTbx.sendKeys("Selenium");
		WebElement searchBtn = driver.findElement(By.xpath("//button[@id='search-submit']"));
		searchBtn.click();
//		Step 04 - Kiểm tra article đầu tiên xuất hiện chứa từ khóa Agile Testing Explained
		WebElement firstArticle = driver.findElement(By.xpath("//a[text()='Agile Testing Explained']"));
		assertEquals(firstArticle.getText(), "Agile Testing Explained");
	}
	//@Test
	public void TC_06_Random__Popup_In_DOM() {
//		Step 01 - Truy cập vào trang:  https://vnk.edu.vn/ 
		driver.get("https://vnk.edu.vn/");
//		Step 02 - Kiểm tra popup trong 2 trường hợp
//		· Có xuất hiện - đóng popup đi - chuyển qua step 03
		WebElement popUp = driver.findElement(By.xpath("//div[@id='tve_editor']"));
		String verifyPopUp = (popUp.isDisplayed()) ? ("Pop-up is displayed") : ("Pop-up is undisplayed");
		System.out.println(verifyPopUp);
//		Click Close popup đi
		WebElement closeBtn = driver.findElement(By.xpath("//div[contains (@class, '_listen tve_et_click tve_ea_thrive_leads')]"));
		closeBtn.click();
//		Verify Register popup không còn hiển thị
		List<WebElement> popUpList = driver.findElements(By.xpath("//div[@id='tve_editor']"));
		if (popUpList.size() > 0) {
			System.out.println(" Pop-up is displayed");
		}else {
			System.out.println("Size popup of Login: " +popUpList.size() +" & Pop-up is undisplayed");
		}

//		· Không xuất hiện - chuyển qua step 03 (Element của popup vẫn còn trong DOM)

	}
	
	@Test
	public void TC_07_Random_Popup_Not_In_DOM() {
//		Step 01 - Truy cập vào trang: https://dehieu.vn/ 
		driver.get("https://dehieu.vn/");
//		Step 02 - Kiểm tra popup trong 2 trường hợp
//		· Có xuất hiện - đóng popup đi - chuyển qua step 03
//		· Không xuất hiện - chuyển qua step 03 (Element của popup không còn trong DOM)
		WebElement popUp = driver.findElement(By.xpath("//div[@class='popup-content']"));
		String verifyPopUp = (popUp.isDisplayed()) ? ("Pop-up is displayed") : ("Pop-up is undisplayed");
		System.out.println(verifyPopUp);
//		Click Close popup đi
		WebElement closeBtn = driver.findElement(By.xpath("//button[@id='close-popup']"));
		closeBtn.click();
//		Verify Register popup không còn hiển thị
		List<WebElement> popUpList = driver.findElements(By.xpath("//div[@class='popup-content']"));
		if (popUpList.size() > 0) {
			System.out.println(" Pop-up is displayed");
		}else {
			System.out.println("Size popup of Login: " +popUpList.size() +" & Pop-up is undisplayed");
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