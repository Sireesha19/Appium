package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TrpMsngr_TC05_Profile extends Troopbase {
	@Test(dataProvider="returnData_Login",priority=0)
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(ref.get("UserId"));
	
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.login(ref.get("UserId"), ref.get("Password"));
	
	}
		
	@Test(dataProvider="returnData_Login",priority=1)
	public void profileInfo(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		
		TrpMsngrProfileScreenEle prof=new TrpMsngrProfileScreenEle(driver);
		prof.profileclk();
	
		prof.profileInfo(ref.get("UserId"));
	
		}
	
	/*@Test(dataProvider="returnData_changepwd",priority=1)
	public void changepwd(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	extest=exReport.startTest("TestCase for change password");
		TrpMsngrProfileScreenEle prof=new TrpMsngrProfileScreenEle(driver);
		prof.profileclk();
		prof.changePwdTabClk();
		prof.changePwd(ref.get("OldPwd"), ref.get("NewPwd"), ref.get("ConfPwd"),ref.get("PwdCheck"));
		extest.log(LogStatus.PASS, "Password changed successfully");
		
	}*/
	@Test(priority=2)
	public void otherOpt() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		TrpMsngrProfileScreenEle prof=new TrpMsngrProfileScreenEle(driver);
	
		prof.profileclk();
		prof.security();
	
		prof.activity();
	
		prof.fileTab();
	;
		//prof.prefernce();
		
	}
	
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}
	@DataProvider
	public Object[][] returnData_changepwd() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","PasswordData");
	}


}
