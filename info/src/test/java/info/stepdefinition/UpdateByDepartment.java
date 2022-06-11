package info.stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import info.base.Reusableclass;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.BranchScheduler_POJO;
import info.pojo.EmployeeAllocation_POJO;
import info.pojo.EmployeeScheduler_POJO;
import info.pojo.UpdateByDepartment_POJO;
import info.pojo.UpdateByIndividual_POJO;

import info.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateByDepartment extends Reusableclass 
{
	UpdateByIndividual_POJO uip;
	UpdateByDepartment_POJO udp;

	@Given("User is on Update By Individual")
	public void user_is_on_update_by_individual() 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		
		System.out.println("Driver Status : "+driver);
		System.out.println(driver instanceof WebDriver);
		
		mouseOver(uip.TransactionMenu);

		// Explicit Wait for UpdateByIndividualMenu
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(uip.UpdateByIndividualMenu));
		toClick(uip.UpdateByIndividualMenu);

	}

	@When("User Creating Missing Date {string} and {int}")
	public void user_creating_missing_date_and(String Sheet5, Integer RowNumber)
			throws InvalidFormatException, IOException 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet5);
		
		try {
			
			// Explicit Wait for Employee
			String EmployeeName = UBDData.get(RowNumber).get("Employee Name");
			WebDriverWait wait2 = new WebDriverWait(driver, 100);
			wait2.until(ExpectedConditions.elementToBeClickable(uip.Employee));
			actionssendkeysdelete(uip.Employee);
			tofill(uip.Employee, EmployeeName);
			todown();
			toenter();

			// Explicit Wait for From Date
			String FromDate = UBDData.get(RowNumber).get("Effective From");
			WebDriverWait wait3 = new WebDriverWait(driver, 100);
			wait3.until(ExpectedConditions.elementToBeClickable(uip.FromDate));
			Thread.sleep(500);
			actionssendkeysdelete(uip.FromDate);
			Thread.sleep(500);
			tofill(uip.FromDate, FromDate);
			toenter();

			// Explicit Wait for To Date
			String ToDate = UBDData.get(RowNumber).get("Effective To");
			WebDriverWait wait4 = new WebDriverWait(driver, 100);
			wait4.until(ExpectedConditions.elementToBeClickable(uip.ToDate));
			Thread.sleep(500);
			actionssendkeysdelete(uip.ToDate);
			Thread.sleep(500);
			tofill(uip.ToDate, ToDate);
			toenter();
			
			// Click Search
			Thread.sleep(1000);
			toClick(uip.Search);

			// Click Missing Date
			// Explicit Wait for Missing Date
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(uip.MissingDate));
			toClick(uip.MissingDate);

			Thread.sleep(2000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		System.out.println("Missing Date Created Successfully in Update By Individual \n");
	}

	@Given("User doing employee prerequisites {string} and {int}")
	public void user_doing_employee_prerequisites_and(String Sheet6, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet6);

		//=================================== Employee Prerequisites ===================================//
		
		// Explicit Wait for Master
		WebDriverWait wait21 = new WebDriverWait(driver, 100);
		wait21.until(ExpectedConditions.elementToBeClickable(uip.Master));
		mouseOver(uip.Master);

		WebDriverWait wait22 = new WebDriverWait(driver, 100);
		wait22.until(ExpectedConditions.elementToBeClickable(uip.BasicEmployeeMaster));
		toClick(uip.BasicEmployeeMaster);

		// Explicit Wait for Employee
		String EmployeeNameMaster = UBDData.get(RowNumber).get("Employee Name");
		WebDriverWait wait23 = new WebDriverWait(driver, 100);
		wait23.until(ExpectedConditions.elementToBeClickable(uip.EmpSrchTxt));
		actionssendkeysdelete(uip.EmpSrchTxt);
		tofill(uip.EmpSrchTxt, EmployeeNameMaster);

		WebDriverWait wait24 = new WebDriverWait(driver, 100);
		wait24.until(ExpectedConditions.elementToBeClickable(uip.EmpSrchButton));
		toClick(uip.EmpSrchButton);

		Thread.sleep(3000);
		WebDriverWait wait25 = new WebDriverWait(driver, 100);
		wait25.until(ExpectedConditions.elementToBeClickable(uip.EmpEditButton));
		toClick(uip.EmpEditButton);

		String PartOrFlexi = UBDData.get(RowNumber).get("EmpPartOrFlexi");

		// Change nature of employee to Null
		Thread.sleep(2000);
		WebDriverWait wait31 = new WebDriverWait(driver, 100);
		wait31.until(ExpectedConditions.elementToBeClickable(uip.DllPartFlexi));
		toselectbyvisibletext(uip.DllPartFlexi, PartOrFlexi);

		Scrolldownjavascript();

		/*Thread.sleep(2000);
		WebDriverWait wait26 = new WebDriverWait(driver, 100);
		wait26.until(ExpectedConditions.elementToBeClickable(uip.EmpUpdateBtn));
		toClick(uip.EmpUpdateBtn);*/

		Thread.sleep(2000);
		Scrollupjavascript();

		System.out.println("General Section Updated");

		// Click Edit
		/*Thread.sleep(2000);
		WebDriverWait wait27 = new WebDriverWait(driver, 100);
		wait27.until(ExpectedConditions.elementToBeClickable(uip.EmpEditButton));
		toClick(uip.EmpEditButton);*/

		// Click TMS Tab
		Thread.sleep(2000);
		WebDriverWait wait28 = new WebDriverWait(driver, 100);
		wait28.until(ExpectedConditions.elementToBeClickable(uip.EmpTMSTab));
		toClick(uip.EmpTMSTab);

		String OTType = UBDData.get(RowNumber).get("EmpOT Type");

		// Change the employee OT Type to Felxi and Rate
		WebDriverWait wait32 = new WebDriverWait(driver, 100);
		wait32.until(ExpectedConditions.elementToBeClickable(uip.DllOTType));
		toselectbyvisibletext(uip.DllOTType, OTType);

		/*
		 * String FlexiRate=UBIData.get(RowNumber).get("PartOrFlexi Rate");
		 * WebDriverWait wait33 = new WebDriverWait(driver,100);
		 * wait33.until(ExpectedConditions.elementToBeClickable(uip.flatrate));
		 * tofill(uip.flatrate, FlexiRate);
		 */

		// Change the employee Shift
		String EmpShift = UBDData.get(RowNumber).get("Emp Shift");
		WebDriverWait wait29 = new WebDriverWait(driver, 100);
		wait29.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'" + EmpShift + "')]")));

		driver.findElement(By.xpath("//option[contains(text(),'" + EmpShift + "')]")).click();

		Scrolldownjavascript();

		Thread.sleep(1000);
		WebDriverWait wait30 = new WebDriverWait(driver, 100);
		wait30.until(ExpectedConditions.elementToBeClickable(uip.EmpUpdateBtn));
		toClick(uip.EmpUpdateBtn);

		Scrollupjavascript();

		System.out.println("TMS Section Updated");
		
	}
	
	
	@When("User Entering the Clockin details for OT scenario in Update By Department screen {string} and {int}")
	public void user_entering_the_clockin_details_for_ot_scenario_in_update_by_department_screen_and(String Sheet7, Integer RowNumber)
			throws InvalidFormatException, IOException, AWTException, InterruptedException 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

		//=================================== User Interacting the Update By Department Screen ===================================//
		
		mouseOver(udp.TransactionMenu);
		
		// Explicit Wait for UpdateByDepartmentMenu
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
		toClick(udp.UpdateByDepartmentMenu);
		
		// Explicit Wait for Employee
		String DepartmentName = UBDData.get(RowNumber).get("Department Name");
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
		actionssendkeysdelete(udp.UBDEmployee);
		tofill(udp.UBDEmployee, DepartmentName);
		todown();
		toenter();

		Thread.sleep(1000);
		// Explicit Wait for From Date
		String FromDate = UBDData.get(RowNumber).get("Effective From");
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
		Thread.sleep(500);
		actionssendkeysdelete(udp.UBDFromDate);
		Thread.sleep(500);
		tofill(udp.UBDFromDate, FromDate);
		toenter();

		// Click Search
		Thread.sleep(1000);
		toClick(udp.UBDbtnSearch);

		// ================== Row 1 -  Insertion OT Scenario =========================== //	
		
		Thread.sleep(1000);
		
		String In=UBDData.get(RowNumber).get("In1");
		String Out=UBDData.get(RowNumber).get("Out1");
		String Shift=UBDData.get(RowNumber).get("Shfit1");
		String Reason=UBDData.get(RowNumber).get("Reason1");
		
		// Explicit Wait for Clock In
		WebDriverWait wait4 = new WebDriverWait(driver, 100);
		wait4.until(ExpectedConditions.elementToBeClickable(udp.UBDClockIn));
		Thread.sleep(2000);
		actionssendkeysdelete(udp.UBDClockIn);
		WebElement ClockIntxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
		actionssendkeysdelete(ClockIntxt1);
		Thread.sleep(1000);
		tofill(ClockIntxt1, In);
		Thread.sleep(1000);
		
		// toenter();
		totabkey();
		System.out.println("Clockin Enterted");

		// Explicit Wait for Clock Out
		WebDriverWait wait6 = new WebDriverWait(driver, 100);
		wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDClockOut));
		Thread.sleep(2000);
		actionssendkeysdelete(udp.UBDClockOut);
		WebElement ClockOuttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
		actionssendkeysdelete(ClockOuttxt1);
		Thread.sleep(1000);
		tofill(ClockOuttxt1, Out);
		Thread.sleep(1000);
		totabkey();

		// Explicit Wait for shift
		WebDriverWait wait7 = new WebDriverWait(driver, 100);
		wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDShift));
		Thread.sleep(2000);
		actionssendkeysdelete(udp.UBDShift);
		WebElement Shifttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
		actionssendkeysdelete(Shifttxt1);
		Thread.sleep(1000);
		tofill(Shifttxt1, Shift);
		Thread.sleep(1000);
		totabkey();

		// Explicit Wait for Reason
		WebDriverWait wait8 = new WebDriverWait(driver, 100);
		wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDReason));
		Thread.sleep(2000);
		actionssendkeysdelete(udp.UBDReason);
		WebElement Reasontxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
		actionssendkeysdelete(Reasontxt1);
		Thread.sleep(1000);
		tofill(Reasontxt1, Reason);
		Thread.sleep(1000);
		totabkey();
		
	}

	@Then("User Recalculate the attendance Scenario {string} and {int}")
	public void user_recalculate_the_attendance_scenario_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException 
	{
		
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

		//Recalculate the attendance
		
		Thread.sleep(2000);
		//Explicit Wait for Master
		WebDriverWait wait31 = new WebDriverWait(driver, 100);
		wait31.until(ExpectedConditions.elementToBeClickable(uip.UtilityMenu));
		mouseOver(uip.UtilityMenu);

		WebDriverWait wait32 = new WebDriverWait(driver, 100);
		wait32.until(ExpectedConditions.elementToBeClickable(uip.RecalculateAttendanceMenu));
		toClick(uip.RecalculateAttendanceMenu);

		// Explicit Wait for From Date
		String RAFromDate = UBDData.get(RowNumber).get("UBIEffective From");
		WebDriverWait wait33 = new WebDriverWait(driver, 100);
		wait33.until(ExpectedConditions.elementToBeClickable(uip.RAFromDate));
		Thread.sleep(500);
		actionssendkeysdelete(uip.RAFromDate);
		Thread.sleep(500);
		tofill(uip.RAFromDate, RAFromDate);
		toenter();

		// Explicit Wait for To Date
		String RAToDate = UBDData.get(RowNumber).get("UBIEffective To");
		WebDriverWait wait34 = new WebDriverWait(driver, 100);
		wait34.until(ExpectedConditions.elementToBeClickable(uip.RAToDate));
		Thread.sleep(500);
		actionssendkeysdelete(uip.RAToDate);
		Thread.sleep(500);
		tofill(uip.RAToDate, RAToDate);
		toenter();

		// Explicit Wait for RA Employee
		String RAEmployeeName = UBDData.get(RowNumber).get("UBIEmployee Name");
		WebDriverWait wait35 = new WebDriverWait(driver, 100);
		wait35.until(ExpectedConditions.elementToBeClickable(uip.RAEmpSearchTxt));
		tofill(uip.RAEmpSearchTxt, RAEmployeeName);
		Thread.sleep(500);
		toClick(uip.RAEmpSearchBtn);
		Thread.sleep(3000);
		WebDriverWait wait36 = new WebDriverWait(driver, 100);
		wait36.until(ExpectedConditions.elementToBeClickable(uip.RAEmpChkBox));
		uip.RAEmpChkBox.click();
		Scrolldownjavascript();
		Thread.sleep(2000);
		WebDriverWait wait37 = new WebDriverWait(driver, 100);
		wait37.until(ExpectedConditions.elementToBeClickable(uip.RARecalcualte));
		toClick(uip.RARecalcualte);
		Thread.sleep(4000);
		System.out.println("Recalculate the Attendance Done");
		Scrollupjavascript();
		
	}

	@Then("User Verify the OT Scenario changes in Update By Department screen {string} and {int}")
	public void user_verify_the_ot_scenario_changes_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

		mouseOver(udp.TransactionMenu);

		// Explicit Wait for UpdateByDepartmentMenu
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
		toClick(udp.UpdateByDepartmentMenu);
		
		// Explicit Wait for Employee
		String DepartmentName = UBDData.get(RowNumber).get("Department Name");
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
		actionssendkeysdelete(udp.UBDEmployee);
		tofill(udp.UBDEmployee, DepartmentName);
		todown();
		toenter();

		// Explicit Wait for From Date
		String FromDate = UBDData.get(RowNumber).get("Effective From");
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
		Thread.sleep(500);
		actionssendkeysdelete(udp.UBDFromDate);
		Thread.sleep(500);
		tofill(udp.UBDFromDate, FromDate);
		toenter();

		// Click Search
		Thread.sleep(1000);
		toClick(udp.UBDbtnSearch);
		Thread.sleep(1000);
		// OT10   Verification ==>  1
		String OT101Exp = "2:00";
		Thread.sleep(3000);
		WebDriverWait wait6 = new WebDriverWait(driver, 100);
		wait6.until(ExpectedConditions.elementToBeClickable(uip.OT101));
		toClick(uip.OT101);

		WebElement OT101 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[16]"));
		String OT101Act = OT101.getText();

		System.out.println("OT10 : Expected: " + OT101Exp + " Actual: " + OT101Act);

		//Soft Validation OT10
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(OT101Exp, OT101Act);

		// OT15 Verification ==> 2
		String OT151Exp = "1:00";
		Thread.sleep(3000);
		WebDriverWait wait7 = new WebDriverWait(driver, 100);
		wait7.until(ExpectedConditions.elementToBeClickable(uip.OT151));
		toClick(uip.OT151);

		WebElement OT151 = driver
				.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[17]"));
		String OT151Act = OT151.getText();

		System.out.println("OT15 : Expected: " + OT151Exp + " Actual: " + OT151Act);

		soft.assertEquals(OT151Exp, OT151Act);
		
		//Scroll Right
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		WebElement myElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf
		(driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[28]"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
		a.moveToElement(myElement).build().perform();

		// Meal Allowance Verification ==> 7
		String MealAwl1Exp = "100.00";
		Thread.sleep(500);
		WebElement MealAwl = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[24]"));

		String MealAwl1Act = MealAwl.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", MealAwl);
		a.moveToElement(MealAwl).click().build().perform();
		Thread.sleep(5000);
		System.out.println("Meal Allowance : Expected: " + MealAwl1Exp + " Actual: " + MealAwl1Act);

		soft.assertEquals(MealAwl1Exp, MealAwl1Act);
		totabkey();

		// Transport Allowance Verification ==> 8
		String TransportAwl1Exp = "150.00";
		Thread.sleep(500);
		WebElement TransportAwl = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[25]"));

		String TransportAwlAct = TransportAwl.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", TransportAwl);
		a.moveToElement(TransportAwl).click().build().perform();
		System.out.println("Transport Allowance : Expected: " + TransportAwl1Exp + " Actual: " + TransportAwlAct);

		soft.assertEquals(TransportAwl1Exp, TransportAwlAct);

		// Health Allowance Verification ==> 9
		String HealthAwl1Exp = "250.00";
		Thread.sleep(500);
		WebElement HealthAwl = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]"));

		String HealthAwlAct = HealthAwl.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", HealthAwl);
		a.moveToElement(HealthAwl).click().build().perform();
		System.out.println("Health Allowance : Expected: " + HealthAwl1Exp + " Actual: " + HealthAwlAct);
		soft.assertEquals(HealthAwl1Exp, HealthAwlAct);

		// Other1 Allowance Verification ==> 10
		String Other1Awl1Exp = "150.00";
		Thread.sleep(500);
		WebElement Other1Awl = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[27]"));

		String OtherAwl1Act = Other1Awl.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Other1Awl);
		a.moveToElement(Other1Awl).click().build().perform();
		System.out.println("Other Allowance : Expected: " + Other1Awl1Exp + " Actual: " + OtherAwl1Act);
		soft.assertEquals(Other1Awl1Exp, OtherAwl1Act);
		
		// Other2 Allowance Verification ==> 10
		String Other2Awl1Exp = "150.00";
		Thread.sleep(500);
		WebElement Other2Awl = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[28]"));

		String Other2Awl1Act = Other2Awl.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Other2Awl);
		a.moveToElement(Other2Awl).click().build().perform();
		System.out.println("Other Allowance : Expected: " + Other2Awl1Exp + " Actual: " + Other2Awl1Act);
		soft.assertEquals(Other2Awl1Exp, Other2Awl1Act);
		
		System.out.println("Post Recalculated Attendance Update By Department OT Scenario Verification Completed");
		
		Scrollupjavascript();
	}
	
	@Then("User changing Shift and OT type in employee master {string} and {int}")
	public void user_changing_shift_and_ot_type_in_employee_master_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException 
	{
		
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);
		
		
		// Explicit Wait for Master
		WebDriverWait wait21 = new WebDriverWait(driver, 100);
		wait21.until(ExpectedConditions.elementToBeClickable(uip.Master));
		mouseOver(uip.Master);

		WebDriverWait wait22 = new WebDriverWait(driver, 100);
		wait22.until(ExpectedConditions.elementToBeClickable(uip.BasicEmployeeMaster));
		toClick(uip.BasicEmployeeMaster);

		// Explicit Wait for Employee
		String EmployeeNameMaster = UBDData.get(RowNumber).get("UBIEmployee Name");
		WebDriverWait wait23 = new WebDriverWait(driver, 100);
		wait23.until(ExpectedConditions.elementToBeClickable(uip.EmpSrchTxt));
		actionssendkeysdelete(uip.EmpSrchTxt);
		tofill(uip.EmpSrchTxt, EmployeeNameMaster);

		WebDriverWait wait24 = new WebDriverWait(driver, 100);
		wait24.until(ExpectedConditions.elementToBeClickable(uip.EmpSrchButton));
		toClick(uip.EmpSrchButton);

		Thread.sleep(3000);
		WebDriverWait wait25 = new WebDriverWait(driver, 100);
		wait25.until(ExpectedConditions.elementToBeClickable(uip.EmpEditButton));
		toClick(uip.EmpEditButton);

		String PartOrFlexi = UBDData.get(RowNumber).get("PartOrFlexi");

		// Change nature of employee to flexi instead of Null
		Thread.sleep(2000);
		WebDriverWait wait31 = new WebDriverWait(driver, 100);
		wait31.until(ExpectedConditions.elementToBeClickable(uip.DllPartFlexi));
		toselectbyvisibletext(uip.DllPartFlexi, PartOrFlexi);
		
		Thread.sleep(2000);
		Scrolldownjavascript();

		/*Thread.sleep(2000);
		WebDriverWait wait26 = new WebDriverWait(driver, 100);
		wait26.until(ExpectedConditions.elementToBeClickable(uip.EmpUpdateBtn));
		toClick(uip.EmpUpdateBtn);

		Thread.sleep(2000);
		Scrollupjavascript();*/

		System.out.println("General Section Updated");

		// Click Edit
	/*	Thread.sleep(2000);
		WebDriverWait wait27 = new WebDriverWait(driver, 100);
		wait27.until(ExpectedConditions.elementToBeClickable(uip.EmpEditButton));
		toClick(uip.EmpEditButton);*/

		// Click TMS Tab
		Thread.sleep(2000);
		WebDriverWait wait28 = new WebDriverWait(driver, 100);
		wait28.until(ExpectedConditions.elementToBeClickable(uip.EmpTMSTab));
		toClick(uip.EmpTMSTab);

		String OTType = UBDData.get(RowNumber).get("OT Type");
		Thread.sleep(2000);
		// Change the employee OT Type to Felxi and Rate
		WebDriverWait wait32 = new WebDriverWait(driver, 100);
		wait32.until(ExpectedConditions.elementToBeClickable(uip.DllOTType));
		toselectbyvisibletext(uip.DllOTType, OTType);

		
		String FlexiRate=UBDData.get(RowNumber).get("PartOrFlexi Rate");
		WebDriverWait wait33 = new WebDriverWait(driver,100);
		wait33.until(ExpectedConditions.elementToBeClickable(uip.flatrate));
		tofill(uip.flatrate, FlexiRate);
		

		// Change the employee Shift
		/*String EmpShift = UBDData.get(RowNumber).get("Shift");
		WebDriverWait wait29 = new WebDriverWait(driver, 100);
		wait29.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'" + EmpShift + "')]")));

		driver.findElement(By.xpath("//option[contains(text(),'" + EmpShift + "')]")).click();*/

		Scrolldownjavascript();
		Thread.sleep(2000);
		
		WebDriverWait wait30 = new WebDriverWait(driver, 100);
		wait30.until(ExpectedConditions.elementToBeClickable(uip.EmpUpdateBtn));
		toClick(uip.EmpUpdateBtn);

		Scrollupjavascript();

		System.out.println("TMS Section Updated");
	    
	}

	@Then("After Changing the employee settings User Viewing the changes in Update By Department Screen {string} and {int}")
	public void after_changing_the_employee_settings_user_viewing_the_changes_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, IOException, AWTException, InterruptedException 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

		mouseOver(udp.TransactionMenu);

		// Explicit Wait for UpdateByDepartmentMenu
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
		toClick(udp.UpdateByDepartmentMenu);
		
		// Explicit Wait for Employee
		String DepartmentName = UBDData.get(RowNumber).get("Department Name");
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
		actionssendkeysdelete(udp.UBDEmployee);
		tofill(udp.UBDEmployee, DepartmentName);
		todown();
		toenter();

		// Explicit Wait for From Date
		String FromDate = UBDData.get(RowNumber).get("Effective From");
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
		Thread.sleep(500);
		actionssendkeysdelete(udp.UBDFromDate);
		Thread.sleep(500);
		tofill(udp.UBDFromDate, FromDate);
		toenter();

		// Click Search
		Thread.sleep(1000);
		toClick(udp.UBDbtnSearch);
		Thread.sleep(2000);
	}


