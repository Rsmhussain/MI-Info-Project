package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateBySection_POJO extends Reusableclass
{
	public UpdateBySection_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	/*  ==================  1.Update By Section =====================  */
	
	@FindBy(xpath = "//span[contains(text(),'Transaction')]")
	public WebElement TransactionMenu;
	
	@FindBy(xpath = "//a[@data-text='~/ETMS/UpdateBySection.aspx']")
	public WebElement UpdateBySectionMenu;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[5]/div[2]/div[3]/div[2]/section[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement UBSDepartment;
	
	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[5]/div[2]/div[3]/div[2]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement UBSSection;
	
	@FindBy(id = "txtFromDate")
	public WebElement UBSFromDate;
	
	@FindBy(id = "inpbtnSearch")
	public WebElement UBSbtnSearch;
	
	
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[3]")
	public WebElement UBSSection1;
		
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[8]")
	public WebElement UBSClockIn;
	
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[8]
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[9]")
	public WebElement UBSClockOut;
	
	//*[@id="dhot"]/div[1]/div/div/div/table/tbody/tr/td[9]
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[10]")
	public WebElement UBSShift;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr/td[11]")
	public WebElement UBSReason;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[12]/input")
	public WebElement UBSLock1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[13]")
	public WebElement UBSNRM1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[14]")
	public WebElement UBSActual1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[15]")
	public WebElement UBSUnder1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[16]")
	public WebElement UBSLateness1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[17]")
	public WebElement UBSOT101;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[18]")
	public WebElement UBSOT151;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[19]")
	public WebElement UBSOT201;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[20]")
	public WebElement UBSOT301;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[21]")
	public WebElement UBSFlat;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[22]")
	public WebElement UBSAttendanceAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[23]")
	public WebElement UBSShiftAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[24]")
	public WebElement UBSMealsAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[25]")
	public WebElement UBSTransportAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[26]")
	public WebElement UBSHealthAllowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[27]")
	public WebElement UBSOther1Allowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div/table/tbody/tr[1]/td[28]")
	public WebElement UBSOther2Allowance;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[1]/div/div/div[1]/table/tbody/tr[1]/td[29]")
	public WebElement UBSComments1;
	
	@FindBy(xpath = "//*[@id=\"dhot\"]/div[6]/textarea")
	public WebElement UBSComments1txt;
	
	//Late
	@FindBy(id = "chkL")
	public WebElement UBSLate;

	// Under
	@FindBy(id = "chkU")
	public WebElement UBSUnder;

	// Absent
	@FindBy(id = "chkABS")
	public WebElement UBSAbsent;

	// Insufficient
	@FindBy(id = "chkI")
	public WebElement UBSInsufficient;
	
	//Sort By
	@FindBy(id = "dlSortBy")
	public WebElement UBSSortBy;
	
	//Order By
	@FindBy(id = "dlSortOrder")
	public WebElement UBSOrderBy;

	
}
