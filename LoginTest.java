package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
        LoginTest obj = new LoginTest();
        
        obj.setup();
        obj.login();
        //obj.teardown();
	}

	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        
        driver.get("https://www.classmarker.com/");		
        Thread.sleep(4000);
	}
	
	public void login() throws InterruptedException {
        
        WebElement RegisterFreelink = driver.findElement(By.linkText("Register Free"));
        RegisterFreelink.click();

        WebElement AllTestTakerslink = driver.findElement(By.partialLinkText("All Test Takers"));
        AllTestTakerslink.click();
        
        WebElement firstname = driver.findElement(By.name("first"));
        firstname.sendKeys("John");

        WebElement lastname = driver.findElement(By.name("last"));
        lastname.sendKeys("Smith");

        WebElement username = driver.findElement(By.name("iusername"));
        username.sendKeys("zyx01");

        WebElement pass = driver.findElement(By.name("ipassword"));
        pass.sendKeys("pass01");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("john.smith@gmail.com");

        WebElement country = driver.findElement(By.name("country"));
        country.sendKeys("Canada");

        WebElement chkBox = driver.findElement(By.name("agreeterms"));
        chkBox.click();

        WebElement register = driver.findElement(By.name("register-button"));
        register.click();

        Alert obj = driver.switchTo().alert();
   
        String actError = obj.getText();
        String expError = "All Mandatory * fields are required";
        obj.accept();
        
        if(actError.equals(expError)) {
        	System.out.println("pass");
        }else {
        	System.out.println("fail");
        }		
	}
	
	public void teardown() {
		driver.quit();
	}
}
