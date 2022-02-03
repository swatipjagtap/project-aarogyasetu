package pom.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AarogyaSetuSite {

	private WebDriver driver;

	@FindBy (xpath="//h3[text()='Aarogya Setu']")
	private WebElement aarogy;
	
	
	public AarogyaSetuSite(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}
	
	public void clickaarogyasite()
	{
		if(aarogy.isEnabled())
		{
			if(aarogy.isDisplayed())
			{
				aarogy.click();	
			}
		 }
		
	}
}
