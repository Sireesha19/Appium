package TroopMessengerApp;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Loginmsg extends Troopbase{
	@Test
	public  void testLoginmsg()throws MalformedURLException, InterruptedException {
		Thread.sleep(2000);
		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("sireesha.k@tvisha.in");
		String pwd="siri@297";
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys(pwd);
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		
		Thread.sleep(55000);
		TouchAction ta=new TouchAction(driver);
		driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();
		
		driver.findElementById("com.tvisha.troopmessenger:id/search").sendKeys("Rakesh");
		
		Thread.sleep(1500);
		driver.findElementById("com.tvisha.troopmessenger:id/userName").click();
		
		String msg="Tested ";
		driver.findElementById("com.tvisha.troopmessenger:id/newMesg").sendKeys(msg);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm aa");
		String formattedDate = dateFormat.format(new Date()).toString();
		System.out.println(formattedDate);
		
		
		driver.findElementById("com.tvisha.troopmessenger:id/sendMessage").click();
		driver.navigate().back();
		driver.findElementByXPath("//android.widget.TextView[@text='Rakesh Adupa ']").click();
		
		List<AndroidElement> msglist=driver.findElementsById("com.tvisha.troopmessenger:id/txtMsg");
		List<AndroidElement> timelist=driver.findElementsById("com.tvisha.troopmessenger:id/timeStamp");
		System.out.println(msglist.size()+"time"+timelist.size());
		
		int a1=msglist.size()-1;
		//System.out.println(a1);
		int b1=timelist.size()-1;
		
		String mtxt=msglist.get(a1).getText();
		System.out.println(mtxt);
		String ttxt=timelist.get(b1).getText();
		System.out.println(ttxt);
	
		Assert.assertEquals(msg, mtxt, "equals");
		System.out.println("sent msg equals");
		Assert.assertEquals(formattedDate, ttxt, "equals");
		System.out.println("Time equals");
				

	}

}
