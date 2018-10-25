package TroopPackage1;


	

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Hashtable;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import io.appium.java_client.android.AndroidDriver;

	public class TMExcelsheet {
		AndroidDriver driver;
		String phoneNUmber;
		String oTp;
		public Workbook wb;
		public Sheet sheet;
		public int row;
		public int cell;
		
			@DataProvider(name="text")
			public Object[][] getexcelsheetvalues() throws IOException ,InterruptedException, EncryptedDocumentException, InvalidFormatException
			{
				FileInputStream file=new FileInputStream("/home/sireesha/TMSignup.xlsx");
				wb=WorkbookFactory.create(file); //any kind of excel (no need to use XSSF,HSSF)
				sheet=wb.getSheet("Sheet1");
				row=sheet.getLastRowNum();
				cell=sheet.getRow(0).getLastCellNum();
				System.out.println("rows are--->"+row);
				System.out.println("cells are----->"+cell);
				Object[][] obj=new Object[row][1]; 

					
				for(int i=1;i<=row;i++) {
					HashMap<String, String> hash=new HashMap<>();
				
				for(int j=0;j<cell;j++) {
					
				  
					DataFormatter data=new DataFormatter();
				    String key=data.formatCellValue(sheet.getRow(0).getCell(j));
				    String value=data.formatCellValue(sheet.getRow(i).getCell(j));
				   
				    hash.put(key, value);
			
				 
				}    
				
				obj[i-1][0]=hash;
				}
				return obj;

	}
			
			
		
	}



