package package1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TimeDynamo_BaseUrl{
	WebDriver driver;
	String urlTitle="TimeDynamo";
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;
	//String file="/home/sireesha/Desktop/TimeDynamo/TimeDynamo_Reports/TimeDynamo_Login.html";
	
	String test="testSrcshot";
	ReportingClass sr;

	@BeforeSuite
	public void htmlReportSetup() {
		 
		// htmlReport=new ExtentHtmlReporter(file);
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TimeDynamo_Permissions"
				+ ".html");
		 extentReport=new ExtentReports();
		 extentReport.attachReporter(htmlReport);
		 htmlReport.config().setReportName("TimeDynamoWebApp_RegreessionTesting");
		 htmlReport.config().setDocumentTitle("TimeDynamoWeb");
		 htmlReport.config().setTheme(Theme.STANDARD);
		 htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		// extentTest.setSystemInfo("Environment", "Automation Testing");
			//extentTest.setSystemInfo("User Name", "Sireesha");

			htmlReport.config().setDocumentTitle("Extent report");
			htmlReport.config().setReportName("TimeDynamo");
			
		 extentReport.setSystemInfo("HostName", "tvisha-desktop");
		 extentReport.setSystemInfo("Filename", "TimeDynamo_LocalWebApp");
	
		 }
	
	@BeforeTest
	public void webStart() {
		sr=new ReportingClass();
		sr.startRecording("testvideo");
		extentTest=extentReport.createTest("Application_Launch");
		System.setProperty("webdriver.chrome.driver","/home/sireesha/eclipse-workspace/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://timedynamo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String str=driver.getTitle();
		String title=str.replaceAll(" ", "");
		System.out.println(title);
		Assert.assertEquals(title, urlTitle, "Title Not Equals");
		
		if(urlTitle.contentEquals(title)) {
			extentTest.log(Status.INFO,MarkupHelper.createLabel("Application Title Matched ,Tittle is	:"+title, color.BLUE));
			extentTest.log(Status.PASS,MarkupHelper.createLabel("Application is launched", color.GREEN));
		}
		else {
			extentTest.log(Status.INFO,MarkupHelper.createLabel("Application Title Not Matched ,Tittle is	:"+title, color.BLUE));
			extentTest.log(Status.FAIL,MarkupHelper.createLabel("Application is launched", color.RED));
		}
		
	}
	
	
	@AfterTest
	public void htmlClose() {
		System.out.println("============Scenario completed===========");
		//sr=new ReportingClass();
		sr.stopRecording();	
		driver.close();
	//	System.err.println("recording stopped");
		extentReport.flush();
		System.out.println("Execution Done!!!");
		
		
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException 
	{
				if (result.getStatus() == ITestResult.FAILURE)
				{
					
					System.err.println("recording stopped");
					extentTest.log(Status.INFO,
									"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName
											+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
											+ "</video>");
					extentTest.addScreenCaptureFromPath(getScreenshot(driver,test));
					Thread.sleep(2000);
				// MarkupHelper is used to display the output in different colors
				extentTest.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				
				} 
				else if (result.getStatus() == ITestResult.SKIP)
				{
					extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
					extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
				}
				else if (result.getStatus() == ITestResult.SUCCESS) 
				{
		
						extentTest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
					Thread.sleep(1300);
		
		
					extentTest.log(Status.INFO,
									"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName
											+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
											+ "</video>");

				}
	}
		

	private String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
		+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	}
	
	
	
	


