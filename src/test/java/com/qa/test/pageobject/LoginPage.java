package com.qa.test.pageobject;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.test.allureReports.AllureListener;
import com.qa.test.allureReports.BaseClass;
import com.qa.test.reusableComponents.CommonMethods;

import io.qameta.allure.Step;



public class LoginPage extends  BaseClass
{

	BaseClass baseclass=new BaseClass();
	WebDriver driver;
	//Actions actions = new Actions(driver);
	
	AllureListener allureListner=new AllureListener();	
	
	@FindBy (xpath="//a[text()='Investors']")
	WebElement investor;	
	
	@FindBy (xpath="//input[@placeholder='PAN / Username']")
	WebElement username;	
	
	@FindBy (xpath="//div[@role='alert']")
	WebElement alertmsg;	
	
	@FindBy (xpath="//input[@id='password']")
	WebElement password;	
	
	@FindBy (xpath="//span[text()='Submit']")
	WebElement submit;
	
	@FindBy (xpath="//span[text()='Submit & Generate OTP']")
	WebElement generateOTP;
	
	@FindBy (xpath="//input[@placeholder='Enter OTP']")
	WebElement enterOTP;
	
	@FindBy (xpath="//span[text()='Verify OTP & Login']")
	WebElement verifyOPT;
	
	// Cancel add
	////i[@class='icon-times']
	////img[@alt='Desktop']
	
	@FindBy (xpath="//i[@class='icon-times']")
	WebElement closeAdd;
	
	@FindBy (xpath="//a[text()='Transact Now']")
	WebElement transactNow;
	
	@FindBy (xpath="//a[text()='Withdraw']")
	WebElement withdraw;
	
	@FindBy (xpath="//a[text()='Redeem']")
	WebElement redeem;
	
	@FindBy (xpath="(//span[@class='triangle-down'])[1]")
	WebElement chooseFolioNumber;
	
	@FindBy (xpath="(//span[@class='triangle-down'])[2]")
	WebElement selectSchema;
	
	@FindBy (xpath="//div[@class='radiogroup']//div[1]")
	WebElement amount;
	
	@FindBy (xpath="//div[@class='radiogroup']//div[2]")
	WebElement units;
	
	@FindBy (xpath="//div[@class='radiogroup']//div[3]")
	WebElement allClearUnits;
	
	@FindBy (xpath="//div[@class='radiogroup']//div[4]")
	WebElement unitsFreeOfExitLoad;
	
	@FindBy (xpath="//input[@name='transactionValue']")
	WebElement enterValue;
	
	@FindBy (xpath="//span[@class='error-message']")
	WebElement errormsg;
	
	@FindBy (xpath="//li[@class='submit-buttons ']")
	WebElement continueButton;
	
	@FindBy (xpath="//a[text()='terms and conditions']")
	WebElement termsAndCondition;
	
	@FindBy (xpath="//button[text()='ACCEPT']")
	WebElement accept;
	
	@FindBy (xpath="//li[text()='Complete Transaction']")
	WebElement completeTransaction;
	

	public LoginPage() 
	{
		this.driver=BaseClass.getDriver();
		PageFactory.initElements(driver,this);
	}

