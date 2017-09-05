package com.crm.config;

public enum CrmPageConstants {

	CRM_LOGIN_PAGE_TITLE("EspoCRM"),
	CRM_ACCOUNTS_PAGE_TITLE("Accounts"),
	CRM_CREATEACCOUNT_PAGE_TITLE("Create Account");
	
	private String title;
	
	CrmPageConstants(String title) {
		this.title = title;
	}
	
	public String title() {
		return title;
	}
}
