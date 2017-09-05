package com.crm.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.utils.CommonUtils;

public class BaseConfiguration extends CommonUtils {
	
	private static Logger log = Logger.getLogger(BaseConfiguration.class.getName());
	public WebDriver wd = null;
	public Properties prop = null;
	public FileInputStream fis = null;
	
	public void invokeBrower() {
		try {
			PropertyConfigurator.configure("src//test//resources//log4j.properties");
			fis = new FileInputStream("src//test//resources//config.properties");
			prop = new Properties();
			prop.load(fis);
			String br = prop.getProperty("browser");
			
			if(br.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\ScriptDrivers\\chromedriver.exe");
				wd = new ChromeDriver();
				log.info("Browser opened Successfully");
			}
			
			else if(br.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\ScriptDrivers\\geckodriver.exe");
				wd = new FirefoxDriver();
			}
			
			else if(br.equalsIgnoreCase("iexplore")) {
				System.setProperty("webdriver.ie.driver", "C:\\ScriptDrivers\\IEDriverServer.exe");
				wd = new InternetExplorerDriver();
			}	
			
			wd.navigate().to(prop.getProperty("qa_url"));
			log.info("Page opened Successfully");
			//wd.manage().window().maximize();
			String impWait = prop.getProperty("implicity_wait");
			int iWait = Integer.parseInt(impWait);
			wd.manage().timeouts().implicitlyWait(iWait, TimeUnit.SECONDS);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
