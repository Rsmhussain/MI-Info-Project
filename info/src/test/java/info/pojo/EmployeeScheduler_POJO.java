package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeScheduler_POJO extends Reusableclass
{
	public EmployeeScheduler_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/EmployeeSchedule.aspx']")
	public WebElement EmployeeSchedulerMenu;
	
	@FindBy(id = "ContentPlaceHolder1_txtEmpSearchText")
	public WebElement EmployeeText;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_Panel1\"]/div[1]/div/div/div/button/i")
	public WebElement EmployeeSearch;
	
	@FindBy(id = "ContentPlaceHolder1_gvEmpSearch_lnkEdit_0")
	public WebElement EmployeeEdit;
	
	@FindBy(id = "ContentPlaceHolder1_txtFromDate")
	public WebElement FromDate;
	
	@FindBy(id = "ContentPlaceHolder1_txtToDate")
	public WebElement ToDate;
	
	@FindBy(id = "ContentPlaceHolder1_btnGenerate")
	public WebElement GenerateScheduler;
	
	@FindBy(id = "dlShift_22")
	public WebElement ShiftDropDown;
	
	@FindBy(id = "ContentPlaceHolder1_UploadButton")
	public WebElement Import;
	
	
}
