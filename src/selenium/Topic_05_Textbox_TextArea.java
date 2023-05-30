package selenium;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Textbox_TextArea {
	static WebDriver driver;
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
		driver.get("http://demo.guru99.com/v4");
	}
		
	

	@Test
	public void TC_01_Handle_textbox_textarea() {

		//Step 02 - Đăng nhập
		   //Verify HomePage được hiển thị thành công
		   //Manual test để lấy thông tin User/ Pass nếu hết hạn - User chỉ tồn tại trong 20 ngày 
		WebElement inputUserID = driver.findElement(By.xpath("//input[@name='uid']"));
		inputUserID.click();
		inputUserID.sendKeys("mngr503635");
		
		WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
		inputPassword.click();
		inputPassword.sendKeys("Uqepygy");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		loginBtn.click();
		
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://demo.guru99.com/v4/manager/Managerhomepage.php",homePageUrl);
		sleepInSecond(4);
		//Step 03 - Click Chọn link New Customer
		WebElement newCustomerLink = driver.findElement(By.xpath("//a[text()='New Customer']"));
	
		newCustomerLink.click();
		
		//Step 04 - Nhập toàn bộ dữ liệu đúng > Click Submit
		/*Customer name */
		WebElement customerName = driver.findElement(By.xpath("//input[@name='name']"));
		customerName.click();
		customerName.sendKeys("Demo3");
	
		/*Radio checkbox*/
		WebElement maleRadio = driver.findElement(By.xpath("//input[@value='m']"));

		maleRadio.click();
		/*Date of birth*/
		WebElement birthdate = driver.findElement(By.xpath("//input[@type='date']"));

		birthdate.sendKeys("01-3-2000");
		
//	    WebElement femaleRadio = driver.findElement(By.xpath("//input[@value='f']"));
//      femaleRadio.click();
		
		/*Address*/
		WebElement address = driver.findElement(By.xpath("//textarea[@name='addr']"));

		address.click();
		address.sendKeys("38 Nam Ky Khoi Nghia\n District 3 ");
		
		/*City*/
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));

		city.click();
		city.sendKeys("Ho Chi Minh");
		
		/*State*/
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));

		state.click();
		state.sendKeys("Viet Nam");
		
		/*PIN*/
		WebElement pin= driver.findElement(By.xpath("//input[@name='pinno']"));

		pin.click();
		pin.sendKeys("111111");
		
		
		/*Number phone*/
		WebElement mobileNum = driver.findElement(By.xpath("//input[@name='telephoneno']"));

		mobileNum.click();
		mobileNum.sendKeys("0986775468");
		
		/*Email*/
		WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));

		email.click();
		String randomEmail = "demo" + generateRandomNumber() + "@gmail.com";
		email.sendKeys(randomEmail);
		/*Password*/
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

		password.click();
		String randomPassword = "Demo@se" + generateRandomNumber();
		password.sendKeys(randomPassword);
		/*Submit button*/
		WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));

		submitBtn.click();
		
		//Step 05 - Sau khi hệ thống tạo mới Customer thành công > Get ra thông tin của Customer ID
		WebElement infoCustomerID = driver.findElement(By.xpath("//td[text()='Customer ID']//following-sibling::td"));

		Assert.assertEquals(infoCustomerID, infoCustomerID.getText());
		//Step 06 - Verify tất cả thông tin được tạo mới thành công
//		WebElement infocustomerName = driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td"));
//
//		Assert.assertEquals(customerName, infocustomerName.getText());
//		WebElement infoGender = driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td"));
//
//		Assert.assertEquals(maleRadio, infoGender.getText());
//		WebElement infoBirthday = driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td"));
//		Assert.assertEquals(birthdate, infoBirthday.getText());
//		WebElement infoAddress = driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td"));
//		WebElement infoCity = driver.findElement(By.xpath("//td[text()='City']//following-sibling::td"));
//		WebElement infoPIN = driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td"));
//		WebElement infoState = driver.findElement(By.xpath("//td[text()='State']//following-sibling::td"));
//		WebElement infoMobile = driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td"));
//		WebElement infoEmail = driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td"));
	}
	
	//@Test
	public void TC_02_() {
		
	}


	@AfterClass
	public void afterClass() {
		// Đóng browser
		driver.quit();
	}
	
//	random number
	public static int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
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