package TroopMessengerApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


	
	public class parallelTest implements Runnable {
		   
	    String port;
	    String udid;
	   
	    public parallelTest(String portNumber, String udid) {
	        this.port = portNumber;
	        this.udid = udid;
	    }
	   
	   
	   
	    AppiumDriver<WebElement> driver;
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	   
	   
	    private void openAppAndPerformSomeActions() {
	        capabilities.setCapability("deviceName", "My Mobile Device");
	        capabilities.setCapability("udid", udid);
	    //    capabilities.setCapability("platformVersion", "6.0.1");
	        capabilities.setCapability("autoGrantPermissions", true);
	        capabilities.setCapability("unicodeKeyboard", true);
	        capabilities.setCapability("resetKeyboard", true);
	        capabilities.setCapability("appPackage", "com.tvisha.troopmessenger");
	        capabilities.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
	       
	        try {
	            driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
	            Thread.sleep(10000);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	       
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	       
	      
	    }
	   
	    public static void main(String args[]) {
	        Runnable r1 = new parallelTest("4725", "emulator-5554"); //device id of first mobile device
	        Runnable r2 = new parallelTest("4723", "emulator-5556"); //device id of second mobile device
	        new Thread(r1).start();
	        new Thread(r2).start();
	    }
	 
	    @Override
	    public void run() {
	        openAppAndPerformSomeActions();
	    }
	}


