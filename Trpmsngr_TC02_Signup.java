package TroopMessengerApp;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;





public class Trpmsngr_TC02_Signup extends Troopbase {
	String val,val1;
	@Test(dataProvider="returnData_SignUp",priority=0)
	public void signUp(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		TrpMsngrSignUpScreenEle  obj=new TrpMsngrSignUpScreenEle(driver);
		
		
		val=obj.signUpForm1(ref.get("Company"), ref.get("YourName"),ref.get("PhoneNumber"),ref.get("Email") , ref.get("Country"));
		System.out.println("Gotta msg is ==========="+val);
	}
	@Test(dataProvider="returnData_SignUp")
	public void signUpForm2(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		TrpMsngrSignUpScreenEle  obj=new TrpMsngrSignUpScreenEle(driver);
		
		val1=obj.signUpForm2(ref.get("Password"), ref.get("Cpassword"));
		System.out.println("Gotta msg is ==========="+val1);
	
		
	}
	@DataProvider
	public Object[][] returnData_SignUp() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Signup");
	}
}
