package com.atmecs.db.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.atmecs.db.pages.BaseDBPage;
import com.atmecs.db.pages.DBConfig;
import com.atmecs.db.pages.DBHelper;

public class TestDBConfig {

//	@Parameters("dbName")
	@Test
	public void testDBConnection() {
         //which reads the value from the maven pom.xml system config properties
		String dbName = System.getProperty("dbName");
		System.out.println("DBName="+dbName);
		if (dbName.equals("all")) {
			List<DBHelper> list = BaseDBPage.getJsonDBValues(dbName);
			for (DBHelper dh : list) {
				DBConfig.dbConnection(dh.getUrl(),dh.getUsername(),dh.getPassword());
			}

		} else {

			List<String> list = BaseDBPage.getJsonDBValues(dbName);
			DBConfig.dbConnection(list.get(0), list.get(1), list.get(2));
		}
	}

	
}
