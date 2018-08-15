package diogo.Cinemad.Test.Home;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import diogo.Cinemad.Home;
import diogo.Cinemad.Test.TestBase.TestBase;

public class testJwPlayer extends TestBase {

	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void test_home_dress_interaction() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		
		//Espero que el page loader de la pagina haya terminado
		WebDriverWait driverWait = new WebDriverWait(driver, 3);
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='page-loader'][contains(@style, 'display: none')]")));
		
		home.clickFirstPlay();
		
		//por algun motivo el driver.wait(3000); tira un error. 
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			
		}
		
		//Apunto el driver para el iFrame en que esta el video, para poder controlarlo.
		driver.switchTo().frame(0);
				
		//Hago el control-bar visible para poder leer el tiempo o hacer click en el pause
		js.executeScript("document.getElementsByClassName('jw-controlbar jw-background-color jw-reset')[0].style.opacity = '100';"
						+ "document.getElementsByClassName('jw-controlbar jw-background-color jw-reset')[0].style.visibility = 'visible'");

		
		/**
		 * Aca fue una solución rapida para poder esperar hasta que aparezca la interacción del vestido.
		 * Lo ideal seria poder leer el timer y actuar cuando el timer llegue a determinado tiempo.
		 */
		try {
			Thread.sleep(11000);
		} catch(InterruptedException e) {
			
		}
				
		System.out.println("TIME ELAPSED: " + home.getTimeElapsed());
		
		home.clickVestidoInteraction();
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			
		}
		
		assertTrue(home.isVestidoInteractionPresent());
	}
	
	
	@AfterMethod
	public void tearTest() {
		driver.quit();
	}
}
