package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrpMsngr_TC011_MessageOptions {
	public class TrpMsngr_TC01_Login extends Troopbase {
		@Test(dataProvider="returnData_Login",priority=0)
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException {
			
			System.out.println(ref.get("UserId"));
			
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
		
			Thread.sleep(5000);
					
		}
		
		@Test(dataProvider="returnData_Login",priority=1)
		public void messageopt(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.searchUser(ref.get("MsgOpter"));
			GroupRoleEle grp=new GroupRoleEle(driver);
			grp.reply();
			
		}
		
		@DataProvider
		public Object[][] returnData_Login() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
		}
}
}
