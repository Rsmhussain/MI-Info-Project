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

//Importing Base Class
import info.base.Reusableclass;

//Importing Page Object Class
import info.pojo.IndividualAttendanceReport_POJO;
import info.pojo.OTRatioReport_POJO; 
import info.pojo.SavedCustomReport_POJO;

//Importing the Excel Reader Class
import info.utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SavedCustomReport extends Reusableclass
{
	SavedCustomReport_POJO SCRP;
	WebDriverWait wait= new WebDriverWait(driver,100);

	@Given("User is on saved custom report page")
	public void user_is_on_saved_custom_report_page() 
	{
		SCRP = new SavedCustomReport_POJO();
		
		System.out.println("driver="+driver);
	    mouseOver(SCRP.ReportMenu);
	    mouseOver(SCRP.CustomReportMenu);
	    wait.until(ExpectedConditions.elementToBeClickable(SCRP.SavedCustomReportMenu));
	    toClick(SCRP.SavedCustomReportMenu);
	}

	@When("User click the edit button")
	public void user_click_the_edit_button() 
	{
		SCRP = new SavedCustomReport_POJO();
		toClick(SCRP.EditButton);
	}
	
	@Then("User update the select period details for Master Report {string} and {int}")
	public void user_update_the_select_period_details_for_master_report_and(String SCRSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		SCRP = new SavedCustomReport_POJO();
		
		//Reading Data From Excel Sheet 
		ExcelReader reader=new ExcelReader();
		List<Map<String, String>> SCRData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SCRSheet);
		
		//ReportTitle 
		String ReportTitle=SCRData.get(RowNumber).get("ReportTitle");
		
		//Select Period Tab Functional Flow
		try
		{
		actionssendkeysdelete(SCRP.ReportTitle);
		tofill(SCRP.ReportTitle, ReportTitle);
		toClick(SCRP.MasterReport);
		toClick(SCRP.NextButton);
		System.out.println("Select Period Tab Functionality Is Completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Then("User update the select report column details for Master Report {string} and {int}")
	public void user_update_the_select_report_column_details_for_master_report_and(String SCRSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		SCRP = new SavedCustomReport_POJO();
		
		//Reading Data From Excel Sheet 
		ExcelReader reader=new ExcelReader();
		List<Map<String, String>> SCRData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SCRSheet);
		
		//Table and Fields 
		String TableAndFields=SCRData.get(RowNumber).get("Table and Fields");
		
		try
		{
			
		/*actionssendkeysdelete(SCRP.SearchTextBox);
		tofill(SCRP.SearchTextBox, TableAndFields);
		toClick(SCRP.SearchButton);
		wait.until(ExpectedConditions.elementToBeClickable(SCRP.EmployeeBasicCheckBox));
		toClick(SCRP.EmployeeBasicCheckBox);
		toClick(SCRP.MoveSelectedButton);*/
		
		toClick(SCRP.EmployeeDetailsTree);
		Thread.sleep(1000);
		toClick(SCRP.EmployeeBasicCheckBox);
		Thread.sleep(2000);
		toClick(SCRP.MoveSelectedButton);
		
		//Remove Selected Items
		Thread.sleep(8000);
		Select s=new Select(driver.findElement(By.id("ContentPlaceHolder1_wzrdCustomReport_lstReportColumns")));
		
		List<WebElement> elementCount = s.getOptions();
		System.out.println("Selected Fields: "+elementCount.size());
		
		//using for loop for Selecting All
		for(int i=0;i<=elementCount.size()-1;i++)
		{
			s.selectByIndex(i);
			if(i>23)
			{
				Scrolldownjavascript();
			}
		}
		
		Thread.sleep(4000);
		
		toClick(SCRP.RemoveSelectedButton);
		
		//Selecting BusinessDetails
		Thread.sleep(5000);
		toClick(SCRP.BusinessDetailsCheckBox);
		
		Thread.sleep(2000);
		toClick(SCRP.MoveSelectedButton);
		
		Thread.sleep(4000);
		mouseclick(SCRP.Next2Button);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
 
	@Then("User update the Add filter details for Master Report {string} and {int}")
	public void user_update_the_add_filter_details_for_master_report_and(String string, Integer int1) throws InterruptedException 
	{
		SCRP = new SavedCustomReport_POJO();
		
		//And 
		
		//Selecting Value from Column Drop Down
		Select column=new Select(SCRP.ColumnNameDropDown);
		
		List<WebElement> lcol=column.getOptions();
		
		//Display the available options in Column Drop Down
		for(int i=0;i<lcol.size();i++)
		{
			System.out.println("Options Available in the Dropdown"+lcol.get(i).getText());
		}
		
		column.selectByValue("Staffmaster.DeptCodeC");
		
		//Selecting Value from Conditions Drop Down
		Thread.sleep(3000);
		Select conditions=new Select(SCRP.ConditionsDropDown);
		
		List<WebElement> lcon=column.getOptions();
		
		//Display the available options in Conditions Drop Down
		for(int i=0;i<lcon.size();i++)
		{
			System.out.println("Options Available in the Dropdown"+lcon.get(i).getText());
		}
		
		Thread.sleep(1000);
		conditions.selectByValue("Equal To");
		
		//Selecting Value from Value Drop Down
		Thread.sleep(3000);
		Select value=new Select(SCRP.ValueDropDown);
		
		List<WebElement> lval=column.getOptions();
		
		//Display the available options in Value Drop Down
		for(int i=0;i<lval.size();i++)
		{
			System.out.println("Options Available in the Value Dropdown: "+lval.get(i).getText());
		}
		Thread.sleep(1000);
		value.selectByValue("ADM");
		
		wait.until(ExpectedConditions.elementToBeClickable(SCRP.AddToListButton));
		toClick(SCRP.AddToListButton);
		
		//=============================== OR ==========================================//
		
		//OR 
		
		Thread.sleep(3000);
		toClick(SCRP.ORRadioButton);
		
		// Selecting Value from Column Drop Down
		Thread.sleep(2000);
		Select column2 = new Select(SCRP.ColumnNameDropDown);

		Thread.sleep(1000);
		column2.selectByVisibleText("Department");

		// Selecting Value from Conditions Drop Down
		Thread.sleep(2000);
		Select conditions2 = new Select(SCRP.ConditionsDropDown);

		Thread.sleep(1000);
		conditions2.selectByVisibleText("Not Equal To");

		// Selecting Value from Value Drop Down
		Thread.sleep(2000);
		Select value2 = new Select(SCRP.ValueDropDown);

		Thread.sleep(1000);
		value2.selectByVisibleText("OPERATIONS");

		wait.until(ExpectedConditions.elementToBeClickable(SCRP.AddToListButton));
		toClick(SCRP.AddToListButton);
		
		
		//Edit Scenario
		
		wait.until(ExpectedConditions.elementToBeClickable(SCRP.ListEditButton));
		toClick(SCRP.ListEditButton);
		
		// Selecting Value from Value Drop Down
		Thread.sleep(2000);
		Select value3 = new Select(SCRP.ValueDropDown);

		Thread.sleep(1000);
		value3.selectByVisibleText("ADMIN");
		
		wait.until(ExpectedConditions.elementToBeClickable(SCRP.ListUpdateButton));
		toClick(SCRP.ListUpdateButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(SCRP.ListDeleteButton));
		toClick(SCRP.ListDeleteButton);
		
		driver.switchTo().alert().dismiss();
		
		
		
		
		
		System.out.println("Add Filter Tab");
	}

	@Then("User Generate the report {string} and {int}")
	public void user_generate_the_report_and(String string, Integer int1) 
	{
		System.out.println("Add Filter Tab");
	}
	
	
}
