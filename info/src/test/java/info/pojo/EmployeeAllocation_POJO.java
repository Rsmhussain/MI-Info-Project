package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeAllocation_POJO extends Reusableclass
{
	public EmployeeAllocation_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Branch Setup")
	public WebElement BranchSetupMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/BranchAllocation.aspx']")
	public WebElement EmpAllocationMenu;
	
	@FindBy(id = "ContentPlaceHolder1_dlDepartment_DropDiv")
	public WebElement DepDropDownbtn;
	
	@FindBy(id = "ContentPlaceHolder1_dlDepartment_Input")
	public WebElement DepDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_dlSection_DropDiv")
	public WebElement SecDropDownbtn;
	
	@FindBy(id = "ContentPlaceHolder1_dlSection_Input")
	public WebElement SecDropDown;
		
	@FindBy(id = "ContentPlaceHolder1_gvEmpSearch_cbkList_0")
	public WebElement empCheckbox;
	
	@FindBy(id = "ContentPlaceHolder1_gvEmpSearch_chbIncludeAllDays")
	public WebElement allempCheckbox;
	
	@FindBy(id = "ContentPlaceHolder1_txtEmpSearchText")
	public WebElement empTextBox;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_divDetails\"]/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div/div/button/i")
	public WebElement empSearch;
	
	@FindBy(xpath = "//i[contains(@class, 'fa fa-search']")
	public WebElement empSearch1;
	
	@FindBy(id = "ContentPlaceHolder1_ddlshiftGroup_DropDiv")
	public WebElement BrnDropDownbtn;
	
	@FindBy(id = "ContentPlaceHolder1_ddlshiftGroup_Input")
	public WebElement BrnDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_btnUpdateEmp")
	public WebElement AssignTo;
	
	
	
	
	
	
	
	
	
}
