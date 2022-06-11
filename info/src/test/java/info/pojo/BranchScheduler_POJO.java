package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchScheduler_POJO extends Reusableclass
{
	public BranchScheduler_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/BranchSchedule.aspx']")
	public WebElement BranchScheduleMenu;
	
	@FindBy(id = "ContentPlaceHolder1_dlBranch")
	public WebElement Branch;
	
	@FindBy(id = "ContentPlaceHolder1_txtFromDate")
	public WebElement FromDate;
	
	@FindBy(id = "ContentPlaceHolder1_txtToDate")
	public WebElement ToDate;
	
	@FindBy(id = "ContentPlaceHolder1_btnGenerate")
	public WebElement GenerateSchedule;
	
}
