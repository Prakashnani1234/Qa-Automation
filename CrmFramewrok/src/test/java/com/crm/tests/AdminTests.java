package com.crm.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.data.CrmData;
import com.crm.services.CrmServices;
import com.crm.validators.AdminValidator;

public class AdminTests {
	
	public CrmServices crmservice = null;
	public CrmData crmdata = null;
	public AdminValidator adminvalidator = null;
	
	@BeforeClass 
	public void init() throws IOException, InterruptedException {
		crmservice = new CrmServices();
		crmdata = new CrmData();
		adminvalidator = new AdminValidator();
		crmservice.openCrmHomePage().loginToCrm(crmdata.getCrmData().getRow(1).getCell(0).getStringCellValue(), crmdata.getCrmData().getRow(1).getCell(1).getStringCellValue());	
	}
	
	@Test(description = "Create Account with valid data", priority = 1)
	public void createAccountWithValidDataq() throws IOException, InterruptedException {
		crmservice.navigateToAccounts().clickOnCreateAccount().insertCreateAccountName(crmdata.getCrmData().getRow(1).getCell(2).getStringCellValue());
		crmservice.insertCreateAccountEmail(crmdata.getCrmData().getRow(1).getCell(3).getStringCellValue());
//		double phone = crmdata.getCrmData().getRow(1).getCell(4).getNumericCellValue();
		crmservice.insertCreateAccountPhone("9798786786").enterAccountWebsite(crmdata.getCrmData().getRow(1).getCell(5).getStringCellValue());
		crmservice.enterBillingAddressStreet(crmdata.getCrmData().getRow(1).getCell(6).getStringCellValue());
		crmservice.enterBillingAddressCity(crmdata.getCrmData().getRow(1).getCell(7).getStringCellValue());
		crmservice.enterBillingAddressState(crmdata.getCrmData().getRow(1).getCell(8).getStringCellValue());
		crmservice.enterPostalCode().enterBillingAddressCountry(crmdata.getCrmData().getRow(1).getCell(9).getStringCellValue());
		crmservice.enterShippingAddressAccountPage().enterDetailsAccountPage().clickSaveButtonAccountsPage();
		crmservice.getCreateAccountNameFromAccountsPage();
		adminvalidator.validateCreateAccount(crmservice);
		crmservice.getBillingAddress();
		adminvalidator.validateAccountBillingAddress(crmservice);
	}
	

}