@Then("User doing purge and reprocess activity {string} and {int}")
public void user_doing_purge_and_reprocess_activity_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, IOException, Throwable
{
	uip= new UpdateByIndividual_POJO();
	ExcelReader reader=new ExcelReader();
	
	List<Map<String,String>> UBDData=reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",Sheet7);

	//UBD Screen
	
	mouseOver(udp.TransactionMenu);

	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);
	
	// =========================== Pruge and Reprocess ======================== //

	//Explicit Wait for Master
	WebDriverWait wait71 = new WebDriverWait(driver, 100);
	wait71.until(ExpectedConditions.elementToBeClickable(uip.UtilityMenu));
	mouseOver(uip.UtilityMenu);
		
	// Explicit Wait for Purge And Process Menu
	WebDriverWait wait72 = new WebDriverWait(driver, 100);
	wait72.until(ExpectedConditions.elementToBeClickable(uip.PurgeAndReprocessMenu));
	toClick(uip.PurgeAndReprocessMenu);

	// Explicit Wait for From Date
	String PRFromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait73 = new WebDriverWait(driver, 100);
	wait73.until(ExpectedConditions.elementToBeClickable(uip.PRFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(uip.PRFromDate);
	Thread.sleep(500);
	tofill(uip.PRFromDate, PRFromDate);
	toenter();

	// Explicit Wait for To Date
	String PRToDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait74 = new WebDriverWait(driver, 100);
	wait74.until(ExpectedConditions.elementToBeClickable(uip.PRToDate));
	Thread.sleep(500);
	actionssendkeysdelete(uip.PRToDate);
	Thread.sleep(500);
	tofill(uip.PRToDate, PRToDate);
	toenter();

	// Explicit Wait for PR Employee
	String PREmployeeName = UBDData.get(RowNumber).get("UBIEmployee Name");
	WebDriverWait wait75 = new WebDriverWait(driver, 100);
	wait75.until(ExpectedConditions.elementToBeClickable(uip.PREmpSrchTxt));
	tofill(uip.PREmpSrchTxt, PREmployeeName);
	Thread.sleep(1000);
	WebDriverWait wait76 = new WebDriverWait(driver, 100);
	wait76.until(ExpectedConditions.elementToBeClickable(uip.PREmpSrchBtn));
	toClick(uip.PREmpSrchBtn);

	Thread.sleep(2000);
	WebDriverWait wait77 = new WebDriverWait(driver, 100);
	wait77.until(ExpectedConditions.elementToBeClickable(uip.PRPurgeChkBox));
	uip.PRPurgeChkBox.click();

	Thread.sleep(2000);
	WebDriverWait wait78 = new WebDriverWait(driver, 100);
	wait78.until(ExpectedConditions.elementToBeClickable(uip.PRReprocessChkBox));
	uip.PRReprocessChkBox.click();

	Thread.sleep(2000);
	WebDriverWait wait79 = new WebDriverWait(driver, 100);
	wait79.until(ExpectedConditions.elementToBeClickable(uip.PREmpChkBox));
	uip.PREmpChkBox.click();

	Scrolldownjavascript();

	Thread.sleep(1000);
	WebDriverWait wait40 = new WebDriverWait(driver, 100);
	wait40.until(ExpectedConditions.elementToBeClickable(uip.PRProcessBtn));
	toClick(uip.PRProcessBtn);
	Thread.sleep(3000);
	Scrollupjavascript();
	System.out.println("Purge Reprocess Done");

}

@Then("Post purge and reprocess User viewing the changes in update By Department Screen {string} and {int}")
public void post_purge_and_reprocess_user_viewing_the_changes_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, IOException, Throwable 
{
	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	mouseOver(udp.TransactionMenu);

	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	Thread.sleep(500);
	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);
	Thread.sleep(2000);
	
	System.out.println("OT Scenario Completed");
}
	

