package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditLog_POJO extends Reusableclass
{
	public AuditLog_POJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*  ==================  Audit Log =====================  */
	
	@FindBy(xpath = "//span[contains(text(),'Administration')]")
	public WebElement AdministrationMenu;
	
	@FindBy(xpath = "//a[@data-text='~/Administration/AuditLogger.aspx']")
	public WebElement AuditLogMenu;

	@FindBy(id = "ContentPlaceHolder1_txtStartDate")
	public WebElement FromDate;
	
	@FindBy(id = "ContentPlaceHolder1_txtEndDate")
	public WebElement ToDate;
	
	@FindBy(id = "gs_LogDateTime")
	public WebElement LogDate;

	@FindBy(xpath = "//*[@id=\"gview_list\"]/div[2]/div/table/thead/tr[2]/th[4]/div/table/tbody/tr/td[2]/button/span[1]")
	public WebElement WebPage;
	
	@FindBy(xpath = "//input[@value='UPDATE BY INDIVIDUAL']")
	public WebElement UpdateByIndividual;
	
	//input[@value="UPDATE BY INDIVIDUAL"]
	
	@FindBy(xpath = "//*[@id='gview_list']/div[2]/div/table/thead/tr[2]/th[5]/div/table/tbody/tr/td[2]/button/span[1]")
	public WebElement Transaction;
	
	//*[@id="gview_list"]/div[2]/div/table/thead/tr[2]/th[5]/div/table/tbody/tr/td[2]/button/span[1]
	
	//*[@id="gview_list"]/div[2]/div/table/thead/tr[2]/th[5]/div/table/tbody/tr/td[2]/button/span[1]
	
	@FindBy(xpath = "//span[contains(text(),'UPDATE')]")
	public WebElement UPDATE;
	
	@FindBy(id = "gs_Record")
	public WebElement Record;
	
	@FindBy(id = "gs_FieldName")
	public WebElement FieldName;
	
	@FindBy(id = "gs_OldValue")
	public WebElement Oldvalue;
	
	@FindBy(id = "gs_NewValue")
	public WebElement Newvalue;
	
	@FindBy(xpath = "//*[@id=\"gview_list\"]/div[2]/div/table/thead/tr[2]/th[10]/div/table/tbody/tr/td[2]/button/span[1]")
	public WebElement UserName;
	
	//*[@id="gview_list"]/div[2]/div/table/thead/tr[2]/th[10]/div/table/tbody/tr/td[2]/button/span[1]
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
