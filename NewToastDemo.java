package TroopMessengerApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class NewToastDemo extends Troopbase {

	@Test
	public void toast() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElementById("com.tvisha.troopmessenger:id/iconForgotPassword").click();
		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("siri@gmail.com");
		driver.findElementById("com.tvisha.troopmessenger:id/send").click();
	WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		String text = toastView.getAttribute("name");
		System.out.println("==============>"+text);
		}

}