@When("User Entering the Clockin details for Late scenario in Update By Department screen {string} and {int}")
public void user_entering_the_clockin_details_for_late_scenario_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, Throwable 
{
	
	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	//=================================== User Interacting the Update By Department Screen ===================================//
	
	mouseOver(udp.TransactionMenu);
	
	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);

	// ================== Row 1 -  Insertion OT Scenario =========================== //	
	
	Thread.sleep(1000);
	
	String In=UBDData.get(RowNumber).get("In1");
	String Out=UBDData.get(RowNumber).get("Out1");
	String Shift=UBDData.get(RowNumber).get("Shfit1");
	String Reason=UBDData.get(RowNumber).get("Reason1");
	
	// Explicit Wait for Clock In
	WebDriverWait wait4 = new WebDriverWait(driver, 100);
	wait4.until(ExpectedConditions.elementToBeClickable(udp.UBDClockIn));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDClockIn);
	WebElement ClockIntxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
	actionssendkeysdelete(ClockIntxt1);
	Thread.sleep(1000);
	tofill(ClockIntxt1, In);
	Thread.sleep(1000);
	
	// toenter();
	totabkey();
	System.out.println("Clockin Enterted");

	// Explicit Wait for Clock Out
	WebDriverWait wait6 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDClockOut));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDClockOut);
	WebElement ClockOuttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
	actionssendkeysdelete(ClockOuttxt1);
	Thread.sleep(1000);
	tofill(ClockOuttxt1, Out);
	Thread.sleep(1000);
	totabkey();

	// Explicit Wait for shift
	WebDriverWait wait7 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDShift));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDShift);
	WebElement Shifttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
	actionssendkeysdelete(Shifttxt1);
	Thread.sleep(1000);
	tofill(Shifttxt1, Shift);
	Thread.sleep(1000);
	totabkey();

	// Explicit Wait for Reason
	WebDriverWait wait8 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDReason));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDReason);
	WebElement Reasontxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
	actionssendkeysdelete(Reasontxt1);
	Thread.sleep(1000);
	tofill(Reasontxt1, Reason);
	Thread.sleep(1000);
	totabkey();
	
	
	
}

