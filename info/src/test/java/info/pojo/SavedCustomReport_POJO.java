package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedCustomReport_POJO extends Reusableclass
{

	/*  ==================  Initialize the Driver =====================  */
	
	public SavedCustomReport_POJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*  ================== Saved Custom Report Objects =====================  */
	
	@FindBy(xpath = "//span[normalize-space()='Reports']")
	public WebElement ReportMenu;
	
	@FindBy(linkText = "Custom Report")
	public WebElement CustomReportMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/rptCustomReportView.aspx']")
	public WebElement SavedCustomReportMenu;
	
	@FindBy(id = "ContentPlaceHolder1_grv_customReports_lnkEdit_0")
	public WebElement EditButton;
	
	@FindBy(id = "ContentPlaceHolder1_grv_customReports_lnkDel_0")
	public WebElement DeleteButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_txtReportTitle")
	public WebElement ReportTitle;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_wzrdCustomReport\"]/tbody/tr[2]/td/div/div/div/div[2]/section/div[1]/label")
	public WebElement MasterReport;
	
	@FindBy(id = "control_03")
	public WebElement SummaryReport;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_StartNavigationTemplateContainerID_Step2Next")
	public WebElement NextButton;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_wzrdCustomReport_StepNavigationTemplateContainerID_Step2Next']")
	public WebElement Next2Button;

	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_StartNavigationTemplateContainerID_Step5Cancel")
	public WebElement CancelButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_lnkReset")
	public WebElement ResetButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_txtNodeSearch")
	public WebElement SearchTextBox;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_lnkSearch")
	public WebElement SearchButton;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_wzrdCustomReport_trvCustomRptFieldsn0\"]/img")
	public WebElement EmployeeDetailsTree;
		
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_trvCustomRptFieldsn1CheckBox")
	public WebElement EmployeeBasicCheckBox;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_trvCustomRptFieldsn27CheckBox")
	public WebElement BusinessDetailsCheckBox;
	
	
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_btnMoveColumns")
	public WebElement MoveSelectedButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_btnRemoveList")
	public WebElement RemoveSelectedButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_lstReportColumns")
	public WebElement SelectDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_StepNavigationTemplateContainerID_Step5Prev")
	public WebElement PreviousButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_rdbLstOption_1")
	public WebElement ORRadioButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_ddlColumnName")
	public WebElement ColumnNameDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_ddlConditions")
	public WebElement ConditionsDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_ddlValue1")
	public WebElement ValueDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_btnSave")
	public WebElement AddToListButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_gv_FilterColumns_lnkEdit_1")
	public WebElement ListEditButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_btnUpdate")
	public WebElement ListUpdateButton;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_gv_FilterColumns_lnkDel_1")
	public WebElement ListDeleteButton;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_wzrdCustomReport_wzrdSection3\"]/div[1]/span/div/button/span")
	public WebElement CompanyDropDown;
	
	
	
	
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_wzrdCustomReport_wzrdSection3\"]/div[1]/span/div/ul/li[2]/a/label/input")
	public WebElement CompanyCheckBox;
	
	@FindBy(id = "ContentPlaceHolder1_wzrdCustomReport_btnGenerateReport")
	public WebElement GenerateReport;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
