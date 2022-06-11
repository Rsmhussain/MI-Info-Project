package info.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import info.base.Reusableclass;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.Dutyroster_New_POJO;
import info.pojo.User_POJO;
import info.pojo.EmployeeAllocation_POJO;
import info.pojo.BranchScheduler_POJO;
import info.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BranchSchedule extends Reusableclass
{
	EmployeeAllocation_POJO eap;
	BranchScheduler_POJO bsp;
	AutoshiftNew_POJO asp;

@Given("User is on branch schedule screen")
public void user_is_on_branch_schedule_screen() 
{
	
	bsp=new BranchScheduler_POJO();
	asp=new AutoshiftNew_POJO();
	eap=new EmployeeAllocation_POJO();
	
	//Explicit Wait for Shift Setting Menu
	WebDriverWait wait1 = new WebDriverWait(driver,100);
	wait1.until(ExpectedConditions.elementToBeClickable(asp.Shiftsetting));
	mouseOver(asp.Shiftsetting);

	//Explicit Wait for Branch Setup Menu
	WebDriverWait wait2 = new WebDriverWait(driver,100);
	wait2.until(ExpectedConditions.elementToBeClickable(eap.BranchSetupMenu));
	mouseOver(eap.BranchSetupMenu);

	//Explicit Wait for Branch Scheduler Menuṭ
	WebDriverWait wait3 = new WebDriverWait(driver,100);
	wait3.until(ExpectedConditions.elementToBeClickable(bsp.BranchScheduleMenu));
	mouseclick(bsp.BranchScheduleMenu);
	
}

@When("User choosed the branch and future date {string} and {int}")
public void user_choosed_the_branch_and_future_date_and(String Sheet3, Integer RowNumber) throws InvalidFormatException, IOException, AWTException  
{
	
	//Passing Page Object & Driver
	bsp=new BranchScheduler_POJO();
	
	//Reading Excel Data
	ExcelReader reader=new ExcelReader();
	List<Map<String,String>> BranchData=reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",Sheet3);
	
	//Branch Selection
	String Branch=BranchData.get(RowNumber).get("Branch");
	
	//Explicit Wait for Branch DropDown
	WebDriverWait wait4 = new WebDriverWait(driver,100);
	wait4.until(ExpectedConditions.elementToBeClickable(bsp.Branch));
	toselectbyvisibletext(bsp.Branch,Branch);
	
	//Effective From Date
	String From=BranchData.get(RowNumber).get("Effective From");
	
	//Explicit Wait for From Date
	WebDriverWait wait5 = new WebDriverWait(driver,100);
	wait5.until(ExpectedConditions.elementToBeClickable(bsp.FromDate));
	actionssendkeysdelete(bsp.FromDate);
	tofill(bsp.FromDate, From);
	toenter();
	
	//Effective To Date
	String To=BranchData.get(RowNumber).get("Effective To");
	
	//Explicit Wait for From Date
	WebDriverWait wait6 = new WebDriverWait(driver,100);
	wait6.until(ExpectedConditions.elementToBeClickable(bsp.ToDate));
	actionssendkeysdelete(bsp.ToDate);
	tofill(bsp.ToDate, To);
	toenter();
	
}

@Then("User create schedule for the branch")
public void user_create_schedule_for_the_branch() throws InterruptedException 
{
	//Passing Page Object & Driver
	bsp=new BranchScheduler_POJO();
	
	//Explicit Wait for From Date
	WebDriverWait wait6 = new WebDriverWait(driver,100);
	wait6.until(ExpectedConditions.elementToBeClickable(bsp.GenerateSchedule));

	toClick(bsp.GenerateSchedule);
	
	driver.switchTo().alert().accept();
	

	//Select Dropdown
	
	/*ContentPlaceHolder1_btnNextWeek
	
	WebElement DD3=driver.findElement(By.id("ContentPlaceHolder1_gvWeeklySchedule_Shift_WD3_0"));
	WebElement DD4=driver.findElement(By.id("ContentPlaceHolder1_gvWeeklySchedule_Shift_WD4_0"));
	WebElement DD5=driver.findElement(By.id("ContentPlaceHolder1_gvWeeklySchedule_Shift_WD5_0"));
	
	toselectbyvisibletext(DD3, "None");
	toselectbyvisibletext(DD3, "SC01");
	toselectbyvisibletext(DD3, "SC01");*/
}

	
}
