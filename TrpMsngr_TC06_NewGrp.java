package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TrpMsngr_TC06_NewGrp extends Troopbase {

	
		@Test(dataProvider="returnData_Login",priority=0)
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			
			System.out.println(ref.get("UserId"));
		
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
		
		}
		/*
		@Test(priority=1)
		public void newgrp() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			TrpMsngrProfileScreenEle g=new TrpMsngrProfileScreenEle(driver);
			g.newGrp_btnClk();
		}
		
		@Test(dataProvider="returnData_NewGrp",priority=2)
		public void addUsers(HashMap<String , String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			//System.out.println("==============>"+ref.get("UserName"));
			//System.out.println("===============>"+ref.get("Path"));
			extest=exReport.startTest("My second Test is NewGroup module");
			TrpMsngrProfileScreenEle g=new TrpMsngrProfileScreenEle(driver);
			//System.err.println("data===="+ref.get("UserName"));
			g.addUsers_Grp(ref.get("UserName"));
			extest.log(LogStatus.PASS, "Group member added");
		}
		
		@Test(priority=3)
		public void cancel() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			TrpMsngrProfileScreenEle grp=new TrpMsngrProfileScreenEle(driver);
			grp.cancel_user();
		}*/
		@Test(priority=1)
		public void createGrp() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
			TrpMsngrProfileScreenEle grp=new TrpMsngrProfileScreenEle(driver);
			System.out.println("===============>new group creation");
			grp.newGrpCreate();
			
			
		}
		
		@Test(dataProvider="returnData_Login",priority=4)
			public void profpic(HashMap<String , String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			TrpMsngrProfileScreenEle grp=new TrpMsngrProfileScreenEle(driver);
		
			grp.prof_pic(ref.get("Path"));
		
			grp.GrpName(ref.get("GrpName"));

		}
		
		
		@DataProvider
		public Object[][] returnData_Login() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
		}
		
		@DataProvider
		public Object[][] returnData_NewGrp() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","NewGroupData");
		}

}
