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
import info.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualAttendanceReport extends Reusableclass
{
	
	IndividualAttendanceReport_POJO IARP;
	WebDriverWait wait= new WebDriverWait(driver,100);
	
	@Given("User is on Individual Attendance Report")
	public void user_is_on_individual_attendance_report() 
	{
		
		IARP = new IndividualAttendanceReport_POJO();
		
		System.out.println("driver="+driver);
	    mouseOver(IARP.ReportMenu);
	   
	    wait.until(ExpectedConditions.elementToBeClickable(IARP.IndividualAttedanceReportMenu));
	    toClick(IARP.IndividualAttedanceReportMenu);
		    
	}

	@When("User enter the date range, Normal OT type and select all filter by option {string} and {int}")
	public void user_enter_the_date_range_ot_type_and_select_filter_by_option_and(String IARSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			//mouseclick(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			//mouseclick(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			//Employee OT Type
			toClick(IARP.Normal);
			
			//Show Actual Clocking
			Selectcheckbox(IARP.ShowActualClocking);
		
			//Hide Allowance
			Selectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			Selectcheckbox(IARP.HideZero);
			
			//Hide Zero Allowance
			Selectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Individual Report Option
			Selectcheckbox(IARP.Individual);
			
			//Employee Name
			String employeename=IARData.get(RowNumber).get("Employee Name");
			actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,employeename);
			
			toClick(IARP.EmployeeSearchBtn);
			
			Thread.sleep(2000);
			//driver.navigate().refresh();
			
			toClick(IARP.EmpCheckAll);
			
			System.out.println("Normal - Individual");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@When("User select the sort by drop down based on employee code and ascending {string} and {int}")
	public void user_select_the_sort_by_drop_down_based_on_employee_code_and_ascending_and(String string, Integer int1) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ContentPlaceHolder1_ddlSortBy")));
	    Select sortemp=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortBy")));
	    
	    sortemp.selectByVisibleText("Employee Code");
	    
	    Select sort=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortDirection")));
	    sort.selectByVisibleText("Ascending");
	}

	@Then("User click the Preview button and Export button")
	public void user_click_the_preview_button_and_export_button() throws InterruptedException 
	{
		IARP = new IndividualAttendanceReport_POJO();
		Thread.sleep(3000);
		toClick(IARP.Preview);
		
		String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        
        while (i1.hasNext()) 
        {
            String ChildWindow = i1.next();
                if (!mainwindow.equalsIgnoreCase(ChildWindow)) 
                {
                driver.switchTo().window(ChildWindow);
                Thread.sleep(2000);
                System.out.println(ChildWindow);
                
                String child=driver.getCurrentUrl();
                
                //Verify the Report Window               
                Assert.assertEquals(child, "https://staging.info-tech.com.sg/PreviewPDF.aspx#zoom=100");
                passedScreenShot(driver, "Individal Attendance Reports");
                driver.close();
                System.out.println("Child window closed");
                }
        }    
  
        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        
        Thread.sleep(1000);
		
        //Verify the ExcelExport.Xlsx
        toClick(IARP.ExcelExport);
        Assert.assertTrue(isFileDownloaded_Ext("C:\\Users\\Sheik Mohammed\\Downloads", ".xlsx"), "Failed to download document which has extension .xlsx");
        passedScreenShot(driver, "Individal Attendance Reports");
		
        //Verify the ExcelExport.CSV
        toClick(IARP.btnExportCSV);
        Assert.assertTrue(isFileDownloaded_Ext("C:\\Users\\Sheik Mohammed\\Downloads", ".csv"), "Failed to download document which has extension .csv");
        passedScreenShot(driver, "Individal Attendance Reports");
        
		Thread.sleep(2000);
		
	}
	
	//Weekly OT Scneario
	
	@When("User enter the date range, Weekly OT type and default filter option {string} and {int}")
	public void user_enter_the_date_range_weekly_ot_type_and_default_filter_option_and(String IARSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			//mouseclick(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			//mouseclick(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			//Employee OT Type
			toClick(IARP.Weekly);
			
			Thread.sleep(1000);
			//Show Actual Clocking
			unSelectcheckbox(IARP.ShowActualClocking);
					
			//Hide Allowance
			unSelectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			unSelectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Employee Name
			String employeename=IARData.get(RowNumber).get("Employee Name");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchText));
			actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,employeename);
			
			//Search employee
			//driver.navigate().refresh();
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchBtn));
			toClick(IARP.EmployeeSearchBtn);
			
			//Check All
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmpCheckAll));
			toClick(IARP.EmpCheckAll);
			System.out.println("Weekly - Individual");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	//Deaprtment Based Report
	
	@When("User enter the date range, Normal OT type and default filter option {string} and {int}")
	public void user_enter_the_date_range_normal_ot_type_and_default_filter_option_and(String IARSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		String mainwindow = driver.getWindowHandle();
		driver.switchTo().window(mainwindow);
		
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			Thread.sleep(1000);
			//Employee OT Type
			toClick(IARP.Normal);
						
			//Show Actual Clocking
			unSelectcheckbox(IARP.ShowActualClocking);
					
			//Hide Allowance
			unSelectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			unSelectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Department Report Option
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.Department));
			Selectcheckbox(IARP.Department);
			
			//Department Name
			/*String departmentname=IARData.get(RowNumber).get("Department Name");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchText));
			actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,departmentname);*/
			
			//Search Department
			/*Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchBtn));
			toClick(IARP.EmployeeSearchBtn);*/
		
			//Check All
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.DepCheckAll));
			toClick(IARP.DepCheckAll);
			System.out.println("Normal - Department");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	@When("User Select the sort by drop down based on employee name and descending {string} and {int}")
	public void user_select_the_sort_by_drop_down_based_on_employee_name_and_descending_and(String IARSheet, Integer RowNumber) throws InterruptedException 
	{
			
		Select sortemp=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortBy")));
	    sortemp.selectByVisibleText("Employee Name");
	    
	    Thread.sleep(2000);
	    Select sort=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortDirection")));
	    sort.selectByVisibleText("Descending");
	    
	}
	
	//Section Option for Report
	
	@When("User enter the date range, Normal OT type and all filter option {string} and {int}")
	public void user_enter_the_date_range_normal_ot_type_and_all_filter_option_and(String IARSheet, Integer RowNumber) throws Exception, IOException 
	{
		//Switch to Main Window
		String mainwindow = driver.getWindowHandle();
		driver.switchTo().window(mainwindow);
		
		
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			Thread.sleep(1000);
			//Employee OT Type
			toClick(IARP.Normal);
						
			//Show Actual Clocking
			Selectcheckbox(IARP.ShowActualClocking);
					
			//Hide Allowance
			Selectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			Selectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Section Report Option
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.Section));
			Selectcheckbox(IARP.Section);
			
			//Department Name
			String departmentname=IARData.get(RowNumber).get("Department Name");
			Thread.sleep(1000);
			
			//Department Drop Down
			toClick(IARP.DepartmentDDtextbox);
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.DepartmentDDtextbox);
			clickjavascript(IARP.DepartmentDDtextbox);
			Thread.sleep(1000);
			tofill(IARP.DepartmentDDtextbox, departmentname);
			Thread.sleep(2000);
			todown();
			toenter();
			
			//Section Name
			String sectionname=IARData.get(RowNumber).get("Section Name");
			Thread.sleep(2000);
			
			//Section Search
		/*	wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchText));
			actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,sectionname);
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchBtn));
			toClick(IARP.EmployeeSearchBtn);*/
			
			//Check All
			Thread.sleep(6000);
			toClick(IARP.SecCheckAll);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.SecCheckAll));
			System.out.println("Normal - Section");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@When("User Select the sort by drop down based on employee code and descending {string} and {int}")
	public void user_select_the_sort_by_drop_down_based_on_employee_code_and_descending_and(String string, Integer int1) throws InterruptedException 
	{
	    
		Select sortemp=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortBy")));
	    sortemp.selectByVisibleText("Employee Code");
	    
	    Thread.sleep(2000);
	    Select sort=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortDirection")));
	    sort.selectByVisibleText("Descending");
		
	}
	
	//Designation Option For Report
	
	@When("User enter the date range, Normal OT type and default filter option for designation {string} and {int}")
	public void user_enter_the_date_range_normal_ot_type_and_default_filter_option_for_designation_and(String IARSheet, Integer RowNumber) throws InvalidFormatException, Exception 
	{
		String mainwindow = driver.getWindowHandle();
		driver.switchTo().window(mainwindow);
		
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			Thread.sleep(1000);
			//Employee OT Type
			toClick(IARP.Normal);
						
			//Show Actual Clocking
			unSelectcheckbox(IARP.ShowActualClocking);
					
			//Hide Allowance
			unSelectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			unSelectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Designation Report Option
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.Designation));
			Selectcheckbox(IARP.Designation);
			
			//Designation Name
			String designationname=IARData.get(RowNumber).get("Designation Name");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchText));
			/*actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,designationname);
			
			//Search Designation
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchBtn));
			toClick(IARP.EmployeeSearchBtn);*/
		
			//Check All
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.DesCheckAll));
			toClick(IARP.DesCheckAll);
			System.out.println("Normal - Designation");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@When("User Select the sort by drop down based on employee name and ascending for designation {string} and {int}")
	public void user_select_the_sort_by_drop_down_based_on_employee_name_and_ascending_for_designation_and(String IARSheet, Integer RowNumber) throws InterruptedException 
	{

		Select sortemp=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortBy")));
	    sortemp.selectByVisibleText("Employee Code");
	    
	    Thread.sleep(2000);
	    Select sort=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortDirection")));
	    sort.selectByVisibleText("Ascending");
		
	}

	//Category Section
	@When("User enter the date range, Normal OT type and default filter option for category {string} and {int}")
	public void user_enter_the_date_range_normal_ot_type_and_default_filter_option_for_category_and(String IARSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		String mainwindow = driver.getWindowHandle();
		driver.switchTo().window(mainwindow);
		
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			Thread.sleep(1000);
			//Employee OT Type
			toClick(IARP.Normal);
						
			//Show Actual Clocking
			unSelectcheckbox(IARP.ShowActualClocking);
					
			//Hide Allowance
			unSelectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			unSelectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Designation Report Option
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.Category));
			Selectcheckbox(IARP.Category);
			
			//Category Name
			String categoryname=IARData.get(RowNumber).get("Category Name");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchText));
			/*actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,categoryname);
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchBtn));
			toClick(IARP.EmployeeSearchBtn);*/
		
			//Check All
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.CatCheckAll));
			toClick(IARP.CatCheckAll);
			System.out.println("Normal - Designation");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@When("User Select the sort by drop down based on employee name and ascending for category {string} and {int}")
	public void user_select_the_sort_by_drop_down_based_on_employee_name_and_ascending_for_category_and(String IARSheet, Integer RowNumber) throws InterruptedException 
	{
		Select sortemp=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortBy")));
	    sortemp.selectByVisibleText("Employee Code");
	    
	    Thread.sleep(2000);
	    Select sort=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortDirection")));
	    sort.selectByVisibleText("Descending");
	    
	}
	
	//Extra Classification
	@When("User enter the date range, Normal OT type and default filter option for extra classification {string} and {int}")
	public void user_enter_the_date_range_normal_ot_type_and_default_filter_option_for_extra_classification_and(String IARSheet, Integer RowNumber) throws InvalidFormatException, IOException 
	{
		String mainwindow = driver.getWindowHandle();
		driver.switchTo().window(mainwindow);
		
		IARP = new IndividualAttendanceReport_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> IARData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", IARSheet);
		
		try
		{
			//From Date 
			String fromdate=IARData.get(RowNumber).get("From Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.FromDate);
			Thread.sleep(2000);
			tofill(IARP.FromDate,fromdate);
			
			//To Date 
			String todate=IARData.get(RowNumber).get("To Date");
			Thread.sleep(2000);
			actionssendkeysdelete(IARP.ToDate);
			Thread.sleep(2000);
			tofill(IARP.ToDate,todate);
			
			Thread.sleep(1000);
			//Employee OT Type
			toClick(IARP.Normal);
						
			//Show Actual Clocking
			unSelectcheckbox(IARP.ShowActualClocking);
					
			//Hide Allowance
			unSelectcheckbox(IARP.HideAllowance);
			
			//Hide Zero Allowance
			unSelectcheckbox(IARP.HideZero);
			
			//Show Monthly Allowance
			Selectcheckbox(IARP.MonthlyAllowance);
			
			//Show Comments
			Selectcheckbox(IARP.ShowComments);
			
			//Designation Report Option
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.Category));
			Selectcheckbox(IARP.ExtraClassification);
			
			//Extra Classification
			String extraclassification=IARData.get(RowNumber).get("Extra Classification");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchText));
		/*	actionssendkeysdelete(IARP.EmployeeSearchText);
			mouseclick(IARP.EmployeeSearchText);
			tofill(IARP.EmployeeSearchText,extraclassification);
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.EmployeeSearchBtn));
			toClick(IARP.EmployeeSearchBtn);*/
		
			//Check All
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(IARP.ExtraClasCheckAll));
			toClick(IARP.ExtraClasCheckAll);
			System.out.println("Normal - Extra Classification");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	@When("User Select the sort by drop down based on employee name and ascending for extra classification {string} and {int}")
	public void user_select_the_sort_by_drop_down_based_on_employee_name_and_ascending_for_extra_classification_and(String string, Integer int1) throws InterruptedException 
	{
		Select sortemp=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortBy")));
	    sortemp.selectByVisibleText("Employee Code");
	    
	    Thread.sleep(2000);
	    Select sort=new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlSortDirection")));
	    sort.selectByVisibleText("Ascending");
	}
	
}
