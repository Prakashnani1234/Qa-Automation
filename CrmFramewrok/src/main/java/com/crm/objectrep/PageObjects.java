package com.crm.objectrep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PageObjects {
	
	public Properties prop = null;
	public FileInputStream obfis = null;
	
	public Properties getPageObjects() throws IOException {
		obfis = new FileInputStream("src//test//resources//crm_or.properties");
		prop = new Properties();
		prop.load(obfis);
		return prop;
	}

}
