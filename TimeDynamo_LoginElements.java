package package2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import package1.TimeDynamo_BaseUrl;

public class TimeDynamo_LoginElements {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/time_dynamo/public/login']")
	public WebElement LoginTab;
	
	@FindBy(id="bG9naW5Vc2VybmFtZUVsZW1lbnQ")
	public WebElement userName; 
	
	@FindBy(id="bG9naW5QYXNzd29yZEVsZW1lbnQ")
	public WebElement Pwd;
	
	@FindBy(id="bG9naW5CdG4")
	public WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='/time_dynamo/public/dashboard']")
	public WebElement dashboard;

	@FindBy(xpath="//a[@href='/time_dynamo/public/request']")
	public WebElement request;

	@FindBy(id="feedbackSection")
	public WebElement feedback;
	
	@FindBy(className="add-employee-text")
	public WebElement addEmpbtn;
	
	@FindBy(xpath="//i[@class='dropdown icon'][1]")
	public WebElement ToField;
	
	@FindBy(xpath="//*[@id=\"rightContentSlider\"]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/input")
	public WebElement CCField;
	
	@FindBy(id="leaveReason")
	public WebElement LeaveRes;
	
	@FindBy(xpath="//label[@for='halfdayRequire']")
	public WebElement HalfdayRequire;
	
	@FindBy(id="leaveRequestSubmitBtn")
	public WebElement LeaveReqBtn;
											public TimeDynamo_LoginElements(WebDriver driver) {
												this.driver=driver;
												PageFactory.initElements(driver, this);
											}
											
											public void login(String uname,String pwd) {
												LoginTab.click();
												userName.sendKeys(uname);
												Pwd.sendKeys(pwd);
												loginBtn.click();
												boolean b=dashboard.isDisplayed();
												//WebElement ele=driver.findElement(By.linkText("Dashboard"));
												System.out.println("==>"+dashboard.isDisplayed());
												TimeDynamo_BaseUrl.extentTest.log(Status.INFO,MarkupHelper.createLabel("Given Data	:\n"+"UserName	:"+uname+" , Password  :"+pwd, TimeDynamo_BaseUrl.color.BLUE));
												TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("Verify with 	- DashBoard display	: "+b, TimeDynamo_BaseUrl.color.BLUE));
														if(dashboard.isDisplayed()) {
															TimeDynamo_BaseUrl.extentTest.log(Status.PASS, MarkupHelper.createLabel("SignIn Successful", TimeDynamo_BaseUrl.color.GREEN));
														System.out.println("Login is successfull");
												
														}
														else {
															TimeDynamo_BaseUrl.extentTest.log(Status.FAIL, MarkupHelper.createLabel("SignIn UnSuccessful", TimeDynamo_BaseUrl.color.RED));
															System.out.println("Login is Unsuccessfull");
															}
											}
											
											public void login1(String uname,String pwd) {
												LoginTab.click();
												userName.sendKeys(uname);
												Pwd.sendKeys(pwd);
												loginBtn.click();
												boolean b=dashboard.isDisplayed();
												//WebElement ele=driver.findElement(By.linkText("Dashboard"));
												System.out.println("==>"+dashboard.isDisplayed());
												/*TimeDynamo_BaseUrl.extentTest.log(Status.INFO,MarkupHelper.createLabel("Given Data	:\n"+"UserName	:"+uname+" , Password  :"+pwd, TimeDynamo_BaseUrl.color.BLUE));
												TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("Verify with 	- DashBoard display	: "+b, TimeDynamo_BaseUrl.color.BLUE));*/
														if(dashboard.isDisplayed()) {
															//TimeDynamo_BaseUrl.extentTest.log(Status.PASS, MarkupHelper.createLabel("SignIn Successful", TimeDynamo_BaseUrl.color.GREEN));
														System.out.println("Login is successfull");
												
														}
														else
														{
															//TimeDynamo_BaseUrl.extentTest.log(Status.FAIL, MarkupHelper.createLabel("SignIn UnSuccessful", TimeDynamo_BaseUrl.color.RED));
															System.out.println("Login is Unsuccessfull");
														}
											}
											
											
											public void addRequest(String emp1,String emp2,String leaveMsg,String startDt,String endDt) throws InterruptedException
											{
												TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("Give Data /n:"+"Name For TO Field 	:"+emp1+",/nName For CC Field	:"+emp2+",/nMessage for LeaveReason	:"+leaveMsg+",/nStartDate	:"+startDt+",/nEndDate	:"+endDt, TimeDynamo_BaseUrl.color.BLUE));
												request.click();
												addEmpbtn.click();
												Thread.sleep(2000);
												
												EmailFields(emp1,emp2);
												
												Select drop=new Select(driver.findElement(By.id("leaveType")));
												drop.selectByIndex(1);
												String leaveOpt=drop.getFirstSelectedOption().getText();
												System.out.println("=====>"+leaveOpt);
												TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("Selected Leave Type	:"+leaveOpt, TimeDynamo_BaseUrl.color.BLUE));
												
												LeaveRes.sendKeys(leaveMsg);
												Thread.sleep(2000);
												driver.findElement(By.xpath("//input[@id='leaveStartDate'][@placeholder='start date']")).click();
												Thread.sleep(2000);
												WebElement dateWidget = driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[6]"));
												List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
												System.out.println("------------>"+columns.size());
														for(int i=0;i<columns.size();i++) {
															 if (columns.get(i).getText().equals(startDt)){
																 columns.get(i).click();
																 TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel(startDt+" Date selected of this month as StartDate", TimeDynamo_BaseUrl.color.BLUE));
															      break;
															     
															 }
												}
												
												driver.findElement(By.xpath("//input[@id='leaveEndDate'][@placeholder='end date']")).click();
												Thread.sleep(2000);
												
												//Datepicker for end date setting
												Dpicker(endDt);
												
												HalfdayRequire.click();
												LeaveReqBtn.click();
												verificationReq(leaveMsg);
												
												
												
											}	
											
											private void verificationReq(String leaveMsg) throws InterruptedException
											{
												Thread.sleep(1000);
												String fb=feedback.getText();
												System.out.println("Got feedback message :"+fb);
												TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("Message :"+fb, TimeDynamo_BaseUrl.color.GREEN));
												Thread.sleep(4000);
												//Due to Stale Element
												driver.findElement(By.xpath("//a[@href='/time_dynamo/public/dashboard']")).click();
											
												WebElement res=driver.findElement(By.xpath("//div[@class='self-request-list']/div[@class='request_reason']"));
												String Ereson=res.getText();
												String str=Ereson.replaceAll(" ", "");
												String str1=leaveMsg.replaceAll(" ", "");
												System.out.println("Expected==========>"+str+"Actual========>"+str1);
															if(str.contentEquals(str1)) {
																System.out.println("Leave requests are equal so sent request is diplaying in Self Requests of Dashboard");
																TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("Expected Message :"+str+", Atcual Message :"+str1+" ==> equals", TimeDynamo_BaseUrl.color.GREEN));
																TimeDynamo_BaseUrl.extentTest.log(Status.INFO,MarkupHelper.createLabel("Leave request of ReasonMessages  are equal so sent request is diplaying in Self Requests of Dashboard", TimeDynamo_BaseUrl.color.BLUE));
															}
															
															else{
																System.out.println("Leave requests are  not equal so sent request is not  diplaying in Self Requests of Dashboard");
																TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("Expected Message :"+str+", Atcual Message :"+str1+" ==> equals", TimeDynamo_BaseUrl.color.RED));
																TimeDynamo_BaseUrl.extentTest.log(Status.INFO,MarkupHelper.createLabel("Leave request of ReasonMessages  are not equal so sent request is not diplaying in Self Requests of Dashboard", TimeDynamo_BaseUrl.color.RED));
															}
												
											}

											public void permission(String emp1,String emp2,String leaveMsg,String endDt) throws InterruptedException 
											{
												TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel("Give Data \n:"+"Name For TO Field 	:"+emp1+",\nName For CC Field	:"+emp2+",\nMessage for LeaveReason	:"+leaveMsg+",\nEndDate	:"+endDt, TimeDynamo_BaseUrl.color.BLUE));
												request.click();
												addEmpbtn.click();
												driver.findElement(By.xpath("//*[@id=\"rightContentSlider\"]/div[2]/div[1]/div/div[1]/div[2]/span[2]")).click();
												
												//try {
													driver.findElement(By.xpath("//select/i[@class='dropdown icon'][3]")).click();
													//driver.findElement(By.xpath("//*[@id=\"rightContentSlider\"]/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/i))")).click();
													//driver.findElement(By.xpath("//i[@class='dropdown icon'][3]")).click();
													driver.findElement(By.xpath("//input[@class='search']")).sendKeys(emp1);
													ToField.sendKeys(Keys.DOWN);
													ToField.sendKeys(Keys.ENTER);
													TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("TO Field selected with :"+emp1, TimeDynamo_BaseUrl.color.GREEN));
												 /*  }catch(Exception e) {
														TimeDynamo_BaseUrl.extentTest.log(Status.ERROR,MarkupHelper.createLabel("TO Field not selected with :"+emp1, TimeDynamo_BaseUrl.color.RED));
													}
													*/
													//try {
													CCField.sendKeys(emp2);
													CCField.sendKeys(Keys.DOWN);
													CCField.sendKeys(Keys.ENTER);
													TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("CC Field selected with :"+emp2, TimeDynamo_BaseUrl.color.GREEN));
												/*	}catch (Exception e) {
														TimeDynamo_BaseUrl.extentTest.log(Status.ERROR,MarkupHelper.createLabel("CC Field not selected with :"+emp2, TimeDynamo_BaseUrl.color.RED));
													}*/
												
												/*driver.findElement(By.id("permissionDate")).click();
												Dpicker(endDt);
												driver.findElement(By.xpath("//label[@for='permissionLateLogin']")).click();
												driver.findElement(By.id("permissionRemarks")).sendKeys(leaveMsg);
												driver.findElement(By.id("permissionRequestSubmitBtn")).click();
												verificationReq(leaveMsg);*/
												
											}
											
											
											public void EmailFields(String emp1, String emp2) {
												
												try {
												ToField.click();
												driver.findElement(By.xpath("//input[@class='search']")).sendKeys(emp1);
												ToField.sendKeys(Keys.DOWN);
												ToField.sendKeys(Keys.ENTER);
												TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("TO Field selected with :"+emp1, TimeDynamo_BaseUrl.color.GREEN));
												}catch(Exception e) {
													TimeDynamo_BaseUrl.extentTest.log(Status.ERROR,MarkupHelper.createLabel("TO Field not selected with :"+emp1, TimeDynamo_BaseUrl.color.RED));
												}
												
												try {
												CCField.sendKeys(emp2);
												CCField.sendKeys(Keys.DOWN);
												CCField.sendKeys(Keys.ENTER);
												TimeDynamo_BaseUrl.extentTest.log(Status.PASS,MarkupHelper.createLabel("CC Field selected with :"+emp2, TimeDynamo_BaseUrl.color.GREEN));
												}catch (Exception e) {
													TimeDynamo_BaseUrl.extentTest.log(Status.ERROR,MarkupHelper.createLabel("CC Field not selected with :"+emp2, TimeDynamo_BaseUrl.color.RED));
												}
												
											}
											
										
											public void Dpicker(String endDt) {
												for(int k=1;k<7;k++) {
												WebElement dateWidget1 = driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr["+ k +"]"));
												List<WebElement> columns1=dateWidget1.findElements(By.tagName("td"));
												System.out.println("------------>"+columns1.size());
												for(int j=0;j<columns1.size();j++) {
													 if (columns1.get(j).getText().equals(endDt)){
														 columns1.get(j).click();
														 TimeDynamo_BaseUrl.extentTest.log(Status.INFO, MarkupHelper.createLabel(endDt+"Date selected of this month as endDate ", TimeDynamo_BaseUrl.color.BLUE));
														 break;
													 }
												}
												 break;
												}
												}
											
											}
										
	

