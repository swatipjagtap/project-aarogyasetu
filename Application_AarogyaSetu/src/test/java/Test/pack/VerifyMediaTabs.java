package Test.pack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.pack.Base;
import pom.pack.AarogyaSetuSite;
import pom.pack.GooglePage;
import pom.pack.HomePage;
import utility.pack.Utility;



public class VerifyMediaTabs extends Base {

	private WebDriver driver;
	private  GooglePage googlepage;
	private AarogyaSetuSite aarogyasetite;
	private  HomePage homepage;
	private String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("launchBrowser");
		if(browser.equals("chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equals("firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void initializePomClasses()
	{
		System.out.println("initialize pom classess");
        
		 googlepage =new GooglePage(driver);
		 aarogyasetite =new AarogyaSetuSite(driver);
		 homepage =new HomePage(driver);
	}
	
	@BeforeMethod
	public void aarogyaSetuSite() throws EncryptedDocumentException, IOException
	{
		
		System.out.println("aarogyaSetuSite");
		String data = Utility.getDataFromDatasheet(1, 0);
		driver.get(data);
		
		//driver.get("https://www.google.com");
		
		googlepage.searchtextinGoogle();
	    googlepage.enterSearchTab();
	   
        aarogyasetite.clickaarogyasite();
	    
	 }
	
	@Test(priority = 1)
	public void toVerifyAarogyaSetuSite()
	{
		testID = "Aarogyasetu-101";
		System.out.println("toVerifyAarogyaSetuSite");
		 
	    String url =driver.getCurrentUrl();
	    
	    boolean result = url.equals("https://www.aarogyasetu.gov.in/");
	    System.out.println(result);
	    Assert.assertEquals(url, "https://www.aarogyasetu.gov.in/");
		
	}
	
	@Test(priority = 2)
	public void toVerifyMedia()
	{
		testID = "Aarogyasetu-102";
		System.out.println("toVerifyMedia");
	    
		homepage.clickMediaTab();
	    homepage.clickVedioTab();
	    
		String url = driver.getCurrentUrl();
		System.out.println(url);       // i didnt mention u in aarogyasetu to fail test case and teake screenshot
		boolean result1 = url.equals("https://www.aarogyasetu.gov.in/");
		Assert.assertTrue(result1);
		
	}
	
	@AfterMethod()
	public void endVerifyTest(ITestResult result ) throws IOException
	{
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		Utility.saveScreeshot(driver, testID);
		}
		
		System.out.println("endVerifyTest");
	}
	@AfterClass
	public void closeObject()
	{
		System.out.println("close objects");
		
		googlepage = null;
		 aarogyasetite =null;
		 homepage =null;
		
	}
	
	@AfterTest
	public void closedBrowser()
	{
	   System.out.println("close browser");	
	   driver.quit();
	   driver = null;
	   System.gc();
	}
}
