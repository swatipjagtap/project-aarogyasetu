package pom.pack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver driver;
    
	@FindBy (xpath="//a[text()='Media Gallery']")
	private WebElement media;
	
	@FindBy (xpath="//div[@class='media_tab']//a[2]")
	private WebElement vedio;
	
	
		public HomePage(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}
		
	public void clickMediaTab()
	{
		if(media.isEnabled())
		{
			if(media.isDisplayed())
			{
				media.click();
			}
		 }
			
	}
	
	public void clickVedioTab()
	{
		if(vedio.isEnabled())
		{
			if(vedio.isDisplayed())
			{
				vedio.click();
			}
		 }
			
	}
	
	
}
