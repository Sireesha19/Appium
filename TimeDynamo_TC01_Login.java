package package1;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import package2.TimeDynamoExcelSheet;
import package2.TimeDynamo_LoginElements;

public class TimeDynamo_TC01_Login extends TimeDynamo_BaseUrl {
	@Test(dataProvider="returnto_Login")
	public void login(HashMap<String, String>hash) {
		extentTest=extentReport.createTest("Login");
		TimeDynamo_LoginElements obj=new TimeDynamo_LoginElements(driver);
		obj.login(hash.get("UserName"),hash.get("Password"));
		
	}
	@DataProvider
	public Object[][] returnto_Login() throws InvalidFormatException, IOException{
		return TimeDynamoExcelSheet.getData("/home/sireesha/Documents/Projects/TimeDynamo/TimeDynamo_Reports/TimeDynamoInputData.xlsx", "Login");
		
	}

}
