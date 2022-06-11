package info.stepdefinition;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import info.base.Reusableclass;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.AutoshiftOld_POJO;
import info.pojo.User_POJO;
import info.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Reusableclass 
{
	User_POJO usp;
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() 
	{
	    System.out.println("User is on Login Page");
	    
	    browserLaunch();
		toMaximize();
		deletecookies();
		launchUrl("https://staging.info-tech.com.sg");

	}
	
	@When("User enter the login user name {string} and password {int}")
	public void user_enter_the_login_user_name_and_password(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException 
	{
		System.out.println("User enter the login user name");
		
		ExcelReader reader=new ExcelReader();
		
		usp = new User_POJO();
		List<Map<String,String>> testData=reader.getData("C:\\Users\\Sheik Mohammed\\Desktop\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
		String username=testData.get(RowNumber).get("Username");
		String password=testData.get(RowNumber).get("Password");
		String dbname=testData.get(RowNumber).get("DB Name");
		
		tofill(usp.Username, username);
		tofill(usp.password, password);
		toClick(usp.click);
		implicitwait();
		toClick(usp.ChangeDB);
		toClick(usp.DBnameenter);
		Thread.sleep(2000);
		tofill(usp.DBnameenter,dbname);
		Thread.sleep(2000);
		totabkey();
		Thread.sleep(1000);
		toenter();  
		
	}
}
