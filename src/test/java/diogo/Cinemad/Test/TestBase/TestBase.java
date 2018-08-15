package diogo.Cinemad.Test.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpForTests() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		setDriver(new ChromeDriver());
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	private static void setDriver(WebDriver wDriver) {
		driver = wDriver;
	}
	
	@AfterClass
	private static void tearUp() {
		driver.quit();
	}
	
}
