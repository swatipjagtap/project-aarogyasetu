package pom.pack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.pack.Utility;

public class GooglePage {

   private WebDriver driver;
	@FindBy (xpath="//input[contains(@type,'text')]")
	private WebElement search;
	
	@FindBy (xpath="(//input[@type='submit'])[1]")
	private WebElement enter;
	
	
	public GooglePage(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
		this.driver=driver1;
	}
	
	public void searchtextinGoogle() throws EncryptedDocumentException, IOException
	{
	  String data = Utility.getDataFromDatasheet(1, 1);
		search.sendKeys(data);
		
		//search.sendKeys("Aarogya Setu");	
	}
	public void enterSearchTab()
	{
		//Actions act =new Actions(driver);
		//act.moveToElement(enter).click().build().perform();
		WebDriverWait wait =new WebDriverWait(driver, 20);
		wait.until( ExpectedConditions.visibilityOf(enter));
		
		if(enter.isEnabled())
		{
			if(enter.isDisplayed())
			{
				enter.click();
			}
		 }
		
	}
}
