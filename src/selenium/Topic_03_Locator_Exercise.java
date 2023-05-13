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

public class Topic_03_Locator_Exercise {
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
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		
	//Step 02 - Click vào button “ĐĂNG KÝ”
		WebElement dangKyBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
		dangKyBtn.click();
	// Step 03: Kiểm tra các error message hiển thị tại form đăng kí

		WebElement NameErrorMessage = driver.findElement(By.xpath("//label[@id='txtFirstname-error']"));
		Assert.assertEquals("Vui lòng nhập họ tên",NameErrorMessage.getText());	
		
		WebElement EmailErrorMessage = driver.findElement(By.xpath("//label[@id='txtEmail-error']"));
		Assert.assertEquals("Vui lòng nhập email",EmailErrorMessage.getText());	
		
		WebElement ConfirmEmailErrorMessage = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
		Assert.assertEquals("Vui lòng nhập lại địa chỉ email",ConfirmEmailErrorMessage.getText());	
		
		WebElement PassErrorMessage = driver.findElement(By.xpath("//label[@id='txtPassword-error']"));
		Assert.assertEquals("Vui lòng nhập mật khẩu",PassErrorMessage.getText());	
		
		WebElement ConfirmPassErrorMessage = driver.findElement(By.xpath("//label[@id='txtPassword-error']"));
		Assert.assertEquals("Vui lòng nhập lại mật khẩu",ConfirmPassErrorMessage.getText());	
		
		WebElement NumberPhoneErrorMessage = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));
		Assert.assertEquals("Vui lòng nhập số điện thoại.",NumberPhoneErrorMessage.getText());	
		
		
}
	
	@Test
	public void TC_02_Register_with_invalid_Email() {
	
	//Step 2:Nhập dữ liệu hợp lệ vào các field ngoại trừ Email và ConfirmEmail 
			
		WebElement name = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		name.click();
		name.sendKeys("Alex Amendola");
	
		WebElement email = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		email.click();
		email.sendKeys("123@@gmail@com");
		
		
		WebElement emailAgain = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		emailAgain.click();
		emailAgain.sendKeys("123@@gmail@com");
		
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.click();
		password.sendKeys("1234");
		
	
		WebElement passwordAgain = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		passwordAgain.click();
		passwordAgain.sendKeys("1234");
		
		
		WebElement numberphone = driver.findElement(By.xpath("//input[@id='txtPhone']"));
		numberphone.click();
		numberphone.sendKeys("0987623712");


	//Step 03 - Click vào button “ĐĂNG KÝ”
		WebElement dangKyBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
		dangKyBtn.click();
		
	//Step 04 - Kiểm tra các error message hiển thị tại Email và Confirm Email
		WebElement EmailErrorMessage = driver.findElement(By.xpath("//label[@id='txtEmail-error']"));
		Assert.assertEquals("Vui lòng nhập email hợp lệ",EmailErrorMessage.getText());	
		
		WebElement confirmEmaiMErrorMessage = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
		Assert.assertEquals("Vui lòng nhập email hợp lệ",confirmEmaiMErrorMessage.getText());	
			
	}
		
	@Test
	public void TC_03_Register_with_incorrect_Confirm_Email() {
	
	//Step 02 - Nhập dữ liệu hợp lệ vào các field ngoại trừ Confirm Email
	    
		WebElement name = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		name.click();
		name.sendKeys("Alex Amendola");
	
		WebElement email = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		email.click();
		email.sendKeys("123@gmail.com");
		
		
		WebElement emailAgain = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		emailAgain.click();
		emailAgain.sendKeys("234@gmail.com");
		
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.click();
		password.sendKeys("1234");
		
	
		WebElement passwordAgain = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		passwordAgain.click();
		passwordAgain.sendKeys("1234");
		
		
		WebElement numberphone = driver.findElement(By.xpath("//input[@id='txtPhone']"));
		numberphone.click();
		numberphone.sendKeys("0987623712");
	
	
	//Step 03 - Click vào button “ĐĂNG KÝ”
		WebElement dangKyBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
		dangKyBtn.click();
		
	//Step 04 - Kiểm tra các error message hiển thị tại Confirm Email
		
		
		WebElement confirmEmaiMErrorMessage = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
		Assert.assertEquals("Email nhập lại không đúng",confirmEmaiMErrorMessage.getText());	
	}
	
