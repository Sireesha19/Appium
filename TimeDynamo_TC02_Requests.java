package package1;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import package2.TimeDynamoExcelSheet;
import package2.TimeDynamo_LoginElements;

public class TimeDynamo_TC02_Requests extends TimeDynamo_BaseUrl {
	
	@Test(dataProvider="returnto_Login")
	public void login(HashMap<String, String>hash) {
		//extentTest=extentReport.createTest("Login");
		TimeDynamo_LoginElements obj=new TimeDynamo_LoginElements(driver);
		obj.login1(hash.get("UserName"),hash.get("Password"));
		
	}

	@Test(dataProvider="returnto_Request")
	public void requests(HashMap<String, String>hash) throws InterruptedException {
		extentTest=extentReport.createTest("Adding Requests");
		TimeDynamo_LoginElements obj1=new TimeDynamo_LoginElements(driver);
		obj1.addRequest(hash.get("Employee1"),hash.get("Employee2"),hash.get("Message"),hash.get("StartDate"),hash.get("EndDate"));
		
	}
	@DataProvider
	public Object[][] returnto_Login() throws InvalidFormatException, IOException{
		return TimeDynamoExcelSheet.getData("/home/sireesha/Documents/Projects/TimeDynamo/TimeDynamo_Reports/TimeDynamoInputData.xlsx", "Login");
		
	}
	@DataProvider
	public Object[][] returnto_Request() throws InvalidFormatException, IOException{
		return TimeDynamoExcelSheet.getData("/home/sireesha/Documents/Projects/TimeDynamo/TimeDynamo_Reports/TimeDynamoInputData.xlsx", "Requests");
		
	}
}
