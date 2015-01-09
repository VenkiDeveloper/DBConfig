package com.atmecs.db.pages;
import org.testng.annotations.DataProvider;


public class DBDataProvider {

	@DataProvider(name="dataMethod")
	public static Object[][] dbData(){
		
		return new Object[][]{
				
				{"MS"},{"Oracle"},{"all"}
		};
		
	}
	
	
}
