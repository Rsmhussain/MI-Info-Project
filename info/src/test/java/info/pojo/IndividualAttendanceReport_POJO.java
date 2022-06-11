package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IndividualAttendanceReport_POJO extends Reusableclass
{

	/*  ==================  Initialize the Driver =====================  */
	
	public IndividualAttendanceReport_POJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*  ==================  Individual Attendance Report =====================  */
	
	@FindBy(xpath = "//span[normalize-space()='Reports']")
	public WebElement ReportMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/RptIndividualAttendanceReports.aspx']")
	public WebElement IndividualAttedanceReportMenu;

	@FindBy(id = "ContentPlaceHolder1_txtFromDate")
	public WebElement FromDate;
	
	@FindBy(id = "ContentPlaceHolder1_txtToDate")
	public WebElement ToDate;
	
	@FindBy(id = "ContentPlaceHolder1_rblWeeklyNormal_0")
	public WebElement Normal;
	
	@FindBy(id = "ContentPlaceHolder1_rblWeeklyNormal_1")
	public WebElement Weekly;
	
	@FindBy(id = "ContentPlaceHolder1_chbActualClocking")
	public WebElement ShowActualClocking;
	
	@FindBy(id = "ContentPlaceHolder1_chbAllowance")
	public WebElement HideAllowance;
	
	@FindBy(id = "ContentPlaceHolder1_chbHidezero")
	public WebElement HideZero;
	
	@FindBy(id = "ContentPlaceHolder1_chbMonthlyAllowance")
	public WebElement MonthlyAllowance;
	
	@FindBy(id = "ContentPlaceHolder1_chbComments")
	public WebElement ShowComments;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_rbCategories_0")
	public WebElement Individual;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_rbCategories_1")
	public WebElement Department;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_rbCategories_2")
	public WebElement Section;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_rbCategories_3")
	public WebElement Designation;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_rbCategories_4")
	public WebElement Category;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_rbCategories_5")
	public WebElement ExtraClassification;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_txtGlobalSearch")
	public WebElement EmployeeSearchText;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_lnkSearch")
	public WebElement EmployeeSearchBtn;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvEmpList_chkAll")
	public WebElement EmpCheckAll;	

	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvDept_chkAll")
	public WebElement DepCheckAll;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvSection_chkAll")
	public WebElement SecCheckAll;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvDesignation_chkAll")
	public WebElement DesCheckAll;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvCategory_chkAll")
	public WebElement CatCheckAll;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_gvDesigGrp_chkAll")
	public WebElement ExtraClasCheckAll;
	
	
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_cbDept_Input")
	public WebElement DepartmentDDtextbox;

	@FindBy(id = "ContentPlaceHolder1_btnpdf1")
	public WebElement Preview;
	
	@FindBy(id = "ContentPlaceHolder1_btnExporttoExcel")
	public WebElement ExcelExport;
	
	@FindBy(id = "btnExportCSV")
	public WebElement btnExportCSV;
	
}
