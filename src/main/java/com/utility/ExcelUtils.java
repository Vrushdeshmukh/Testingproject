package com.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelUtils {
	private static Workbook workbook;
	
	public static void loadExcel(String filepath)
	{
	 try(FileInputStream fis=new FileInputStream(filepath))
	 {
		 workbook=WorkbookFactory.create(fis);
	 }
	 catch(IOException e)
	 {
		throw new RuntimeException("x faild to load xcel file:" +filepath,e); 
	 }
		
	}
	
	public static int getRowCount(String sheetname)
	{
		Sheet sheet=workbook.getSheet(sheetname);
		return sheet.getLastRowNum();
	}
	public static int getColCount(String sheetname)
	{
		Sheet sheet=workbook.getSheet(sheetname);
		return sheet.getRow(0).getLastCellNum();
	}
	
    public static String getData(String sheetname,int row,int col)
    {
    	if(workbook == null) {
    		throw new IllegalStateException("x excel file not loaded");
    	}
    	Sheet sheet=workbook.getSheet(sheetname);
    	Row r=sheet.getRow(row);
    	Cell cell=r.getCell(col);
    	
    	DataFormatter formatter =new DataFormatter();
    	return formatter.formatCellValue(cell);
    }
    public static Object[][] getSheetData(String sheetname)
    {
    	if(workbook==null) {
    		throw new IllegalStateException("x excel file not loaded");
    	}
    	Sheet sheet=workbook.getSheet(sheetname);
    	int rowcount=sheet.getLastRowNum();
    	int colcount=sheet.getRow(0).getLastCellNum();
    	
    	Object[][] data=new Object[rowcount][colcount];
    	DataFormatter formatter=new DataFormatter();
    	
    	for(int i=1;i<=rowcount;i++) {
    		Row row=sheet.getRow(i);
    		 for(int j=0;j<colcount;j++) {
    			 Cell cell=row.getCell(j);
    			 data[i-1][j]=formatter.formatCellValue(cell);
    		 }
    	}
    	return data;
    			
    }
}   
    
    
    
    
    
    

