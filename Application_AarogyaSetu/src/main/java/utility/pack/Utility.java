package utility.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromDatasheet(int row , int col) throws EncryptedDocumentException, IOException
	{
		String path ="C:\\Users\\ADMIN\\Desktop\\material\\swati\\test sheet.xlsx";
		FileInputStream file = new FileInputStream(path);
		Sheet s = WorkbookFactory.create(file).getSheet("AarogyaSetu"); 
		String data =null;
		
     try
       {
	      data= s.getRow(row).getCell(col).getStringCellValue();
	  }
     catch(java.lang.IllegalStateException a)
     {
    	 double value =  s.getRow(row).getCell(col).getNumericCellValue();
    	   data =String.valueOf(value);
     }
    catch(Exception e)
     {
    	 e.printStackTrace();
     }
		
	return data;		
		
		
	}
	
	public static void saveScreeshot(WebDriver driver, String testID) throws IOException
	{

		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File ("C:\\Users\\ADMIN\\Pictures\\Screenshots\\ "+testID+" "+date+".jpg");
		 FileHandler.copy(src, dest);
		

	}
	
}
