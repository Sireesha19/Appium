package TroopMessengerApp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrpMsngrLoginScreenEle {
	AndroidDriver driver;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/userId")
	public AndroidElement userId;
	
	@FindBy(id="com.tvisha.troopmessenger:id/password")
	public AndroidElement pwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/submitImg")
	public AndroidElement submitBtn;;
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionSearch")
	public AndroidElement searchIcon;

	@FindBy(id="com.tvisha.troopmessenger:id/search")
	public AndroidElement search;

	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public AndroidElement usrName; 

	@FindBy(id="com.tvisha.troopmessenger:id/newMesg")
	public AndroidElement newMsg;

	@FindBy(id="com.tvisha.troopmessenger:id/sendMessage")
	public AndroidElement sendMsgBtn;

	@FindBy(xpath="//android.widget.TextView[@text='Rakesh Adupa ']")
	public AndroidElement viewuser;
	
	@FindBy(id="com.tvisha.troopmessenger:id/item")
	public List<AndroidElement> predictedrows;

	@FindBy(id="com.tvisha.troopmessenger:id/txtMsg")
	public List<AndroidElement> msglist; 

	@FindBy(id="com.tvisha.troopmessenger:id/timeStamp")
	public List<AndroidElement> timelist; 
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionLable")
	public AndroidElement label;
	
	@FindBy(id="com.tvisha.troopmessenger:id/msgSentStatus")
	public AndroidElement msgSts;
	
	@FindBy(xpath="//android.widget.ImageView[@index='1']")
	public AndroidElement image;

										
	//unread message elements
	
	@FindBy(id="com.tvisha.troopmessenger:id/unreadMesgCount")
	//@FindBy(xpath="//android.widget.TextView[@index='2']")
	 public List<AndroidElement> unreadmsgCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/unreadMesgCount")
	public List<AndroidElement> unread_Count;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public List<AndroidElement> msgCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/unread_message")
	public AndroidElement unreadMsgBtn;
	
	@FindBy(xpath="//android.widget.LinearLayout[@index='1']")
	public List<AndroidElement> rows;
	
	@FindBy(id="com.tvisha.troopmessenger:id/item")
	public List<AndroidElement> total;
	
			

				public TrpMsngrLoginScreenEle(AndroidDriver driver)throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
				{
						this.driver=driver;
						PageFactory.initElements(new AppiumFieldDecorator(driver, 6, TimeUnit.SECONDS), this);
						
				}
				
				public void login(String userid,String passwd) throws InterruptedException
				{
					
					Thread.sleep(1000);
					userId.sendKeys(userid);
					pwd.sendKeys(passwd);
					submitBtn.click();
					Thread.sleep(5800);
					WebDriverWait wt=new WebDriverWait(driver, 60);
					WebElement lab=wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tvisha.troopmessenger:id/actionLable")));
					if(lab.isDisplayed()) {
					System.out.println("Login is successfull");
					}
					else {
						System.out.println("Login is Unsuccessfull");
					}
					
				}
				public void searchUser(String receive) throws InterruptedException
				{    
					
					Thread.sleep(3000);
					
					searchIcon.click();
					
					search.sendKeys(receive);
					predictedrows.get(0).click();
				}
				public void sendMsg(String msg) 
				{
					System.out.println("===========TestCase: sending message==========");
					newMsg.sendKeys(msg );
					SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm aa");
					String formattedDate = dateFormat.format(new Date()).toString();
					System.out.println(formattedDate);
					sendMsgBtn.click();
					
					System.out.println(msglist.size()+"time"+timelist.size());
					
					int a1=msglist.size()-1;
					//System.out.println(a1);
					int b1=timelist.size()-1;
					
					String mtxt=msglist.get(a1).getText();
					//System.out.println(mtxt);
					String ttxt=timelist.get(b1).getText();
					//System.out.println(ttxt);
				
					Assert.assertEquals(msg, mtxt, "Notequals");
					//System.out.println("sent msg equals");
					Assert.assertEquals(formattedDate, ttxt, "Notequals");
					System.out.println("sent msg=======>"+mtxt   +"Time equals======>"+ttxt);
					System.out.println("Message status is==========>"+msgSts.getText());
					//System.out.println("======>image status is "+image.getText());
					
				}
				
				public void getMsg(String msg) {
					
					System.out.println("===========TestCase: getting message==========");
					System.out.println(msglist.size()+"time"+timelist.size());
					
					int a1=msglist.size()-1;
					//System.out.println(a1);
					int b1=timelist.size()-1;
					
					String mtxt=msglist.get(a1).getText();
					//System.out.println(mtxt);
					String ttxt=timelist.get(b1).getText();
					//System.out.println(ttxt);
					System.out.println("sent msg=======>"+mtxt     +"Time equals======>"+ttxt);
					Assert.assertEquals(msg, mtxt, "Notequals");
					System.out.println("sent msg equals");
				//	Assert.assertEquals(formattedDate, ttxt, "Notequals");
				//	System.out.println("Time equals");
					
				}
				
				
				
				int index=0;
				int sum=0;
				int totall=0;
				
		public int scrolling() throws Exception {
					int m=msgCount.size();
					int	s=unreadmsgCount.size();
					index=index+s;
					totall=totall+m;
					String txt=msgCount.get(m-1).getText();
					for(int u=0;u<s;u++) {
						Thread.sleep(1000);
						String a=unreadmsgCount.get(u).getText();
						System.out.println(u +"th index message count is:   "+a);
						int count=Integer.parseInt(a);
						sum=sum+count;
					}
					Thread.sleep(2000);
					swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
					int m1=msgCount.size();
					System.out.println("after scroll=======>"+m1);
					if(txt.equals(msgCount.get(m1-1).getText())) 
					{
							System.out.println("==========>rows are repeating");
					}
					else {
						scrolling();
						}
						System.out.println("-------->Sum is"+sum+"\n========index count is :"+index+"\n========total messages are :"+totall);
						return index;
				}
					
				
				
				int index1=0;
				int sum1=0;
				int totall1=0;
				public int unreadmsgs() throws Exception 
				{
					unreadMsgBtn.click();
					
						int m=msgCount.size();
						int	s=unreadmsgCount.size();
						index1=index1+s;
						totall1=totall1+m;
						String txt=msgCount.get(m-1).getText();
						for(int u=0;u<s;u++) {
							Thread.sleep(1000);
							String a=unreadmsgCount.get(u).getText();
							System.out.println(u +"th index message count is:   "+a);
							int count=Integer.parseInt(a);
							sum1=sum1+count;
						}
							Thread.sleep(2000);
							swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
							int m1=msgCount.size();
							System.out.println("after scroll=======>"+m1);
							if(txt.equals(msgCount.get(m1-1).getText())) {
								System.out.println("==========>rows are repeating");
								}
							else {
								scrolling();
							}
							
						System.out.println("-------->Sum1 is"+sum1+"\n========index1 count is :"+index1+"\n========total1 messages are :"+totall1);
						return index1;
				}
	
					
				
				
				

		@SuppressWarnings("rawtypes")
		public static void swipeVertical(AppiumDriver driver2, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
		    Dimension size = driver2.manage().window().getSize();
		    int anchor = (int) (size.width * anchorPercentage);
		    int startPoint = (int) (size.height * startPercentage);
		    int endPoint = (int) (size.height * finalPercentage);
		    new TouchAction(driver2).press(anchor, startPoint).waitAction(Duration.ofMillis(duration)).moveTo(anchor, endPoint).release().perform();
		}
		
		public void searchIconClk(String receive) {
			searchIcon.click();
			search.sendKeys(receive);
		}
		/*public void searchVerify(String receive) throws Exception{
			int c=msgCount.size();
			System.out.println("=====>NO of matched rows predicted :"+c);
			//1st screen 
			for(int i=0;i<c;i++)
			{
				HashMap<String, String> chat=new HashMap<>();
				String txt=msgCount.get(i).getText();
				System.out.println("===Row Text is :"+txt);
				String[] arr=txt.split(" ");
				System.out.println("              ===============string splitting=============\n");
				int val=keywordValidation(arr,receive);
				if(val>=1) {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is matched with  "+receive);
					}
				else {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is not matched with  "+receive);
				}
			}
		}*/
		
		public void searchVerify(String receive) throws Exception {
		
			int c=msgCount.size();
			System.out.println("=====>NO of matched rows predicted :"+c);
			//1st screen 
			for(int i=0;i<c;i++)
			{
				
				String txt=msgCount.get(i).getText();
				System.out.println("===Row Text is :"+txt);
				String[] arr=txt.split(" ");
				System.out.println("              ===============string splitting=============\n");
				int val=keywordValidation(arr,receive);
				if(val>=1) {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is matched with  "+receive);
					}
				else {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is not matched with  "+receive);
				}
			}
			
			Thread.sleep(2000);
			String text=msgCount.get(c-1).getText();
		
			System.out.println("====last row text  "+text);
			swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
			int m1=msgCount.size();
			System.out.println("after scroll=======>"+m1);
			if(text.equals(msgCount.get(m1-1).getText())) 
			{
					System.out.println("==========>rows are not repeating ,search field verified! \n");
			}
			else {
				searchVerify(receive);
				}
			/*}catch(Exception e) { }*/
		}

		private int keywordValidation(String[] arr,String receive) {
			int count=0;
				for(int j=0;j<arr.length;j++) {
				System.out.println("Substring is=======>"+arr[j]);
				//System.out.println("              ===========substring comparison with key=========");
				
			int keylen=receive.length();
			System.out.println("GivenKeyLength=====>"+keylen);
			int stringlen=arr[j].length();
			String ss=arr[j].substring(0, keylen);
			String result=null;
			if(receive.equalsIgnoreCase(ss))
			{
				System.out.println("========>substring equals");
				System.out.println("SubString  "+arr[j]+"  is matched with  "+receive);
				result="pass";
				count++;
			}
			else {
				result="fail";
			}
			}
			return count;		
		}	
}