@Then("User Verify the Late Scenario changes in Update By Department screen {string} and {int}")
public void user_verify_the_late_scenario_changes_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws Throwable, IOException 
{
	
	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	mouseOver(udp.TransactionMenu);

	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);
	Thread.sleep(1000);
	
	//  Latness Verification ==>  3
	String LatnessExp = "0:50";
	Thread.sleep(500);
	WebDriverWait wait12 = new WebDriverWait(driver, 100);
	wait12.until(ExpectedConditions.elementToBeClickable(udp.Lateness1));
	toClick(udp.Lateness1);
	WebElement Late = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[15]"));

	String LatenessAct = Late.getText();
	System.out.println("Latness : Expected: " + LatnessExp + " Actual: " + LatenessAct);
	//Soft Validation OT10
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(LatnessExp, LatenessAct);
	
	Thread.sleep(500);
	udp.Late.click();
	Thread.sleep(3000);
	udp.Late.click();
	
	System.out.println("Post Recalculated Attendance Update By Department Late Scenario Verification Completed");
	
	Scrollupjavascript();
	
	// Verify the Sort By Drop Down
	WebDriverWait wait32 = new WebDriverWait(driver, 100);
	wait32.until(ExpectedConditions.elementToBeClickable(udp.SortBy));
	toselectbyvisibletext(udp.SortBy, "EmpName");
	
}

	// =========================== Under Scenario ================================== //

