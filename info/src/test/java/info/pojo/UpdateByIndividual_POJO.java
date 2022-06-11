package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateByIndividual_POJO extends Reusableclass
{

	public UpdateByIndividual_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	/*  ==================  1.Update By Individual =====================  */
	
	@FindBy(xpath = "//span[contains(text(),'Transaction')]")
	public WebElement TransactionMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/UpdateByIndvidualHandsOn.aspx']")
	public WebElement UpdateByIndividualMenu;
	
	@FindBy(id = "inputpicker-1")
	public WebElement Employee;
	
	@FindBy(id = "txtFromDate")
	public WebElement FromDate;
	
	@FindBy(id = "txtTodate")
	public WebElement ToDate;
	
	@FindBy(xpath = "//*[@id=\"inpbtnSearch\"]/i")
	public WebElement Search;
	
	@FindBy(id = "btnGenerate")
	public WebElement MissingDate;
	
	//Late
	@FindBy(id = "chkL")
	public WebElement Late;
	
	//Under
	@FindBy(id = "chkU")
	public WebElement Under;
	
	//Absent
	@FindBy(id = "chkABS")
	public WebElement Absent;
	
	//Insufficient
	@FindBy(id = "chkI")
	public WebElement Insufficient;
	
	/*  ==================  1 Row =====================  */
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[7]")
	public WebElement ClockIn1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[8]")
	public WebElement ClockOut1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[9]")
	public WebElement Shift1;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr[1]/td[9]
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[10]")
	public WebElement Reason1;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr[1]/td[10]
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[11]/input")
	public WebElement Lock1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[12]")
	public WebElement NRM1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[13]")
	public WebElement Actual1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[14]")
	public WebElement Under1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[15]")
	public WebElement Lateness1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[16]")
	public WebElement OT101;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[17]")
	public WebElement OT151;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[18]")
	public WebElement OT201;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[19]")
	public WebElement OT301;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[20]")
	public WebElement Flat;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[21]")
	public WebElement AttendanceAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[22]")
	public WebElement ShiftAllowance;
	
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[23]")
	public WebElement MealsAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[24]")
	public WebElement TransportAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[25]")
	public WebElement HealthAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]")
	public WebElement Other1Allowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]")
	public WebElement Other2Allowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[1]/td[27]")
	public WebElement Comments1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[6]/textarea")
	public WebElement Comments1txt;
	
	/*  ==================  2 Row =====================  */
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[2]/td[7]")
	public WebElement ClockIn2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[2]/td[8]")
	public WebElement ClockOut2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[2]/td[9]")
	public WebElement Shift2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[2]/td[10]")
	public WebElement Reason2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[2]/td[11]/input")
	public WebElement Lock2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[2]/td[15]")
	public WebElement Lateness2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[2]/td[27]")
	public WebElement Comments2;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]")
	public WebElement Allowance2;
	
	
	
	/*  ==================  3 Row =====================  */
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[3]/td[7]")
	public WebElement ClockIn3;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[3]/td[8]")
	public WebElement ClockOut3;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[3]/td[9]")
	public WebElement Shift3;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[3]/td[10]")
	public WebElement Reason3;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[3]/td[11]/input")
	public WebElement Lock3;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[3]/td[14]")
	public WebElement Under3;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[3]/td[27]")
	public WebElement Comments3;
	
	/*  ==================  4 Row =====================  */
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[7]")
	public WebElement ClockIn4;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[8]")
	public WebElement ClockOut4;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[9]")
	public WebElement Shift4;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[10]")
	public WebElement Reason4;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[11]/input")
	public WebElement Lock4;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[18]")
	public WebElement OT204;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[4]/td[19]")
	public WebElement OT304;
	
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[4]/td[27]")
	public WebElement Comments4;
	
	/*  ==================  5 Row =====================  */
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[5]/td[7]")
	public WebElement ClockIn5;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[5]/td[8]")
	public WebElement ClockOut5;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[5]/td[9]")
	public WebElement Shift5;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[5]/td[10]")
	public WebElement Reason5;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[5]/td[11]/input")
	public WebElement Lock5;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[5]/td[27]")
	public WebElement Comments5;
	
	/*  ================== // *** 2.Recalcualte Attendance Details *** // =====================  */
	
	@FindBy(xpath = "//span[contains(text(),'Utility')]")
	public WebElement UtilityMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/RecalculateAttendance.aspx']")
	public WebElement RecalculateAttendanceMenu;
	
	@FindBy(id = "txtFromDate")
	public WebElement RAFromDate;
	
	@FindBy(id = "txtToDate")
	public WebElement RAToDate;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_txtGlobalSearch")
	public WebElement RAEmpSearchTxt;

	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_UCEmployeeList_lnkSearch\"]/i")
	public WebElement RAEmpSearchBtn;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvEmpList_chkAll")
	public WebElement RAEmpChkBox;
	
	@FindBy(id = "ContentPlaceHolder1_btnRecalculate")
	public WebElement RARecalcualte;
	
	/*  ================== // *** 3.Basic Employee Details *** // =====================  */
	
	@FindBy(xpath = "//span[contains(text(),'Master')]")
	public WebElement Master;
	
	//Basic Employee Master Menu
	@FindBy(xpath = "//a[@data-text='~/CommonMasters/SingleStaffMaster.aspx']")
	public WebElement BasicEmployeeMaster;
	
	//EmployeeNameSearchTextBox
	@FindBy(id = "ContentPlaceHolder1_txtEmpSearchText")
	public WebElement EmpSrchTxt;
	
	//EmployeeSearchButton
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_pnlScroll\"]/div[1]/div/div[1]/div/div/div/button/i")
	public WebElement EmpSrchButton;
	
	//EditEmployee
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvEmpSearch_lnkEdit_0\"]")
	public WebElement EmpEditButton;
	
	//General Tab
	@FindBy(xpath = "//*[@id=\"__tab_ContentPlaceHolder1_tabEmployeeContainer_tabEmpBasic\"]/span")
	public WebElement EmpGeneralTab;
	
	//Part Time or Flexi
	@FindBy(id = "ContentPlaceHolder1_tabEmployeeContainer_tabEmpBasic_dlPartTimeFlexi")
	public WebElement DllPartFlexi;
	
	//TMS Tab
	@FindBy(xpath = "//span[contains(text(),'E-TMS')]")
	public WebElement EmpTMSTab;
	
	//DllOTType
	@FindBy(id = "dlOTtype")
	public WebElement DllOTType;
	
	//FLAT RATE
	@FindBy(id = "txtFlatHourlyDailyRate")
	public WebElement flatrate;
	
	//FLAT RATE
	@FindBy(id = "dlShift")
	public WebElement EmpShift;
	
	//Schedule
	@FindBy(id = "chkSchedule")
	public WebElement EmpSchedule;
	
	//Emp Update Button
	@FindBy(id = "ContentPlaceHolder1_btnUpdate")
	public WebElement EmpUpdateBtn;
	
	//Branch
	@FindBy(id = "ddlbranch")
	public WebElement EmpBranch;
	
	//Department
	@FindBy(id="dlDepartment")
	public WebElement EmpDepartment;
	
	//Section
	@FindBy(id = "dlSection")
	public WebElement EmpSection;

	/*  ================== // *** 4.Purge and Reprocess *** // =====================  */
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/PurgeAndReprocess.aspx']")
	public WebElement PurgeAndReprocessMenu;
	
	@FindBy(id = "txtFromDate")
	public WebElement PRFromDate;
	
	@FindBy(id = "txtToDate")
	public WebElement PRToDate;
	
	@FindBy(id = "ContentPlaceHolder1_CheckBoxList1_0")
	public WebElement PRPurgeChkBox;
	
	@FindBy(id = "ContentPlaceHolder1_CheckBoxList1_1")
	public WebElement PRReprocessChkBox;
		
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_txtGlobalSearch")
	public WebElement PREmpSrchTxt;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_UCEmployeeList_lnkSearch\"]/i")
	public WebElement PREmpSrchBtn;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvEmpList_chkAll")
	public WebElement PREmpChkBox;
	
	@FindBy(id = "ContentPlaceHolder1_btnProcess")
	public WebElement PRProcessBtn;
	
}
