package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TrpMsngr_TC04_SearchVerify extends Troopbase{
	@Test(dataProvider="returnData_Login",priority='0')
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException{
		
		System.out.println(ref.get("UserId"));
		
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.login(ref.get("UserId"), ref.get("Password"));
	
		Thread.sleep(5000);
				
	}
	@Test(dataProvider="returnData_Login",priority='1')
	public void search(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.searchIconClk(ref.get("Keyword"));
	}
	
	@Test(dataProvider="returnData_Login",priority='2')
	public void searchFieldVerify(HashMap<String, String>ref) throws Exception {
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		
		login.searchVerify(ref.get("Keyword"));
	
		
	}
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}
	

}