@When("User Entering the Clockin details for Under scenario in Update By Department screen {string} and {int}")
public void user_entering_the_clockin_details_for_under_scenario_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, Throwable 
{
	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	//=================================== User Interacting the Update By Department Screen ===================================//
	
	mouseOver(udp.TransactionMenu);
	
	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);

	// ================== Row 1 -  Insertion OT Scenario =========================== //	
	
	Thread.sleep(1000);
	
	String In=UBDData.get(RowNumber).get("In1");
	String Out=UBDData.get(RowNumber).get("Out1");
	String Shift=UBDData.get(RowNumber).get("Shfit1");
	String Reason=UBDData.get(RowNumber).get("Reason1");
	
	// Explicit Wait for Clock In
	WebDriverWait wait4 = new WebDriverWait(driver, 100);
	wait4.until(ExpectedConditions.elementToBeClickable(udp.UBDClockIn));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDClockIn);
	WebElement ClockIntxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
	actionssendkeysdelete(ClockIntxt1);
	Thread.sleep(1000);
	tofill(ClockIntxt1, In);
	Thread.sleep(1000);
	
	// toenter();
	totabkey();
	System.out.println("Clockin Enterted");

	// Explicit Wait for Clock Out
	WebDriverWait wait6 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDClockOut));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDClockOut);
	WebElement ClockOuttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
	actionssendkeysdelete(ClockOuttxt1);
	Thread.sleep(1000);
	tofill(ClockOuttxt1, Out);
	Thread.sleep(1000);
	totabkey();

	// Explicit Wait for shift
	WebDriverWait wait7 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDShift));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDShift);
	WebElement Shifttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
	actionssendkeysdelete(Shifttxt1);
	Thread.sleep(1000);
	tofill(Shifttxt1, Shift);
	Thread.sleep(1000);
	totabkey();

	// Explicit Wait for Reason
	WebDriverWait wait8 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDReason));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDReason);
	WebElement Reasontxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
	actionssendkeysdelete(Reasontxt1);
	Thread.sleep(1000);
	tofill(Reasontxt1, Reason);
	Thread.sleep(1000);
	totabkey();
	
}

