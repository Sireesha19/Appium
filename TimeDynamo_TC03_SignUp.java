package package1;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import package2.RequiredMethods;
import package2.TimeDynamoExcelSheet;
import package2.TimeDynamo_LoginElements;

public class TimeDynamo_TC03_SignUp extends TimeDynamo_BaseUrl{
	@Test(dataProvider="returnto_Signup",priority=0)
	public void signUp(HashMap<String, String>hash) {
		extentTest=extentReport.createTest("SignUp_InfoDetails");
		RequiredMethods obj=new RequiredMethods(driver);
		TimeDynamo_LoginElements obj2=new TimeDynamo_LoginElements(driver);
		obj2.LoginTab.click();
		obj.signup(hash.get("CompanyName"),hash.get("AdminName"),hash.get("PhoneNumber"),hash.get("Email"));
		
	}
	@Test(dataProvider="returnto_Pwd",priority=1)
	public void pwd(HashMap<String, String>hash) throws InterruptedException {
		extentTest=extentReport.createTest("PasswordFieldsValidation");
		RequiredMethods obj=new RequiredMethods(driver);
	obj.password(hash.get("Password"),hash.get("ConfirmPassword"),hash.get("Check"));
		
	}
	@DataProvider
	public Object[][] returnto_Signup() throws InvalidFormatException, IOException{
		return TimeDynamoExcelSheet.getData("/home/sireesha/Documents/Projects/TimeDynamo/TimeDynamo_Reports/TimeDynamoInputData.xlsx", "SignUpData");
		
	}
	@DataProvider
	public Object[][] returnto_Pwd() throws InvalidFormatException, IOException{
		return TimeDynamoExcelSheet.getData("/home/sireesha/Documents/Projects/TimeDynamo/TimeDynamo_Reports/TimeDynamoInputData.xlsx", "PasswordData");
		
	}
}
