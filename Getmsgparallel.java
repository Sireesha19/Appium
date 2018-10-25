package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Getmsgparallel extends PTroopbase {
	
	
	@Test(dataProvider="returnData_Login")
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(ref.get("UserId"));
		extest=exReport.startTest("My First Test is Login");
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.login(ref.get("UserId"), ref.get("Password"));
		extest.log(LogStatus.PASS, "Login successfully");
		Thread.sleep(5000);
		
		
	}
	
	
	@Test(dataProvider="returnData_SendMsg")
	public void getMsg(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		extest=exReport.startTest("My Test is Search and get message");
		login.searchUser(ref.get("Sender"));
		extest.log(LogStatus.PASS, "Usersearched successfully");
		login.getMsg(ref.get("Message"));
		extest.log(LogStatus.PASS, "Message got successfully");
		
	}
	
	
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","ReceiverData");
	}
	
	@DataProvider
	public Object[][] returnData_SendMsg() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}

}
