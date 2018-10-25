package TroopMessengerApp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageCountPageEle {
	WebDriver driver;
	@FindBy(xpath="//span[@class='message-count ']")
	public List<WebElement> msgCount;
	
	@FindBy(className="messenger-user-row recent-chat-user-wrapper row-visible")
	public List<WebElement> userRows;

	
	
											public MessageCountPageEle(WebDriver driver) {
												this.driver=driver;
												PageFactory.initElements(driver, this);
											}
											
											public void msgCount() {
												int i=userRows.size();
												System.out.println("Message count======>"+i);
												for(int j=0;j<i;j++) {
													boolean bval=msgCount.get(j).isDisplayed();
													if(true) {
													String user=userRows.get(j).getAttribute("data-search");
													System.out.println("Username==========>"+user);
													System.out.println("message count is=====>"+msgCount.get(j).getText());
													}
													
													
													
												}
												
												
											}
}
