package info.stepdefinition;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import info.base.Reusableclass;
import info.pojo.IndividualAttendanceReport_POJO;
import info.pojo.OTRatioReport_POJO; 
import info.utilities.ExcelReader;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class OTRatioReport extends Reusableclass
{

	OTRatioReport_POJO OTRP;
	WebDriverWait wait= new WebDriverWait(driver,100);
	
	@Given("User is on OT Ratio Report")
	public void user_is_on_ot_ratio_report() 
	{
		OTRP = new OTRatioReport_POJO();
		
		System.out.println("driver="+driver);
	    mouseOver(OTRP.ReportMenu);
	   
	    wait.until(ExpectedConditions.elementToBeClickable(OTRP.OTRatioReportMenu));
	    toClick(OTRP.OTRatioReportMenu);
	}

	@When("User enter the date range and select all employee {string} and {int}")
	public void user_enter_the_date_range_and_select_all_employee_and(String OTRRSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
	   
		OTRP = new OTRatioReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> OTRRData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", OTRRSheet);
		
		try
		{
			//From Date 
			String fromdate=OTRRData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(OTRP.FromDate);
			//mouseclick(IARP.FromDate);
			Thread.sleep(2000);
			tofill(OTRP.FromDate,fromdate);
			
			//To Date 
			String todate=OTRRData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(OTRP.ToDate);
			//mouseclick(IARP.ToDate);
			Thread.sleep(2000);
			tofill(OTRP.ToDate,todate);
			toenter();
			
			//Click Checkall
			Thread.sleep(1000);
			mouseclick(OTRP.EmpCheckAll);
					
			System.out.println("Individual");
			
			//Click Show Button
			Scrolldownjavascript();
			Thread.sleep(1000);
			toClick(OTRP.ShowButton);
			
			//Taking Passed Screenshot
            passedScreenShot(driver, "Individual OT Ratio Report");
            
            //Exit The Report
			toClick(OTRP.ExitButton);
			
			//======== Verification Section =========//			
			
			//WebElement actual=driver.findElement(By.xpath("//*[@id=\"GroupName1\"]/table/tbody/tr/td/table/tbody/tr/td/span[contains(text(),'SHEIK')]"));
			/*
			Thread.sleep(2000);
			toClick(OTRP.ReportSearch);
			tofill(OTRP.ReportSearch, "SHEIK");*/
			//System.out.println(actual.getText());
			//String Expected="OT Ratio Report (Individual)";
			
			//Verify the Individual Report              
			// Assert.assertEquals(actual,Expected,"First hard assert failed for Individual Report"); // Hard Assert
            
			//==========================================//
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Then("User click the show button")
	public void user_click_the_show_button() throws InterruptedException 
	{
		
		System.out.println("Exclude");
	
		
		/*if(OTRP.ShowButton.isSelected())
		{
			System.out.println("Show Button is Clicked");
		}
		else
		{
			System.out.println("Show Button is Not Clicked");
		}*/
	}

	@When("User enter the date range and select the particular department {string} and {int}")
	public void user_enter_the_date_range_and_select_the_particular_department_and(String OTRRSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
	    
		OTRP = new OTRatioReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> OTRRData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", OTRRSheet);
		
		try
		{
			
			//Department Raido Button
			Selectcheckbox(OTRP.Department);
			
			//Department Name
			String department=OTRRData.get(RowNumber).get("Department Name");
			actionssendkeysdelete(OTRP.SearchTextBox);
			mouseclick(OTRP.SearchTextBox);
			
			Thread.sleep(1000);
			tofill(OTRP.SearchTextBox,department);
			
			//driver.navigate().refresh();
			
			//Search Department
			Thread.sleep(3000);
			toClick(OTRP.Search);
			
			//wait.until(ExpectedConditions.elementToBeClickable(OTRP.CheckAll));
			Thread.sleep(3000);
			mouseclick(OTRP.DeptCheckAll);
		
			System.out.println("Department");
			
			Scrolldownjavascript();
			Thread.sleep(1000);
			toClick(OTRP.ShowButton);
			//Taking Passed Screenshot
            passedScreenShot(driver, "Individual OT Ratio Report");
            //Exit The Report
			toClick(OTRP.ExitButton);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@When("User enter the date range and select the particular section {string} and {int}")
	public void user_enter_the_date_range_and_select_the_particular_section_and(String OTRRSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
	    
		OTRP = new OTRatioReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> OTRRData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", OTRRSheet);
		
		try
		{
			//Section Raido Button
			Selectcheckbox(OTRP.Section);
			
			//Enter the Section Name in Text Box
			String section=OTRRData.get(RowNumber).get("Section Name");
			Thread.sleep(3000);
			actionssendkeysdelete(OTRP.SearchTextBox);
			mouseclick(OTRP.SearchTextBox);
			Thread.sleep(3000);
			tofill(OTRP.SearchTextBox,section);
			
			//Click Search button
			Thread.sleep(3000);
			toClick(OTRP.Search);
			
			//wait.until(ExpectedConditions.elementToBeClickable(OTRP.CheckAll));
			Thread.sleep(3000);
			mouseclick(OTRP.SectCheckAll);
			
			System.out.println("Section");
			
			Scrolldownjavascript();
			Thread.sleep(1000);
			toClick(OTRP.ShowButton);
			//Taking Passed Screenshot
            passedScreenShot(driver, "Individual OT Ratio Report");
            //Exit The Report
			toClick(OTRP.ExitButton);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@When("User enter the date range and select all designation {string} and {int}")
	public void user_enter_the_date_range_and_select_all_designation_and(String OTRRSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
	   
		OTRP = new OTRatioReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> OTRRData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", OTRRSheet);
		
		try
		{
		
			//Designation Raido Button
			Selectcheckbox(OTRP.Designation);
			
			Thread.sleep(2000);
			
			//wait.until(ExpectedConditions.elementToBeClickable(OTRP.CheckAll));
			Thread.sleep(2000);
			mouseclick(OTRP.DesCheckAll);
			
			System.out.println("Designation");
			
			Scrolldownjavascript();
			Thread.sleep(1000);
			toClick(OTRP.ShowButton);
			//Taking Passed Screenshot
            passedScreenShot(driver, "Individual OT Ratio Report");
            //Exit The Report
			toClick(OTRP.ExitButton);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
