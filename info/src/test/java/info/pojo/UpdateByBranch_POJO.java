package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateByBranch_POJO extends Reusableclass
{
	public UpdateByBranch_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	/*  ==================  1.Update By Branch =====================  */
	
	@FindBy(xpath = "//span[contains(text(),'Transaction')]")
	public WebElement TransactionMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/UpdateByBranchHandsOn.aspx']")
	public WebElement UpdateByBranchMenu;

	@FindBy(id = "inputpicker-1")
	public WebElement UBBBranch;
	
	@FindBy(id = "txtFromDate")
	public WebElement UBBFromDate;
	
	@FindBy(id = "inpbtnSearch")
	public WebElement UBBbtnSearch;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[7]")
	public WebElement UBBClockIn;

	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[8]")
	public WebElement UBBClockOut;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[8]
	//*[@id="dhot"]/div[6]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[9]")
	public WebElement UBBShift;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[9]
	//*[@id="dhot"]/div[7]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[10]")
	public WebElement UBBReason;
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[10]
	//*[@id="dhot"]/div[7]/textarea
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[11]/input")
	public WebElement UBBLock1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[12]")
	public WebElement UBBNRM1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[13]")
	public WebElement UBBActual1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[14]")
	public WebElement UBBUnder1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[15]")
	public WebElement UBBLateness1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[16]")
	public WebElement UBBOT101;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[17]")
	public WebElement UBBOT151;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[18]")
	public WebElement UBBOT201;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[19]")
	public WebElement UBBOT301;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[20]")
	public WebElement UBBFlat;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[21]")
	public WebElement UBBAttendanceAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[22]")
	public WebElement UBBShiftAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[23]")
	public WebElement UBBMealsAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[24]")
	public WebElement UBBTransportAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[25]")
	public WebElement UBBHealthAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]")
	public WebElement UBBOther1Allowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]")
	public WebElement UBBOther2Allowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[1]/td[27]")
	public WebElement UBBComments1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[6]/textarea")
	public WebElement UBBComments1txt;
	
	//Late
	@FindBy(id = "chkL")
	public WebElement UBBLate;

	// Under
	@FindBy(id = "chkU")
	public WebElement UBBUnder;

	// Absent
	@FindBy(id = "chkABS")
	public WebElement UBBAbsent;

	// Insufficient
	@FindBy(id = "chkI")
	public WebElement UBBInsufficient;
	
	//Sort By
	@FindBy(id = "dlSortBy")
	public WebElement UBBSortBy;
	
	//Order By
	@FindBy(id = "dlSortOrder")
	public WebElement UBBOrderBy;

}
