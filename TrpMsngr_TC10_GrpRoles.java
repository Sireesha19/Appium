package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TrpMsngr_TC10_GrpRoles extends Troopbase{
	
		@Test(dataProvider="returnData_Login",priority='0')
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException{
			
			System.out.println(ref.get("UserId"));
			
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
		
			Thread.sleep(5000);
					
		}
		@Test(dataProvider="returnData_Login",priority='1')
		public void searchgrp(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException
		{
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.GroupRole(ref.get("GrpName"));
		}
		@Test(priority='2')
		public void profPicClk()
		{
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.profPicClk();
		}
		
		@Test(dataProvider="returnData_Login",priority='3')
			public void editGrpName(HashMap<String, String>ref)
		{
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.editNme(ref.get("EgrpName"));
		}
		
		/*@Test(priority='4')
		public void role()
		{
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.roleAssign();
		}*/

		
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}
}
