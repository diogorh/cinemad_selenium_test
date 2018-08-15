package diogo.Cinemad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import diogo.Cinemad.Util.WaitTool;
import diogo.Cinemad.VideoBase.VideoBase;

public class Home extends VideoBase {
	
	private WebDriver driver;

	@FindBy(xpath = "//div[@aria-label='Play']")
	private WebElement playVid;
	
	@FindBy(xpath = "//i[@class='fa fa-play fa-5x']")
	private WebElement firstPlay;
	
	@FindBy(xpath = "//span[@class='jw-text jw-reset jw-text-elapsed']")
	private WebElement timeElapsed;
	
	@FindBy(id = "interactionCaller_3095")
	private WebElement vestidoInteraction;
	
	public Home(WebDriver wDriver) {
		super(wDriver);
		URL = "https://cinemad.tv/es/";
		driver = wDriver;
	}
	
	//Primer play en el centro del player
	public void clickFirstPlay() {
		WaitTool.waitForElement(driver, By.xpath("//i[@class='fa fa-play fa-5x']"), 5);
		firstPlay.click();
	}
	
	//Segundo play que esta al lado del timer
	public void clickPlay() {
		if(isElementPresentAndDisplay(By.xpath("//div[@aria-label='Play']"))) {
			playVid.click();
		}
	}
	
	public String getTimeElapsed() {
		return timeElapsed.getText();
	}
	
	public void clickVestidoInteraction() {
		vestidoInteraction.click();
	}
	
	public boolean isVestidoInteractionPresent() {
		return isElementPresentAndDisplay(By.id("view_adzone_3095"));
	}
	
	
}
