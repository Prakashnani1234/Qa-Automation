package com.crm.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.crm.config.BaseConfiguration;
//import com.crm.config.CrmPageConstants;
import com.crm.objectrep.PageObjects;
import com.crm.utils.CommonUtils;

public class CrmServices extends BaseConfiguration {
	
	private static Logger log = Logger.getLogger(CrmServices.class.getName());
	public PageObjects pageObj;
	
	public CrmServices openCrmHomePage() {
		pageObj = new PageObjects();
		invokeBrower();
		return this;
	}
	
	public CrmServices loginToCrm (String uname, String pword) throws IOException, InterruptedException {
		CommonUtils.insertText("id", pageObj.getPageObjects().getProperty("crmhomepage_username_txtfieldid"), uname, wd);
		CommonUtils.insertText("id", pageObj.getPageObjects().getProperty("crmhomepage_password_txtfieldid"), pword, wd);
		CommonUtils.clickButton("id", pageObj.getPageObjects().getProperty("crmhomepage_login_buttonid"), wd);
		//CommonUtils.validatePage(CrmPageConstants.CRM_LOGIN_PAGE_TITLE.title(), wd);
		CommonUtils.wait(2);
		log.info("User logged in successfully");
		return this;
	}

	public CrmServices navigateToAccounts() throws IOException, InterruptedException {
		CommonUtils.clickLink("link", pageObj.getPageObjects().getProperty("crm_dashboard_accountslink"), wd);
		CommonUtils.wait(2);
		return this;
	}
	
	public CrmServices clickOnCreateAccount() throws IOException, InterruptedException {
		CommonUtils.clickLink("link", pageObj.getPageObjects().getProperty("crm_accounts_createaccountlink"), wd);
		CommonUtils.wait(2);
		return this;
	}
	
	public CrmServices insertCreateAccountName(String name) throws IOException {
		CommonUtils.insertText("name", pageObj.getPageObjects().getProperty("create_account_name"), name, wd);
		return this;
	}
	
	public CrmServices insertCreateAccountEmail(String mail) throws IOException {
		CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("create_account_email"), mail, wd);
		return this;
	}

	public CrmServices insertCreateAccountPhone(String phone) throws IOException {
		CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("create_account_phone"), phone, wd);
		return this;
	}
	
	public CrmServices enterAccountWebsite(String website) throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_website_textbox"), website, wd);
    	return this;
    }
    

    public CrmServices enterBillingAddressStreet(String streetBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_billingaddress_street"), streetBillingAddress, wd);
    	return this;
    }
    public CrmServices enterBillingAddressCity(String cityBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_billingaddress_city"), cityBillingAddress, wd);
    	return this;
    	
    }
    public CrmServices enterBillingAddressState(String stateBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_billingaddress_state"), stateBillingAddress, wd);
    	return this;
    	
    }
    public CrmServices enterPostalCode() throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_billingaddress_postalcode"), "1234", wd);
    	return this;   	
    	
    }
    public CrmServices enterBillingAddressCountry(String countryBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_billingaddress_country"), countryBillingAddress, wd);
    	return this;
    	
    }
     public CrmServices enterShippingAddressAccountPage() throws IOException {
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_shippingaddress_street"), "KPHB", wd);
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_shippingaddress_city"), "hyd", wd);
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_shippingaddress_state"), "AP", wd);
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_shippingaddress_postalcode"), "1234", wd);
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_shippingaddress_country"), "INDIA", wd);
    	
    	return this;
    	
    }
    public CrmServices enterDetailsAccountPage() throws IOException {
    	CommonUtils.selectDropDownItem("css", pageObj.getPageObjects().getProperty("crm_details_type_dropdown"), "text", "Investor", wd);
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_details_siccode_textbox"), "1234", wd);
    	CommonUtils.selectDropDownItem("css", pageObj.getPageObjects().getProperty("crm_details_industry"), "text", "Agriculture", wd);
    	CommonUtils.insertText("css", pageObj.getPageObjects().getProperty("crm_details_description"), "desciption entered here", wd);
    	
    	
    	return this;
    }
    public CrmServices clickSaveButtonAccountsPage() throws IOException, InterruptedException {
    	Thread.sleep(3000);
    	CommonUtils.clickButton("css", pageObj.getPageObjects().getProperty("crm_accountspage_save_button"), wd);
    	return this;
    }
    
    public String getCreateAccountNameFromAccountsPage() throws IOException, InterruptedException {
    	CommonUtils.wait(2);
    	String txt = CommonUtils.getTextFromPage("css", pageObj.getPageObjects().getProperty("accountpage_accountname"), wd);
    	return txt;
    }
    
    public String[] getBillingAddress() {
    	String txt = wd.findElement(By.cssSelector("div[data-name='billingAddress']>div")).getText();
    	//System.out.println(txt);
    	ArrayList<String> list = new ArrayList<String>();
    	String[] txt1 = txt.split(" ");
    	List<String> newList = Arrays.asList(txt1);
    	for(int i = 0; i < 1; i++) {
	    	if(!txt1[0].isEmpty()) {
				String[] txt2 = txt1[0].split("H");
				List<String> aList = new ArrayList<String>();
				String a1 = txt2[i];
				aList.add(a1);
				System.out.println(aList);
				
				//System.out.println(txt2[0]);
				//System.out.println("H"+txt2[1]);
			}
    	}
    	
    	//System.out.println(list);
//    	ArrayList aList= new ArrayList(Arrays.asList(txt.split(" ")));
//    	for(int i=0;i<aList.size();i++)
//    	{
//    	    System.out.println(aList.get(i));
//    	}
//    	System.out.println(aList);
    	return txt1;
    }
	
}
