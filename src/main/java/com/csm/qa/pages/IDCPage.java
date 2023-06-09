package com.csm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csm.qa.base.CSMBase;

public class IDCPage extends CSMBase {
	
	@FindBy(xpath="//strong[contains(text(),'Integrated DataTransfer Control')]")
	WebElement Validate_IDC;
	
	public IDCPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyIDCPage()
	{
			return Validate_IDC.isDisplayed();
	}
	
	
}