@Then("User Verify the Under Scenario changes in Update By Department screen {string} and {int}")
public void user_verify_the_under_scenario_changes_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, Throwable 
{
   
	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	mouseOver(udp.TransactionMenu);

	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);
	Thread.sleep(1000);
	
	//  Under Verification ==>  4
	String UnderExp = "0:50";
	Thread.sleep(500);
	WebDriverWait wait13 = new WebDriverWait(driver, 100);
	wait13.until(ExpectedConditions.elementToBeClickable(udp.Under1));
	toClick(udp.Under1);
	WebElement Under = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[14]"));

	String UnderAct = Under.getText();
	System.out.println("Under : Expected: " + UnderExp + " Actual: " + UnderAct);
	
	//Soft Validation OT10
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(UnderExp, UnderAct);
	
	Thread.sleep(500);
	udp.Under.click();
	Thread.sleep(3000);
	udp.Under.click();
	
	System.out.println("Post Recalculated Attendance Update By Department Under Scenario Verification Completed");
	
	Scrollupjavascript();
	
	// Change the employee OT Type to Felxi and Rate
	WebDriverWait wait32 = new WebDriverWait(driver, 100);
	wait32.until(ExpectedConditions.elementToBeClickable(udp.SortBy));
	toselectbyvisibletext(udp.SortBy, "Shift");
	
	
}

