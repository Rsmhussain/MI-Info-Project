package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dutyroster_POJO extends Reusableclass
{
	public Dutyroster_POJO()
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
	
	public final By DutyRosterError= ById.xpath("//*[@id=\"ContentPlaceHolder1_lblErrorMsg\"]");
	

}
