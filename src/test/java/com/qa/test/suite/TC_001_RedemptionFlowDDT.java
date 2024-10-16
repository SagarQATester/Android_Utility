package com.qa.test.suite;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.test.allureReports.AllureListener;
import com.qa.test.allureReports.BaseClass;
import com.qa.test.pageobject.LoginPage;
import com.qa.test.reusableComponents.XLUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class TC_001_RedemptionFlowDDT extends BaseClass {

	@Severity(SeverityLevel.NORMAL)
	@Description("TS_001-TC_001_Redemption: To verify Investor is able to withdraw the amount")
	@Epic("Redemption Flow")
	@Feature("Feature :TS_001-TC_001_Redemption: To verify Investor is able to withdraw the amount")
	@Story("Story:Redemption Flow")
	@Test(groups = { "Regression", "Redemption Flow", "TS_001-TC_001",
			"ToBeExecutedAlways" }, dataProvider = "InvestorDetails", priority = 1, enabled = true, description = "TS_001-TC_001_Redemption: To verify Investor is able to withdraw the amount")

	public void verifyInvestorAbleToCreateNewAccount(String username, String password, String folioNumber,
			String schema, String redemptionOption, String redemptionValue) throws InterruptedException {

		System.out.println(username + password + folioNumber + schema+redemptionOption+redemptionValue);

		BaseClass baseclass = new BaseClass();
		baseclass.initialize_driver();
		LoginPage lp = new LoginPage();
		lp.clickOnInvestorTab();
		lp.enterUsernameOrPanNumber(username);
		lp.enterPassword(password);
		Thread.sleep(2000);
		
		lp.clickOnSubmitButton();
		Thread.sleep(2000);
		lp.clickOnGenerateOTPButton();
		Thread.sleep(20000);
		lp.clickOnVerifyOTPButton();
		Thread.sleep(2000);
		lp.clickOnCloseAdd();
		Thread.sleep(2000);
		lp.clickTransactNowMenu();
		Thread.sleep(2000);
		lp.clickWithdrawMenu();
		Thread.sleep(2000);
		lp.clickRedeemOption();
		Thread.sleep(10000);
		lp.chooseFolioNumber(folioNumber);
		Thread.sleep(2000);
		lp.selectSchema(schema);
		Thread.sleep(2000);
		lp.selectRedemptionValue(redemptionOption,redemptionValue);
		//lp.selectRedemptionOption();
		Thread.sleep(2000);
		lp.enterRedemptionValue(redemptionValue);
		Thread.sleep(2000);
		lp.clickOnContinueButton();

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

}