@When("User Entering the Clockin details for Absent and Insufficient scenario in Update By Department screen {string} and {int}")
public void user_entering_the_clockin_details_for_absent_and_insufficient_scenario_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, Throwable 
{

	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	//=================================== User Interacting the Update By Department Screen ===================================//
	
	mouseOver(udp.TransactionMenu);
	
	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);

	// ================== Row 1 -  Insertion OT Scenario =========================== //	
	
	Thread.sleep(1000);
	
	String In=UBDData.get(RowNumber).get("In1");
	String Out=UBDData.get(RowNumber).get("Out1");
	String Shift=UBDData.get(RowNumber).get("Shfit1");
	String Reason=UBDData.get(RowNumber).get("Reason1");
	
	// Explicit Wait for Clock In
	WebDriverWait wait4 = new WebDriverWait(driver, 100);
	wait4.until(ExpectedConditions.elementToBeClickable(udp.UBDClockIn));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDClockIn);
	WebElement ClockIntxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
	actionssendkeysdelete(ClockIntxt1);
	Thread.sleep(1000);
	tofill(ClockIntxt1, In);
	Thread.sleep(1000);
	
	// toenter();
	totabkey();
	System.out.println("Clockin Enterted");

	// Explicit Wait for Clock Out
	WebDriverWait wait6 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDClockOut));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDClockOut);
	WebElement ClockOuttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[6]/textarea"));
	actionssendkeysdelete(ClockOuttxt1);
	Thread.sleep(1000);
	tofill(ClockOuttxt1, Out);
	Thread.sleep(1000);
	totabkey();

	// Explicit Wait for shift
	WebDriverWait wait7 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDShift));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDShift);
	WebElement Shifttxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
	actionssendkeysdelete(Shifttxt1);
	Thread.sleep(1000);
	tofill(Shifttxt1, Shift);
	Thread.sleep(1000);
	totabkey();

	// Explicit Wait for Reason
	WebDriverWait wait8 = new WebDriverWait(driver, 100);
	wait6.until(ExpectedConditions.elementToBeClickable(udp.UBDReason));
	Thread.sleep(2000);
	actionssendkeysdelete(udp.UBDReason);
	WebElement Reasontxt1 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[7]/textarea"));
	actionssendkeysdelete(Reasontxt1);
	Thread.sleep(1000);
	tofill(Reasontxt1, Reason);
	Thread.sleep(1000);
	totabkey();
	
}

