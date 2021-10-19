package com.cts.acemoney.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	File f;
	
	FileInputStream fis;
	
	XSSFWorkbook wb;
	
	XSSFSheet sh;
	
	public ExcelConfig(String ExcelPath)
	{
		try
		{
		f=new File(ExcelPath);
		
		fis=new FileInputStream(f);
		
		wb=new XSSFWorkbook(fis);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public int getRowSize(String sheetname)
	{
	  sh = wb.getSheet(sheetname);
	  
	  int rowcount=sh.getLastRowNum()+1;
	  
	  return rowcount;
		
	}
	
	
	public int getColSize(String sheetname)
	{
		sh=wb.getSheet(sheetname);
		
		short colCount=sh.getRow(0).getLastCellNum();
		
		return colCount;
	}
	
	
	public String getExcelData(String sheetname, int row, int col)
	{
		sh=wb.getSheet(sheetname);
		
		String data=sh.getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}

}
