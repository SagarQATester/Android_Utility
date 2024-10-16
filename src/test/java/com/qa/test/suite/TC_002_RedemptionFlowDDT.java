package com.qa.test.suite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.test.allureReports.AllureListener;
import com.qa.test.allureReports.BaseClass;
import com.qa.test.pageobject.LoginPage;
import com.qa.test.reusableComponents.XLUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class TC_002_RedemptionFlowDDT extends BaseClass {


	@Severity(SeverityLevel.NORMAL)
	@Description("TS_001-TC_001_Redemption: To verify Investor is able to withdraw the amount")
	@Epic("Redemption Flow")
	@Feature("Feature :TS_001-TC_001_Redemption: To verify Investor is able to withdraw the amount")
	@Story("Story:Redemption Flow")
	@Test(groups = { "Regression", "Redemption Flow", "TS_001-TC_001",
			"ToBeExecutedAlways" }, dataProvider = "InvestorDetails", priority = 1, enabled = true, description = "TS_001-TC_001_Redemption: To verify Investor is able to withdraw the amount")

	public void verifyInvestorAbleToCreateNewAccount(String username, String password, String folioNumber,
			String schema, String redemptionOption, String redemptionValue) throws InterruptedException, MalformedURLException {

		System.out.println(username + password + folioNumber + schema+redemptionOption+redemptionValue);

		BaseClass baseclass = new BaseClass();
	//	baseclass.setAppiumDriver();
		baseclass.initialize_driver();
		
		LoginPage lp = new LoginPage();
		lp.clickOnInvestorTab();

	
		lp.enterUsernameOrPanNumber(username);
	
		lp.enterPassword(password);
			
		lp.clickOnSubmitButton();	
	
		//lp.clickOnGenerateOTPButton();
	
		String OTP=  readOTPFromNotification();
		System.out.println("Recieved OTP:"+OTP);
	
		lp.enterOTP(OTP);
		Thread.sleep(2000);
		lp.clickOnVerifyOTPButton();	
		Thread.sleep(2000);
		lp.clickOnCloseAdd();		
		lp.clickTransactNowMenu();		
		lp.clickWithdrawMenu();		
		lp.clickRedeemOption();		
		lp.chooseFolioNumber(folioNumber);		
		lp.selectSchema(schema);	
		lp.selectRedemptionValue(redemptionOption,redemptionValue);				
		//lp.enterRedemptionValue(redemptionValue);	
		Thread.sleep(5000);
		lp.clickOnContinueButton();	
		lp.clickOnTermsAndConditions();	
		Thread.sleep(2000);
		lp.clickOnAcceptButton();		
		//lp.clickOnCompleteTransactionButton();	
		lp.paascase();
		Thread.sleep(2000);

	}

	@DataProvider(name = "InvestorDetails")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\RedemptionProcess.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String registrationdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				registrationdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return registrationdata;
	}

	
	
	private String  readOTPFromNotification() 
	{
		
		try {
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "RMX2151");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
			caps.setCapability(MobileCapabilityType.UDID, "YXXCNRGQYHXG5LOR");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

			AndroidDriver<WebElement>androidDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		    
		   
		    ((AndroidDriver<WebElement>) androidDriver).openNotifications();

	
		    
		    WebDriverWait wait = new WebDriverWait(((AndroidDriver<WebElement>) androidDriver), 120);
	
		    By otpLocator = By.xpath("//android.widget.Button[@resource-id='android:id/action0']");
		//	WebElement otpElement=androidDriver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/action0']"));
		  //  waitForElement(androidDriver, "OTP Element", otpLocator, 50);
		    
		  WebElement otpElement = wait.until(ExpectedConditions.presenceOfElementLocated(otpLocator));
			
		
			
			 
			 String otpMessage = otpElement.getText();
			 System.out.println("OTP message: "+otpMessage);
			 String otp = otpMessage.replaceAll("[^0-9]", ""); // Extract only the numeric digits from the message
			  System.out.println("OTP: " + otp);
			  
			  return otp;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
			
	}
	

}
