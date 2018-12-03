package package1;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import package2.RequiredMethods;

public class TimeDynamo_TC04_Dashboard extends TimeDynamo_TC01_Login{
	
	@Test
	public void  leavesOnToday() {
		System.out.println("---------------------------->");
		RequiredMethods obj=new RequiredMethods(driver);
		obj.totalLeavesToday();
		
		
	}

}
