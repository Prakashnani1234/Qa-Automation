package com.crm.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CrmData {
	
	public FileInputStream dfis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public HSSFSheet getCrmData() throws IOException {
		FileInputStream dfis = new FileInputStream("src//test//CrmData.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(dfis);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		return sheet;	
	}

}
