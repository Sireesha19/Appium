package TroopMessengerApp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GroupRoleEle {
	AndroidDriver driver;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionSearch")
	public AndroidElement searchBtn;
	
	@FindBy(id="com.tvisha.troopmessenger:id/search")
	public AndroidElement searchfld;
	
	@FindBy(id="com.tvisha.troopmessenger:id/item")
	public List<AndroidElement> rowsCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userPic")
	public AndroidElement profpic;
	
	@FindBy(id="com.tvisha.troopmessenger:id/groupName_edit")
	public AndroidElement editIcon;
	
	@FindBy(id="com.tvisha.troopmessenger:id/newGroupName")
	public AndroidElement editGrpName;
	
	@FindBy(id="com.tvisha.troopmessenger:id/done")
	public AndroidElement eDone;
	
	@FindBy(id="com.tvisha.troopmessenger:id/cancel")
	public AndroidElement eCancel;
	
	@FindBy(id="com.tvisha.troopmessenger:id/count_members")
	public AndroidElement memCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/close")
	public AndroidElement cancel;
	
	@FindBy(id="com.tvisha.troopmessenger:id/message")
	public AndroidElement msg;
	
	@FindBy(id="com.tvisha.troopmessenger:id/viewProfile")
	public AndroidElement viewProfile;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public AndroidElement userName;
	
	@FindBy(id="com.tvisha.troopmessenger:id/makeAsAdmin")
	public AndroidElement makeAdmn;
	
	@FindBy(id="com.tvisha.troopmessenger:id/makeAsModerator")
	public AndroidElement makeModerator;
	
	@FindBy(id="com.tvisha.troopmessenger:id/removeFromGroup")
	public AndroidElement rmvFrmGrp;
	
	/*@FindBy(id="")
	public AndroidElement */
	
						public GroupRoleEle(AndroidDriver driver)
						{
							this.driver=driver;
							PageFactory.initElements(new AppiumFieldDecorator(driver, 6, TimeUnit.SECONDS),this);
							
						}
						
						public void GroupRole(String grp) throws InterruptedException
						{
							Thread.sleep(3000);
							int c=rowsCount.size();
							System.out.println("Total rows=====>"+c);
							for(int i=0;i<c;i++)
							{
								Thread.sleep(500);
								WebElement ele=driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
								if(ele.isDisplayed()) {
									WebElement ele1=driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
									String txt=ele1.getText();
									
									System.out.println(i+"th row text =======>" +txt);
									try
									{
									//Assert.assertEquals(txt, grp, "not equals");
									if(grp.contentEquals(txt)) {
										System.out.println("====>group name found");
										ele1.click();
										Thread.sleep(2000);
										break;
									}
									}catch(Exception e) {
									WebElement ele2=driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
									System.out.println(i+"th row text =======>" +ele2.getText());
								}
						
							}
						}
					
						}
						
						
						public void profPicClk()
						{
							profpic.click();
						}	
							
					
						public void editNme(String ename)
						{
							editIcon.click();
							editGrpName.clear();
							editGrpName.sendKeys(ename);
							Assert.assertEquals(ename, editGrpName.getText(), "Not equals");
							System.out.println("Group name is edited");
							eDone.click();
						}
						public void roleAssign()
						{
							String txt=memCount.getText();
							int t=Integer.parseInt(txt);
							System.out.println("Group members count is :->"+t);
							memCount.click();
							for(int i=0;i<t;i++) {
								List<AndroidElement> gList=driver.findElementsById("com.tvisha.troopmessenger:id/item");
								System.out.println("=====>"+gList.size());
								//group members verification
								gList.get(i).click();
								String str1=userName.getText();
								System.out.println("UserName is =====> "+userName.getText());
								try {
									//driver.findElementById("com.tvisha.troopmessenger:id/removeFromGroup").click();
									WebElement img=driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='1/android.widget.ImageView']");
									cancel.click();
									if(img.isDisplayed()) {
										System.out.println("Admin is   :"+userName.getText());
									}
									
								}catch(Exception e) {
									viewProfile.click();
									String str2=userName.getText();
									if(str1.contentEquals(str2)) {
										System.out.println("==========>User  "+str1+"   Profile verified");
										driver.findElementById("com.tvisha.troopmessenger:id/actionBack").click();
									}
									else {
										System.out.println("==========>User  "+str1+"   Profile not verified");
									}
									makeAdmn.click();
									WebElement img=driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='1/android.widget.ImageView']");
									if(img.isDisplayed()) {
										System.out.println(makeAdmn.getText()+"      Role is asigned");
									}
								}
							}
						}
						
						public void reply() {
							int textrows=driver.findElementsById("com.tvisha.troopmessenger:id/relative_layout_text").size();
							int imgrows=driver.findElementsById("com.tvisha.troopmessenger:id/messageContainer").size();
							System.out.println("Textrows r--"+textrows+"=======Imagerows r--"+imgrows);
						}
						
						

}
