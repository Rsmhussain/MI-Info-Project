package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dutyroster_New_POJO extends Reusableclass
{
	public Dutyroster_New_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Duty Roster")
	public WebElement DutyrosterMenu;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_lnkAddDutyRoster\"]/i")
	public WebElement NewDutyroster;
	
	@FindBy(id="ContentPlaceHolder1_txtDutyRosterCode")
	public WebElement DutyrosterCode;
	
	@FindBy(id="ContentPlaceHolder1_txtDutyRosterName")
	public WebElement DutyrosterName;
	
	@FindBy(id="ContentPlaceHolder1_txtEffectivetDate")
	public WebElement DREffectiveFrom;
	
	@FindBy(id="ContentPlaceHolder1_ddlRecurrenceDays")
	public WebElement DRRecurrenceDays;
	
	@FindBy(id="ContentPlaceHolder1_ddlGroupInvolved")
	public WebElement DRGroupinvolved;
	
	@FindBy(id="ContentPlaceHolder1_btnAdd")
	public WebElement DRSaveButton;
	
	@FindBy(id="ContentPlaceHolder1_btnCancelAdd")
	public WebElement DRCancelButton;
	
	//public final By DutyRosterError= ById.xpath("//*[@id=\"ContentPlaceHolder1_lblErrorMsg\"]");
	
	
	//Row1
	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift0_0")
	public WebElement DD1R0;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift1_0")
	public WebElement DD1R1;
	
	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift2_0")
	public WebElement DD1R2;
	
	//Row2
	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift0_1")
	public WebElement DD2R0;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift1_1")
	public WebElement DD2R1;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift2_1")
	public WebElement DD2R2;
	
	//Row3
	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift0_2")
	public WebElement DD3R0;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift1_2")
	public WebElement DD3R1;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift2_2")
	public WebElement DD3R2;
	
	//Row4
	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift0_3")
	public WebElement DD4R0;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift1_3")
	public WebElement DD4R1;

	@FindBy(id="ContentPlaceHolder1_gvFirstWeek_ddlShift2_3")
	public WebElement DD4R2;
	
	
}
