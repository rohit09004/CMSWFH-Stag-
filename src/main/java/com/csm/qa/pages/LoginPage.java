package com.csm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csm.qa.base.CSMBase;

public class LoginPage extends CSMBase {
	
	//page Factory  or object repository
	@FindBy(id="UserId")
	WebElement UserID;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement login_Btn;
	
     @FindBy(xpath="//img[contains(@class,'profile-img-card')]")
     WebElement CMSLogo;
     
     @FindBy(xpath="/html/body/div[1]/div/section[2]/div[3]/div/div/div/div[1]/button")
     WebElement closePasswordPoup;
     
    //Initialize Page object  
     public LoginPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }
     //Action:  
     public String validateLoginPageTitle()
     {
    	 return driver.getTitle();   	 
     }
     
     public boolean validateCSMLogo()
     {
    	 return CMSLogo.isDisplayed();
     }
     
     public HomePage login(String uid, String pwd)
     {
    	 UserID.sendKeys(uid);
    	 Password.sendKeys(pwd);
    	 login_Btn.click(); 
    	// closePasswordPoup.click();
    	 return new HomePage();
    		
     }
	private void closePasswordPoup() {
		// TODO Auto-generated method stub
		
	}
}
