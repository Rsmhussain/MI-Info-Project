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
import info.pojo.ImportStaffProfile_POJO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ImportStaffProfile extends Reusableclass
{
	ImportStaffProfile_POJO Isp;

	//ContentPlaceHolder1_fileUpload
	
	@Given("User is on import staff profile page")
	public void user_is_on_import_staff_profile_page() 
	{
		mouseOver(Isp.MasterMenu);
		toClick(Isp.EmpImportProfileMenu);
	    
	}

	@When("Importing the excel file in to the system")
	public void importing_the_excel_file_in_to_the_system() 
	{
	   
	}
	
	
}
