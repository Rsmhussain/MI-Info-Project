package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OTRatioReport_POJO extends Reusableclass
{
    /*  ==================  Initialize the Driver =====================  */
	
	public OTRatioReport_POJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*  ==================  OT Ratio Report Objects =====================  */
	
	@FindBy(xpath = "//span[normalize-space()='Reports']")
	public WebElement ReportMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/RptOTRatio.aspx']")
	public WebElement OTRatioReportMenu;
	
	@FindBy(id="ContentPlaceHolder1_txtFromDate")
	public WebElement FromDate;
	
	@FindBy(id="ContentPlaceHolder1_txtToDate")
	public WebElement ToDate;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_txtGlobalSearch")
	public WebElement SearchTextBox;
	
	@FindBy(id = "ContentPlaceHolder1_UCEmployeeList_lnkSearch")
	public WebElement Search;
	
	
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_rbCategories_0")
	public WebElement Individual;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_rbCategories_1")
	public WebElement Department;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_rbCategories_2")
	public WebElement Section;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_rbCategories_3")
	public WebElement Designation;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_gvEmpList_chkAll")
	public WebElement EmpCheckAll;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_gvDept_chkAll")
	public WebElement DeptCheckAll;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_gvSection_chkAll")
	public WebElement SectCheckAll;
	
	@FindBy(id="ContentPlaceHolder1_UCEmployeeList_gvDesignation_chkAll")
	public WebElement DesCheckAll;
	
	@FindBy(id="ContentPlaceHolder1_btnShow")
	public WebElement ShowButton;
	
	@FindBy(id="ContentPlaceHolder1_btnClose")
	public WebElement ExitButton;
	
	@FindBy(id="ContentPlaceHolder1_txtSeEarch")
	public WebElement ReportSearch;
	
}
