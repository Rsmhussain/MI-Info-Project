package info.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import info.base.Reusableclass;
import info.pojo.EmployeeAllocation_POJO;
import info.pojo.User_POJO;
import info.utilities.ExcelReader;
import info.pojo.AutoshiftNew_POJO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeAllocation extends Reusableclass
{
	User_POJO usp;
	EmployeeAllocation_POJO eap;
	AutoshiftNew_POJO asp;
	
	@Given("User is on employee allocation screen")
	public void user_is_on_employee_allocation_screen() 
	{
		
		try 
		{
			
		eap=new EmployeeAllocation_POJO();
		asp=new AutoshiftNew_POJO();
			
		//Explicit Wait for Shift Setting Menu
		WebDriverWait wait1 = new WebDriverWait(driver,100);
		wait1.until(ExpectedConditions.elementToBeClickable(asp.Shiftsetting));
		mouseOver(asp.Shiftsetting);
		
		//Explicit Wait for Branch Setup Menu
		WebDriverWait wait2 = new WebDriverWait(driver,100);
		wait2.until(ExpectedConditions.elementToBeClickable(eap.BranchSetupMenu));
		mouseOver(eap.BranchSetupMenu);
		
		//Explicit Wait for Employee Allocation Menu
		WebDriverWait wait3 = new WebDriverWait(driver,100);
		wait3.until(ExpectedConditions.elementToBeClickable(eap.EmpAllocationMenu));
		//clickbymouse(eap.EmpAllocationMenu);
		mouseclick(eap.EmpAllocationMenu);
	
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	   
	}

	@When("User creating the new employee allocation for the branch {string} and {int}")
	public void user_creating_the_new_employee_allocation_for_the_branch(String Sheet2, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException, AWTException 
	{
//	   try
//	   {
		   ExcelReader reader=new ExcelReader();
		   eap=new EmployeeAllocation_POJO();
		   
		   List<Map<String,String>> EmpAllocationData=reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet2);
		   String DepName=EmpAllocationData.get(RowNumber).get("Department");
		   
	   
		   //clickjavascript(eap.DepDropDown);
	
		   
		   //Explicit Wait for Department Drop Down
		   mouseclick(eap.DepDropDownbtn);
		   actionssendkeysdelete(eap.DepDropDown);
		   WebDriverWait wait3 = new WebDriverWait(driver,100);
		   wait3.until(ExpectedConditions.elementToBeClickable(eap.DepDropDown));
		   Thread.sleep(2000);
		   tofill(eap.DepDropDown, DepName);
		   Thread.sleep(1000);
		   todown();
		   toenter();
		   System.out.println("Drop Down Selected");
		   
		   
		   //Explicit Wait for Section Drop Down
		   Thread.sleep(2000);
		   toClick(eap.SecDropDownbtn);
		   actionssendkeysdelete(eap.SecDropDown);
		   
		   String SecDropDown=EmpAllocationData.get(RowNumber).get("Section");
		   
		   WebDriverWait wait4 = new WebDriverWait(driver,100);
		   wait4.until(ExpectedConditions.elementToBeClickable(eap.SecDropDown));
		   Thread.sleep(1000);
		   tofill(eap.SecDropDown, SecDropDown);
		   Thread.sleep(1000);
		   todown();
		   toenter();
		   
		   System.out.println("Section Drop Down Selected");
		   
		   //Explicit Wait for Employee Search
		   Thread.sleep(1000);
		   String Employee=EmpAllocationData.get(RowNumber).get("Employee");
		   WebDriverWait wait5 = new WebDriverWait(driver,100);
		   wait5.until(ExpectedConditions.elementToBeClickable(eap.empTextBox));
		   Thread.sleep(2000);
		   tofill(eap.empTextBox, Employee);
		   Thread.sleep(2000);
		   //mouseclick(eap.empSearch1);
		   toClick(eap.empSearch);
		   
		   System.out.println("Employee Selected");
		   
		   Thread.sleep(2000); 
		   //Check the employee check box
		   eap.allempCheckbox.click();
		   
		   eap.allempCheckbox.isSelected();
		   {
		   
		   //Explicit Wait for Branch Drop Down
		   String branch=EmpAllocationData.get(RowNumber).get("Branch");
		   System.out.println(branch);
		   Thread.sleep(1000);   
		   toClick(eap.BrnDropDownbtn);
		   actionssendkeysdelete(eap.BrnDropDown);
		   
		   WebDriverWait wait6 = new WebDriverWait(driver,100);
		   wait6.until(ExpectedConditions.elementToBeClickable(eap.BrnDropDown));
		   //Thread.sleep(2000);
		   toClick(eap.BrnDropDown);
		   Thread.sleep(2000);	
		   tofill(eap.BrnDropDown, branch);
		   Thread.sleep(2000);
		   todown();
		   toenter();
		   System.out.println("Branch Selected");
		   
		   }
		  	   
//	   }
//	   catch(Exception e2)
//	   {
//		  e2.printStackTrace();
//	   }
	   
	}

	@Then("User should validate and save the employee allocation record")
	public void user_should_validate_and_save_the_employee_allocation_record() 
	{	
		try
		{
			eap=new EmployeeAllocation_POJO();
			
			//Explicit Wait for Department Drop Down
			WebDriverWait wait7 = new WebDriverWait(driver,100);
			wait7.until(ExpectedConditions.elementToBeClickable(eap.AssignTo));
			//toClick(eap.AssignTo);
			Thread.sleep(1000);
			clickjavascript(eap.AssignTo);
			Thread.sleep(1000);
			System.out.println("Employee Allocated Successfully");
		}
		catch(Exception e3)
		{
			System.out.println(e3);
		}
		
	}
	

}
