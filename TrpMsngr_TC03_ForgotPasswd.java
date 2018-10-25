package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TrpMsngr_TC03_ForgotPasswd extends Troopbase2 {
	
	@Test(priority=0)
	public void forgotBtnClk() throws InterruptedException {
		TrpMsngrSignUpScreenEle forgot=new TrpMsngrSignUpScreenEle(driver);
		forgot.forgotBtn();
	}
	
	@Test(dataProvider="returnData_Login",priority=1)
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		
		
		System.out.println(ref.get("UserId"));
		TrpMsngrSignUpScreenEle forgot=new TrpMsngrSignUpScreenEle(driver);
		String val=forgot.forgotPasswd(ref.get("UserId"),ref.get("Check"));
		System.out.println("---->"+val);
		
		
		
		
	}
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Sheet3");
	}

}