	@Step("Click on Investor Tab")
	public void clickOnInvestorTab()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, "Investor Tab", investor);
			CommonMethods.click_custom(investor,"Investor Tab");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Investor Tab");
			Assert.fail("Not able to Click on Investor Tab");
		}
	}
	@Step("Enter Username or Pan Number")
	public void enterUsernameOrPanNumber(String pan)
	{		
		try
		{
			CommonMethods.waitForElement(driver, "UserName/PanNumber", username);
			CommonMethods.sendKeys_custom(username, "UserName/PanNumber", pan);
			username.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			if(isElementPresent(alertmsg)==true)
			{
				Thread.sleep(2000);
				AllureListener.saveTextLog("Error Message :"+alertmsg.getText());
				Assert.fail("Error Message :"+alertmsg.getText());			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Enter Username/Pan Number");
			Assert.fail("Not able to Enter Username/Pan Number");
			
		}
	}
	@Step("Enter Password")
	public void enterPassword(String pass)
	{		
		try
		{
			CommonMethods.waitForElement(driver, "Password", password);
			CommonMethods.sendKeys_custom(password, "Password", pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Enter Password");
			Assert.fail("Not able to Enter Username/Pan Number");
			
		}
	}
	@Step("Click on Submit Button")
	public void clickOnSubmitButton()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, "Submit", submit);
			CommonMethods.click_custom(submit,"Submit");
			
			Thread.sleep(2000);
			if(isElementPresent(alertmsg)==true)
			{
				Thread.sleep(2000);
				AllureListener.saveTextLog("Error Message :"+alertmsg.getText());
				Assert.fail("Error Message :"+alertmsg.getText());			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Submit Button");
			Assert.fail("Not able to Click on Submit Button");
		}
	}
	@Step("Click on Submit & Generate OTP Button")
	public void clickOnGenerateOTPButton()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, "Generate OTP", generateOTP);
			CommonMethods.click_custom(generateOTP,"Generate OTP");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Submit & Generate OTP Button");
			Assert.fail("Not able to Click on Submit & Generate OTP Button");
		}
	}
	
	@Step("Enter Genereated OTP")
	public void enterOTP(String otp)
	{		
		try
		{
			CommonMethods.waitForElement(driver, "Enter OTP", enterOTP);
			CommonMethods.sendKeys_custom(enterOTP, "Enter OTP", otp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Enter Generated OTP");
			Assert.fail("Not able to Enter Generated OTP ");
			
		}
	}
	
	@Step("Click on Verify OTP & Login Button")
	public void clickOnVerifyOTPButton()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, "Verify OTP", verifyOPT);
			CommonMethods.click_custom(verifyOPT,"Verify OTP");
			Thread.sleep(2000);
			if(isElementPresent(alertmsg)==true)
			{
				Thread.sleep(2000);
				AllureListener.saveTextLog("Error Message :"+alertmsg.getText());
				Assert.fail("Error Message :"+alertmsg.getText());			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Verify OTP & Login Button");
			Assert.fail("Not able to Click on Verify OTP & Login Button");
		}
	}
	
	@Step("Click To Close Add")
	public void clickOnCloseAdd()
	{
		
		try
		{
			Thread.sleep(3000);
			CommonMethods.waitForElement(driver, "CloseADD", closeAdd);
			CommonMethods.click_custom(closeAdd,"CloseADD OTP");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Close Add");
			Assert.fail("Not able to Close Add");
		}
	}
	@Step("Click To Transact Now Menu")
	public void clickTransactNowMenu()
	{
		
		try
		{			
			CommonMethods.waitForElement(driver, "Transact Now", transactNow);
			CommonMethods.click_custom(transactNow,"Transact Now");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Transact Now Menu");
			Assert.fail("Not able to Click on Transact Now Menu");
		}
	}
	@Step("Click on Withdraw Menu")
	public void clickWithdrawMenu()
	{
		
		try
		{			
			CommonMethods.waitForElement(driver, "Withdraw", withdraw);
			CommonMethods.click_custom(withdraw,"Withdraw");
			
			//actions.moveToElement(withdraw).build().perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to move on Withdraw Menu");
			Assert.fail("Not able to move on Withdraw Menu");
		}
	}
	
	@Step("Click To Redeem Option ")
	public void clickRedeemOption()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, "Withdraw", redeem);
			CommonMethods.click_custom(redeem,"Withdraw");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Redeem Option");
			Assert.fail("Not able to Click on Redeem Option");
		}
	}
	
	@Step("Choose Folio Number ")
	public void chooseFolioNumber(String folioNumber )
	{
		try
		   {
			Thread.sleep(2000);
			CommonMethods.waitForElement(driver, "Choose folio Number", chooseFolioNumber);
			CommonMethods.click_custom(chooseFolioNumber,"Choose folio Number");
			Thread.sleep(2000);
			
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[text()='"+folioNumber+"']"))).click().build().perform();
			
			}
	
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Select Folio Number");
			Assert.fail("Not able to Select Folio Number");
		}
		}
	
	@Step("Select Schema ")
	public void selectSchema(String schema )
	{
		try
		   {
			Thread.sleep(2000);
			CommonMethods.waitForElement(driver, "Select schema", selectSchema);
			CommonMethods.click_custom(selectSchema,"Select schema");
			Thread.sleep(2000);
			
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[text()='"+schema+"']"))).click().build().perform();
			
			}
	
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Select Folio Number");
			Assert.fail("Not able to Select Folio Number");
		}
		}
	
	
	@Step("Select Redemption value ")
	public void selectRedemptionValue(String option,String value)
	{
		
		try
		{
						
			if (option.equalsIgnoreCase("Amount"))
			{
				CommonMethods.waitForElement(driver, "Amount", amount);
				CommonMethods.click_custom(amount,"Amount");
				
				CommonMethods.waitForElement(driver, "Redemption value", enterValue);
				CommonMethods.sendKeys_custom(enterValue, "Redemption value", value);
				enterValue.sendKeys(Keys.TAB);
				
				if(isElementPresent(errormsg)==true)
				{
					Thread.sleep(5000);
					AllureListener.saveTextLog("Error Message :"+errormsg.getText());
					Assert.fail("Error Message :"+errormsg.getText());			
				}
				
				
			}
			else if (option.equalsIgnoreCase("Units"))
			{
				CommonMethods.waitForElement(driver, "Units", units);
				CommonMethods.click_custom(units,"Units");
				
				CommonMethods.waitForElement(driver, "Redemption value", enterValue);
				CommonMethods.sendKeys_custom(enterValue, "Redemption value", value);
				enterValue.sendKeys(Keys.TAB);
				
				if(isElementPresent(errormsg)==true)
				{
					Thread.sleep(5000);
					AllureListener.saveTextLog("Error Message :"+errormsg.getText());
					Assert.fail("Error Message :"+errormsg.getText());			
				}
			}
			else if (option.contains("All Clear Units"))
			{
				CommonMethods.waitForElement(driver, "All Clear Units", allClearUnits);
				CommonMethods.click_custom(allClearUnits,"All Clear Units");
			}
			else if (option.contains("Units free of exit load"))
			{
				CommonMethods.waitForElement(driver, "All Clear Units", allClearUnits);
				CommonMethods.click_custom(allClearUnits,"All Clear Units");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Select Redemption value");
			Assert.fail("Not able to Select Redemption value");
		}
	}

	
	public boolean isElementPresent(WebElement ele) //user defined method created to check alert is presetn or not
	{
		try
		{
			ele.isDisplayed();
			CommonMethods.waitForElement(driver," "+ele , ele);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	@Step("Enter Redemption value ")
	public void enterRedemptionValue(String value)
	{
		try
		{
			CommonMethods.waitForElement(driver, "Redemption value", enterValue);
			CommonMethods.sendKeys_custom(enterValue, "Redemption value", value);
			enterValue.sendKeys(Keys.TAB);
			
			if(isElementPresent(errormsg)==true)
			{
				Thread.sleep(5000);
				AllureListener.saveTextLog("Error Message :"+errormsg.getText());
				Assert.fail("Error Message :"+errormsg.getText());			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Error Message :"+errormsg.getText());
			Assert.fail("Error Message :"+errormsg.getText());
		}
	}
	@Step("Click On Continue Button")
	public void clickOnContinueButton()
	{
		
		try
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 500)");
			
			CommonMethods.waitForElement(driver, "Continue", continueButton);
			CommonMethods.click_custom(continueButton,"Continue");
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Continue Button");
			Assert.fail("Not able to Click on Continue Button");
		}
	}
	
	@Step("Click on Terms And Conditions")
	public void clickOnTermsAndConditions()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, "Terms And Conditions", termsAndCondition);
			CommonMethods.click_custom(termsAndCondition,"Terms And Conditions");
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Terms And Conditions ");
			Assert.fail("Not able to Click on Terms And Conditions");
		}
	}
	
	@Step("Accepts Terms And Conditions")
	public void clickOnAcceptButton()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, " Accept Terms And Conditions", accept);
			CommonMethods.click_custom(accept,"Accept Terms And Conditions");
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Accept Terms And Conditions button ");
			Assert.fail("Not able to Click on Accept Terms And Conditions button ");
		}
	}
	
		
	@Step("Click on Complete Transaction Button")
	public void clickOnCompleteTransactionButton()
	{
		
		try
		{
			CommonMethods.waitForElement(driver, " Complete Transaction", completeTransaction);
			CommonMethods.click_custom(completeTransaction,"Complete Transaction");
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			allureListner.saveScreenShot(driver);
			AllureListener.saveTextLog("Not able to Click on Complete Transaction button ");
			Assert.fail("Not able to Click on Complete Transaction button ");
		}
	}
	
	@Step("Test Case Passed")
	public void paascase()
	{
		
	}
	
}
