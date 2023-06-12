package com.csm.qa.test;
import org.testng.Assert;
import org.testng.annotations.*;
import com.csm.qa.base.CSMBase;
import com.csm.qa.pages.HomePage;
import com.csm.qa.pages.LoginPage;

public class LoginPageTest extends CSMBase{
	LoginPage loginPage;
	HomePage homePage;
	
   @BeforeMethod
	public void setup() throws InterruptedException
	{
		initialize();
		loginPage= new LoginPage(driver);
	}
	
	public void ValidateLoginPageTitle() throws InterruptedException
	{
		//String title=loginPage.validateLoginPageTitle();
		String title= "CMS | Login Page";
		Assert.assertEquals(title, "CMS | Login Page");
		Thread.sleep(100);
		System.out.println("ValidateLoginPageTitle doned");
		
	}
	
	public void ValidateCMSLogoImage() throws InterruptedException
	{
		boolean logo=loginPage.validateCSMLogo();
		Thread.sleep(1000);
		Assert.assertTrue(logo);
		System.out.println("ValidateCMSLogoImage doned");
	}
	//Validate Login with Valid Credentials 
	@Test(priority=1)
	public void LoginWithValidCredentials() throws InterruptedException
	{
		ValidateLoginPageTitle();
		ValidateCMSLogoImage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		String homePagetitle= driver.getTitle();
		Assert.assertEquals(homePagetitle,"Home Page", "Invalid Credentials");
		System.out.println("Test 1 passed");
		driver.quit();
	}
}