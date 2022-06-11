package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateByDepartment_POJO extends Reusableclass
{
	public UpdateByDepartment_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	/*  ==================  1.Update By Department =====================  */
	
	
	@FindBy(xpath = "//span[contains(text(),'Transaction')]")
	public WebElement TransactionMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/UpdateByDepartmentHandsOn.aspx']")
	public WebElement UpdateByDepartmentMenu;
	
	@FindBy(id = "inputpicker-1")
	public WebElement UBDEmployee;
	
	@FindBy(id = "txtFromDate")
	public WebElement UBDFromDate;
	
	@FindBy(id = "inpbtnSearch")
	public WebElement UBDbtnSearch;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[7]")
	public WebElement UBDClockIn;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[7]
	//*[@id="dhot"]/div[6]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[8]")
	public WebElement UBDClockOut;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[8]
	//*[@id="dhot"]/div[6]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[9]")
	public WebElement UBDShift;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[9]
	//*[@id="dhot"]/div[7]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[10]")
	public WebElement UBDReason;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[10]
	//*[@id="dhot"]/div[7]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[11]/input")
	public WebElement Lock1;
	
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[11]/input
	
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
	
	
	//Late
	@FindBy(id = "chkL")
	public WebElement Late;

	// Under
	@FindBy(id = "chkU")
	public WebElement Under;

	// Absent
	@FindBy(id = "chkABS")
	public WebElement Absent;

	// Insufficient
	@FindBy(id = "chkI")
	public WebElement Insufficient;
	
	//Sort By
	@FindBy(id = "dlSortBy")
	public WebElement SortBy;
	
	//Order By
	@FindBy(id = "dlSortOrder")
	public WebElement OrderBy;
	
	
	
	
	
}
