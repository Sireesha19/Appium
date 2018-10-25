package TroopMessengerApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;




public class PTroopbase {
	 AndroidDriver<AndroidElement> driver;
	 ExtentTest extest;
		ExtentReports exReport;
		
		@Parameters({"deviceName","UDID"})
	@BeforeTest
	public  void testDemo(String device,String did) throws MalformedURLException {
		
		String extentReport="/home/sireesha/eclipse-workspace/Troopmanage/test-output/troop.html";
		String extentImage="/home/sireesha/mypic.jpg";
		exReport=new ExtentReports(extentReport, true);
		extest=exReport.startTest("My First Test");
		
		File f = new File("src");
		File f1 = new File(f, "app_release.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.UDID, did);

		
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("appPackage", "com.tvisha.troopmessenger");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		extest.log(LogStatus.PASS, "TroopMessenger App is Launched");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@AfterTest
	public void demo() {
		System.out.println("============Scenario completed===========");
		//driver.close();
	}

}
