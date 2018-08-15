package diogo.Cinemad.VideoBase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class VideoBase {

	protected String URL;
	
	protected WebDriver driver;
	
	//Constructor
	public VideoBase(WebDriver wdriver) {
		driver = wdriver;
	}
	
	//Opens default URL
	public void open() {
		driver.get(URL);
	}
	
	
	// Checks if the element is in the DOM and displayed. 
	public boolean isElementPresentAndDisplay(By by) {
		try {			
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
