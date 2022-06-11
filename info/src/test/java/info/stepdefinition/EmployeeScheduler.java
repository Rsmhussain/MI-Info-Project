package info.stepdefinition;

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
import info.pojo.EmployeeAllocation_POJO;
import info.pojo.User_POJO;
import info.pojo.EmployeeScheduler_POJO;
import info.utilities.ExcelReader;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.BranchScheduler_POJO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeScheduler extends Reusableclass
{

	EmployeeAllocation_POJO eap;
	BranchScheduler_POJO bsp;
	AutoshiftNew_POJO asp;
	EmployeeScheduler_POJO esp;
	
@Given("User is on employee scheduler screen")
public void user_is_on_employee_scheduler_screen() 
{
	asp=new AutoshiftNew_POJO();
	esp=new EmployeeScheduler_POJO();
	
	
	//Explicit Wait for Shift Setting Menu
	WebDriverWait wait1 = new WebDriverWait(driver,100);
	wait1.until(ExpectedConditions.elementToBeClickable(asp.Shiftsetting));
	mouseOver(asp.Shiftsetting);

	//Explicit Wait for Employee Schedule Menu
	WebDriverWait wait2 = new WebDriverWait(driver,100);
	wait2.until(ExpectedConditions.elementToBeClickable(esp.EmployeeSchedulerMenu));
	toClick(esp.EmployeeSchedulerMenu);
}

@When("User filtered the employee and edited the details {string} and {int}")
public void user_filtered_the_employee_and_edited_the_details_and(String Sheet4, Integer RowNumber) throws InvalidFormatException, IOException, AWTException 
{
		//Passing Page Object & Driver
		esp=new EmployeeScheduler_POJO();
		
		//Reading Excel Data
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> EmpSchedulerData=reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",Sheet4);
	
		String EmployeeName=EmpSchedulerData.get(RowNumber).get("Employee Name");
		
		System.out.println(EmployeeName);
		//Explicit Wait for Employee Text Box
		WebDriverWait wait3 = new WebDriverWait(driver,100);
		wait3.until(ExpectedConditions.elementToBeClickable(esp.EmployeeText));
		actionssendkeysdelete(esp.EmployeeText);
		tofill(esp.EmployeeText, EmployeeName);
		
		//Explicit Wait for Employee Search
		WebDriverWait wait4 = new WebDriverWait(driver,100);
		wait4.until(ExpectedConditions.elementToBeClickable(esp.EmployeeSearch));
		toClick(esp.EmployeeSearch);
		
		
		//Explicit Wait for Employee Edit
		WebDriverWait wait5 = new WebDriverWait(driver,100);
		wait5.until(ExpectedConditions.elementToBeClickable(esp.EmployeeEdit));
		toClick(esp.EmployeeEdit);
	
}

@Then("User enter the from and to date and create the schedule {string} and {int}")
public void user_enter_the_from_and_to_date_and_create_the_schedule_and(String Sheet4, Integer RowNumber) throws InvalidFormatException, IOException, AWTException, InterruptedException 
{
			//Passing Page Object & Driver
			esp=new EmployeeScheduler_POJO();
			
			//Reading Excel Data
			ExcelReader reader=new ExcelReader();
			List<Map<String,String>> EmpSchedulerData=reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",Sheet4);

			//Effective From
			String From=EmpSchedulerData.get(RowNumber).get("Effective From");
			actionssendkeysdelete(esp.FromDate);
			tofill(esp.FromDate, From);
			toenter();
			
			//Effective To
			String To=EmpSchedulerData.get(RowNumber).get("Effective To");
			actionssendkeysdelete(esp.ToDate);
			tofill(esp.ToDate, To);
			toenter();
			
			//Generate Scheduler
			toClick(esp.GenerateScheduler);
			
			//Alert Pop-Up
			driver.switchTo().alert().accept();
			
			Thread.sleep(2000);
			//toClick(esp.ShiftDropDown);
			mouseclick(esp.ShiftDropDown);
			
			//Explicit Wait for Shift Setting Menu
			WebDriverWait wait6 = new WebDriverWait(driver,100);
			wait6.until(ExpectedConditions.elementToBeClickable(asp.Shiftsetting));
			mouseOver(asp.Shiftsetting);

			//Explicit Wait for Employee Schedule Menu
			WebDriverWait wait7 = new WebDriverWait(driver,100);
			wait7.until(ExpectedConditions.elementToBeClickable(esp.EmployeeSchedulerMenu));
			toClick(esp.EmployeeSchedulerMenu);
			
			String Path="C:\\Users\\Sheik Mohammed\\Desktop\\Majulah Work Details\\Documents\\ImportExcels\\ImportSchedule.xlsx";
			
			 WebElement uploadElement = driver.findElement(By.id("ContentPlaceHolder1_FileUploadControl"));
			 
			 uploadElement.sendKeys(Path);
			 
			 toClick(esp.Import);
}
    
	
}
