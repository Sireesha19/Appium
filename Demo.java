package TroopMessengerApp;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Demo {

	public static void main(String[] args) {

		String result=null;
		File f = new File("/home/sireesha/Pictures/tip25.png");
		ITesseract instance = new Tesseract();
		System.out.println("entered===>");
		instance.setDatapath("/home/sireesha/Desktop/Tess4J/tessdata");
		instance.setLanguage("eng");
		try {	
			result = instance.doOCR(f);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println(result);
	}

}