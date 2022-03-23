package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary excel = new NewExcelLibrary();
	
	
	@DataProvider(name = "creds")
	
	public Object[][] getCreds(){
		//total row count
		
		int rows = excel.getRowCount("Credentials");
		//total columns count
		
		int columns = excel.getColumnCount("Credentials");
		
		int actRows = rows-1;
		
		Object[][] data = new Object[actRows][columns];		
		
		for(int i =0; i<actRows; i++) {
			for(int j=0;j<columns;j++) {
				data[i][j] = excel.getCellData("Credentials", j,i+2);
				
			}
		}
		return data;
	}
	
	

}
