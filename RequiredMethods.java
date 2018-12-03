package package2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import package1.TimeDynamo_BaseUrl;


public class RequiredMethods {
	WebDriver driver;
	String eMail;
	String passwd;
	@FindBy(xpath="//div[@class='tooltip fade top in']")
	public WebElement toggleMsg;
	
	@FindBy(id="feedbackSection")
	public WebElement feedback;
	
	
	public RequiredMethods(WebDriver driver) {
		this.driver=driver;
		
	}

	public void signup(String company,String name,String number,String email) {
		TimeDynamo_BaseUrl.extentTest.log(Status.INFO,MarkupHelper.createLabel("Given Data	:\n"+"CompanyName	:"+company+" , YourName  :"+name+" , PhoneNumber 	:"+number+" Email	:"+email, TimeDynamo_BaseUrl.color.BLUE));
		driver.findElement(By.linkText("Create your account")).click();
		driver.findElement(By.id("companyName")).sendKeys(company);
		driver.findElement(By.id("userName")).sendKeys(name);
		driver.findElement(By.id("userMobile")).sendKeys(number);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.className("submit-btn")).click();
		eMail=email;
		try {
		String str=driver.findElement(By.xpath("//div[@class='tooltip fade top in']")).getText();
		System.out.println("========>"+str);
		TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("Error Message :"+str, TimeDynamo_BaseUrl.color.RED));
		TimeDynamo_BaseUrl.extentTest.log(Status.PASS, MarkupHelper.createLabel("InCorrect Details submitted ", TimeDynamo_BaseUrl.color.RED));
		System.out.println("Info is Unsuccessfull");
		}catch (Exception e) {
			boolean b=driver.findElement(By.id("legalPolicyAgree")).isDisplayed();
			System.out.println("@@@@@@@@@------>"+b);
			TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("Verify with 	- TermsCheckBox display	: "+b, TimeDynamo_BaseUrl.color.BLUE));
			String val=display(b);
			if(val.contentEquals("true")) {
				TimeDynamo_BaseUrl.extentTest.log(Status.PASS, MarkupHelper.createLabel("Details submitted successfully ", TimeDynamo_BaseUrl.color.GREEN));
				System.out.println("Info is successfull");

			}
		}
		//driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")).click();
		}
		
				public String display(boolean b)
				{
					String val="false";
					if(b) {
						val="true";
					}
					return val;
				}

	public void password(String pwd,String pwd1,String check) throws InterruptedException 
	{
		TimeDynamo_BaseUrl.extentTest.log(Status.INFO,MarkupHelper.createLabel("Given Data	:\n"+" Password 	:"+pwd+" , ConfirmPassword"+pwd1+" ,Check-In 	:"+check, TimeDynamo_BaseUrl.color.BLUE));
		passwd=pwd;
		Thread.sleep(500);
		driver.findElement(By.id("signupPassword")).sendKeys(pwd);
		driver.findElement(By.id("signupConfirmPassword")).sendKeys(pwd1);
		System.out.println("=====>"+check);
		if(check.equalsIgnoreCase("chk")) {
		//Thread.sleep(1000);
		driver.findElement(By.id("legalPolicyAgreeCheckbox")).click();
		
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/input")).click();
		//driver.findElement(By.className("submit-btn")).click();
		try
		{
			
		try {
			String msg=driver.findElement(By.xpath("//div[@class='tooltip fade top in']")).getText();
			System.out.println("ToogleMsg====>"+msg);
			TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("Toogle Error Message :"+msg, TimeDynamo_BaseUrl.color.RED));
			
		
		}catch (Exception e) {
			Thread.sleep(300);
			String fb=driver.findElement(By.id("feedbackSection")).getText();
			System.out.println("Got message :"+fb);
			TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("Feedback Message :"+fb, TimeDynamo_BaseUrl.color.GREEN));
		
		}
	}
		catch(Exception e1) {
			Thread.sleep(3000);
			if(driver.findElement(By.xpath("//*[@id='loadingDiv']/span/img")).isDisplayed()) {
				System.out.println("----------Displaying loading page");
				TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("SignUp page displaying with 'Please Wait' message while loading with newly created SignUpDetails", TimeDynamo_BaseUrl.color.BLUE));
			}
			/*TimeDynamo_LoginElements obj=new TimeDynamo_LoginElements(driver);
			obj.login(eMail, passwd);
			TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("SignIn Successful with newly created SignUpDetails", TimeDynamo_BaseUrl.color.BLUE));*/
		}
		
		try {
		driver.findElement(By.id("signupPassword")).clear();
		driver.findElement(By.id("signupConfirmPassword")).clear();
	//	driver.findElement(By.id("legalPolicyAgreeCheckbox")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	//To get the Total leaves on Today fro mDashBoard
	public void totalLeavesToday() {
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='leave-element']"));
		System.out.println("--------------"+list.size());
		for(WebElement ele : list) {
			System.out.println("--------->"+ele.getText());
			String name=ele.getText();
			String arr[]=name.split(" ", 2);
			System.out.println("@@@@@@@@-------->"+arr[0]);
		}
		
	}

}
