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
	/*===============================================BROWSER=====================================*/
	//@Test
	public void TC_01_Verify_Url_get_Current_Url() {
		//Step 02 - Click MY ACCOUNT link tại footer
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Verify url của Login Page
		String loginPageUrl = driver.getCurrentUrl();//Actual
		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/login/", loginPageUrl);
		//Step 04 - Click CREATE AN ACCOUNT button
		WebElement createBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		createBtn.click();
		//Step 05 - Verify url của Register Page 
		String registerUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/create/", registerUrl);
	}
	
	//@Test
	public void TC_02_Verify_Title() {
	
		//Step 02 - Click MY ACCOUNT link tại footer
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Verify title của Login Page = Customer Login
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle = "Customer Login",loginPageTitle );
		//Step 04 - Click CREATE AN ACCOUNT button
		WebElement createBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		createBtn.click();
		//Step 05 - Verify title của Register Page = Create New Customer Account 
		String registerTitle = driver.getTitle();
		Assert.assertEquals(registerTitle = "Create New Customer Account",registerTitle );
		
	}
	//@Test
	public void TC_03_Navigate_function_back_forward() {
		
		//Step 02 - Click MY ACCOUNT link tại footer
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Click CREATE AN ACCOUNT button
		WebElement createBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		createBtn.click();
		//Step 04 - Verify url của Register Page = http://live.techpanda.org/index.php/customer/account/create/ 
		String registerUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/create/", registerUrl);
		//Step 05 - Back lại trang Login Page
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		//Step 06 - Verify url của Login Page = http://live.techpanda.org/index.php/customer/account/login/
		String loginPageUrl = driver.getCurrentUrl();//Actual
		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/login/", loginPageUrl);
		//Step 07 - Forward tới trang Register Page
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		//Step 08 - Verify title của Register Page = Create New Customer Account
		String registerTitle = driver.getTitle();
		Assert.assertEquals(registerTitle = "Create New Customer Account",registerTitle );

			
		}
	//@Test
	public void TC_04_Get_Page_Source_Code() {
	
		//Step 02 - Click MY ACCOUNT link tại footer
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Verify Login Page chứa text: Login or Create an Account
		driver.getPageSource().contains("Login or Create an Account");
		//Step 04 - Click CREATE AN ACCOUNT button
		WebElement createBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		createBtn.click();
		//Step 05 - Verify Register Page chứa text: Create an Account
		driver.getPageSource().contains(" Create an Account");
	}
	/*===============================================ELEMENT=====================================*/
	//@Test
	public void TC_01_Login_with_empty_Email_and_Password() {
		
		//Step 02 - Click vào link "My Account" để tới trang đăng nhập
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Để trống Username/ Password
		//Step 04 - Click Login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginBtn.click();
		//Step 05 - Verify error message xuất hiện tại 2 field:  This is a required field.
		WebElement emailErrMessage = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']"));
		emailErrMessage.click();
		Assert.assertEquals("This is a required field.",emailErrMessage.getText());
		
		WebElement passErrMessage = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']"));
		passErrMessage.click();
		Assert.assertEquals("This is a required field.",passErrMessage.getText());
		
		
	}

	//@Test 
	public void TC_02_Login_with_invalid_Email() {
		
		//Step 02 - Click vào link "My Account" để tới trang đăng nhập
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Nhập email invalid: 123434234@12312.123123/ password valid: 123456
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.click();
		email.sendKeys("123434234@12312.123123");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.click();
		password.sendKeys("123456");
		//Step 04 - Click Login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginBtn.click();
		//Step 05 - Verify error message xuất hiện: Please enter a valid email address. For example johndoe@domain.com.
		WebElement emailErrMessage = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']"));
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", emailErrMessage.getText());

	}
	
	//@Test 
	public void TC_03_Login_with_Password_smaller_6_characters() {
		//Step 02 - Click vào link "My Account" để tới trang đăng nhập
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Nhập email correct and password invalid: automation@gmail.com/ 123
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.click();
		email.sendKeys("automation@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.click();
		password.sendKeys("123");
		//Step 04 - Click Login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginBtn.click();
		//Step 05 - Verify error message xuất hiện: Please enter 6 or more 
		WebElement passErrMessage = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']"));
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", passErrMessage.getText());

	}
	
	//@Test 
	public void TC_04_Login_with_incorrect_Email_or_Password() {
		//Step 02 - Click vào link "My Account" để tới trang đăng nhập
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Nhập email correct and password incorrect: automation@gmail.com/ 123123123
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.click();
		email.sendKeys("automation@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.click();
		password.sendKeys("123123123");
		//Step 04 - Click Login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginBtn.click();
		//Step 05 - Verify error message xuất hiện: Invalid login or password.
		WebElement loginErrMessage = driver.findElement(By.xpath("//div[@class='account-login']//span[text()='Invalid login or password.']"));
		Assert.assertEquals("Invalid login or password.", loginErrMessage.getText());
		
	}
	
	//random email
//	public static String generateRandomEmail(int length) {
//	    log.info("Generating a Random email String");
//	    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
//	    String email = "";
//	    String temp = RandomStringUtils.random(length, allowedChars);
//	    email = temp.substring(0, temp.length() - 9) + "@testdata.com";
//	    return email;
//	}
	//@Test 
	public void TC_05_Create_a_new_account() {
		//Step 02 - Click vào link "My Account" để tới trang đăng nhập
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
		WebElement createBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		createBtn.click();
		//Step 04 - Nhập thông tin hợp lệ vào tất cả các field: First Name/ Last Name/ Email Address/ Password/ Confirm Password
		//(Lưu ý: Tạo random cho dữ liệu tại field Email Address)
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.click();
		firstName.sendKeys("Alex");
		
		WebElement middleName = driver.findElement(By.xpath("//input[@id='middlename']"));
		middleName.click();
		middleName.sendKeys("Roller");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		lastName.click();
		lastName.sendKeys("Amendola");
		
		
		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email_address']"));
		emailAddress.click();
		//emailAddress.generateRandomEmail()+"@gmail.com";
		emailAddress.sendKeys("alex123@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.click();
		password.sendKeys("12345678");
		
		WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirmation']"));
		confirmPassword.click();
		confirmPassword.sendKeys("12345678");
		
		
		//Step 05 - Click REGISTER button
		WebElement registerBtn = driver.findElement(By.xpath("//button[@title='Register']"));
		registerBtn.click();
		//Step 06 - Verify message xuất hiện khi đăng kí thành công: Thank you for registering with Main Website Store
	
		WebElement registerSuccessMess = driver.findElement(By.xpath("//div[@class='dashboard']//span[text()='Thank you for registering with Main Website Store.']"));
	
		//Step 07 - Verify User được tạo mới với thông tin: Firstname/ Lastname/ Email hiển thị ở trang My Dashboard
//		WebElement infoUser = driver.findElement();
//		Assert.assertEquals(" ",infoUser.getText());
//		WebElement emailUser = driver.findElement();
//		Assert.assertEquals(" ",emailUser.getText());
//		
//		String myDashboard = driver.getCurrentUrl();
//		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/index/",myDashboard);
		
		//Step 08 - Logout khỏi hệ thống
		WebElement account = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']"));
		account.click();
		WebElement logout = driver.findElement(By.xpath("//a[@title='Log Out']"));
		logout.click();
		
		//Step 09 - Kiểm tra hệ thống navigate về Home page sau khi logout thành công
		String homePage = driver.getCurrentUrl();
		Assert.assertEquals("http://live.techpanda.org/index.php/",homePage);
		
	
	}
	@Test 
	public void TC_06_Login_with_valid_Email_and_Password() {
		//Step 02 - Click vào link "My Account" để tới trang đăng nhập
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		myAccount.click();
		//Step 03 - Login với thông tin đã đăng kí ở testcase số 5 trên
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.click();
		email.sendKeys("alex123@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.click();
		password.sendKeys("12345678");
		//Step 04 - Click Login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginBtn.click();
		//Step 05 - Verify các thông tin sau được hiển thị
		

	
	}
		
	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}
}