@Then("User Verify the Absent and Insufficient Scenario changes in Update By Department screen {string} and {int}")
public void user_verify_the_absent_and_insufficient_scenario_changes_in_update_by_department_screen_and(String Sheet7, Integer RowNumber) throws InvalidFormatException, Throwable 
{
	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();

	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> UBDData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", Sheet7);

	mouseOver(udp.TransactionMenu);

	// Explicit Wait for UpdateByDepartmentMenu
	WebDriverWait wait1 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UpdateByDepartmentMenu));
	toClick(udp.UpdateByDepartmentMenu);
	
	// Explicit Wait for Employee
	String DepartmentName = UBDData.get(RowNumber).get("Department Name");
	WebDriverWait wait2 = new WebDriverWait(driver, 100);
	wait1.until(ExpectedConditions.elementToBeClickable(udp.UBDEmployee));
	actionssendkeysdelete(udp.UBDEmployee);
	tofill(udp.UBDEmployee, DepartmentName);
	todown();
	toenter();

	// Explicit Wait for From Date
	String FromDate = UBDData.get(RowNumber).get("Effective From");
	WebDriverWait wait3 = new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(udp.UBDFromDate));
	Thread.sleep(500);
	actionssendkeysdelete(udp.UBDFromDate);
	Thread.sleep(500);
	tofill(udp.UBDFromDate, FromDate);
	toenter();

	// Click Search
	Thread.sleep(1000);
	toClick(udp.UBDbtnSearch);
	Thread.sleep(1000);
	
/*	//  OT20 Verification ==>  5
	String OT201Exp = "2:00";
	Thread.sleep(500);
	WebDriverWait wait14 = new WebDriverWait(driver, 100);
	wait14.until(ExpectedConditions.elementToBeClickable(udp.OT201));
	toClick(udp.OT201);
	Thread.sleep(500);
	WebElement OT201 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[18]"));

	String OT201Act = OT201.getText();
	System.out.println("OT20 : Exp: "+OT201Exp+" Actual: "+OT201Act);
	assertEquals(OT201Exp, OT201Act);
			
	//  OT30 Verification ==>  6
	String OT301Exp = "5:50";
	Thread.sleep(500);
	WebDriverWait wait15 = new WebDriverWait(driver, 100);
	wait15.until(ExpectedConditions.elementToBeClickable(udp.OT301));
	toClick(udp.OT301);
	WebElement OT301 = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[19]"));

	String OT301Act = OT301.getText();
	System.out.println("OT30 : Expected: "+OT301Exp+" Actual: "+OT301Act);
	assertEquals(OT301Exp, OT301Act);	*/
	
	Thread.sleep(500);
	udp.Absent.click();
	Thread.sleep(3000);
	udp.Absent.click();
	
	Thread.sleep(500);
	udp.Insufficient.click();
	Thread.sleep(3000);
	udp.Insufficient.click();
	
	System.out.println("Post Recalculated Attendance Update By Department Absent & Insufficient Scenario Verification Completed");
	
	Scrollupjavascript();
	
	// Change the employee OT Type to Felxi and Rate
	WebDriverWait wait32 = new WebDriverWait(driver, 100);
	wait32.until(ExpectedConditions.elementToBeClickable(udp.SortBy));
	toselectbyvisibletext(udp.SortBy, "Reason");
	
}

@Then("User Verify the flat value in Update By Department screen {string} and {int}")
public void user_verify_the_flat_value_in_update_by_department_screen_and(String string, Integer int1) throws InterruptedException 
{

	uip = new UpdateByIndividual_POJO();
	udp = new UpdateByDepartment_POJO();
	
	// Flat Verification
	String FlatExp = "3:00";
	Thread.sleep(3000);
	WebDriverWait wait7 = new WebDriverWait(driver, 100);
	wait7.until(ExpectedConditions.elementToBeClickable(udp.Flat));
	toClick(udp.Flat);

	WebElement Flat = driver.findElement(By.xpath("//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[20]"));
	String FlatActual = Flat.getText();

	System.out.println("Flat : Expected: " + FlatExp + " Actual: " + FlatActual);

	assertEquals(FlatExp, FlatActual);

	Thread.sleep(2000);
	
}


	
}
