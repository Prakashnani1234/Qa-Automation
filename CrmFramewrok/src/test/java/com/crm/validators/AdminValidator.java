package com.crm.validators;



import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;

import com.crm.data.CrmData;
import com.crm.services.CrmServices;

public class AdminValidator {

	public CrmData crmdata = new CrmData();
	
	public void validateCreateAccount(CrmServices crmservice) throws IOException, InterruptedException {
		Assert.assertEquals(crmservice.getCreateAccountNameFromAccountsPage(), crmdata.getCrmData().getRow(1).getCell(2).getStringCellValue());	
	}
	
	public void validateAccountBillingAddress(CrmServices crmservice) {
		String arr[] = {"abcd"+"/n"+"Hyd,", "TS", "1234", "India"};
		//String city = "Hyd";
		//ArrayList<String> list = new ArrayList<String>();
		String[] list = crmservice.getBillingAddress();
		for(int i = 1; i<arr.length-2; i++) {
//			System.out.println(arr[i]);
//			System.out.println("+++++++++");
//			System.out.println(list[i]);
//			System.out.println("=========");
			Assert.assertEquals(arr[i], list[i]);
		}
		
	}
}