//	@Test
//	public void TC_04_Register_with_Password_smaller_6_characters() {
//	
//	 
//	//Step 2:Nhập dữ liệu hợp lệ vào các field ngoại trừ Password và Confirm Password
//
//		     
//		WebElement name = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
//		name.click();
//		name.sendKeys("Alex Amendola");
//	
//		WebElement email = driver.findElement(By.xpath("//input[@id='txtEmail']"));
//		email.click();
//		email.sendKeys("123@gmail.com");
//		
//		
//		WebElement emailAgain = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
//		emailAgain.click();
//		emailAgain.sendKeys("123@gmail.com");
//		
//		
//		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//		password.click();
//		password.sendKeys("1234");
//		
//	
//		WebElement passwordAgain = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
//		passwordAgain.click();
//		passwordAgain.sendKeys("1234");
//		
//		
//		WebElement numberphone = driver.findElement(By.xpath("//input[@id='txtPhone']"));
//		numberphone.click();
//		numberphone.sendKeys("0987623712");
//  
//
//	//Step 03 - Click vào button “ĐĂNG KÝ”
//		WebElement dangKyBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
//		dangKyBtn.click();
//		
//	//Step 04 - Kiểm tra error message hiển thị tại Confirm Password và Password
//		WebElement PassErrorMessage = driver.findElement(By.xpath("//label[@id='txtPassword-error']"));
//		Assert.assertEquals("Mật khẩu phải có ít nhất 6 ký tự",PassErrorMessage.getText());	
//		
//		WebElement confirmPassErrorMessage = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));
//		Assert.assertEquals("Mật khẩu phải có ít nhất 6 ký tự",confirmPassErrorMessage.getText());	
//		}
//	
//	@Test
//	public void TC_05_Register_with_incorrect_Confirm_Password() {
//
//   //Step 02 - Nhập dữ liệu hợp lệ vào các field ngoại trừ Confirm Password
// 
//		WebElement name = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
//		name.click();
//		name.sendKeys("Alex Amendola");
//	
//		WebElement email = driver.findElement(By.xpath("//input[@id='txtEmail']"));
//		email.click();
//		email.sendKeys("123@gmail.com");
//		
//		
//		WebElement emailAgain = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
//		emailAgain.click();
//		emailAgain.sendKeys("123@gmail.com");
//		
//		
//		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//		password.click();
//		password.sendKeys("12345678");
//		
//	
//		WebElement passwordAgain = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
//		passwordAgain.click();
//		passwordAgain.sendKeys("12345679");
//		
//		
//		WebElement numberphone = driver.findElement(By.xpath("//input[@id='txtPhone']"));
//		numberphone.click();
//		numberphone.sendKeys("0987623712");
//	  
//	
//	//Step 03 - Click vào button “ĐĂNG KÝ”
//		WebElement dangKyBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
//		dangKyBtn.click();
//		
//	//Step 04 - Kiểm tra error message hiển thị tại Confirm Password
//		WebElement confirmPassErrorMessage = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));
//		Assert.assertEquals("Mật khẩu bạn nhập không khớp",confirmPassErrorMessage.getText());	
//
//	}
//	
//	@Test
//	public void TC_06_Register_with_invalid_Phone_number() {
//		//Step 02 - Nhập dữ liệu hợp lệ vào các field ngoại trừ Phone number
//	    //Nhập vào Phone ít hơn 10 kí tự hoặc lớn hơn 11 kí tự
//
//		
//		WebElement name = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
//		name.click();
//		name.sendKeys("Alex Amendola");
//	
//		WebElement email = driver.findElement(By.xpath("//input[@id='txtEmail']"));
//		email.click();
//		email.sendKeys("123@gmail.com");
//		
//		
//		WebElement emalConfirm = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
//		emalConfirm.click();
//		emalConfirm.sendKeys("123@gmail.com");
//		
//		
//		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//		password.click();
//		password.sendKeys("12345678");
//		
//	
//		WebElement passwordAgain = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
//		passwordAgain.click();
//		passwordAgain.sendKeys("12345678");
//		
//		
//		WebElement numberphone = driver.findElement(By.xpath("//input[@id='txtPhone']"));
//		numberphone.click();
//		numberphone.sendKeys("098762371234");
//	   //numberErrorMessage.sendKeys("09876237");
//		
//	//Step 03 - Click vào button “ĐĂNG KÝ”
//		WebElement dangKyBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
//		dangKyBtn.click();
//		
//	//Step 04 - Kiểm tra error message hiển thị tại Phone number
//		WebElement numberphoneErrorMessage = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));
//		Assert.assertEquals("Số điện thoại phải từ 10-11 số.",numberphoneErrorMessage.getText());	
//	
//	}


	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}
}