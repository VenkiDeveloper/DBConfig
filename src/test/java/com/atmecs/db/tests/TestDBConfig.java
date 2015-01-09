package com.atmecs.db.tests;

import java.util.List;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.atmecs.db.pages.BaseDBPage;
import com.atmecs.db.pages.DBConfig;
import com.atmecs.db.pages.DBDataProvider;
import com.atmecs.db.pages.DBHelper;

public class TestDBConfig {

	private String dbName;

	@Factory(dataProvider="dataMethod",dataProviderClass=DBDataProvider.class)
	public TestDBConfig(String dbName) {

		this.dbName = dbName;
	}

	@Test
	public void testDBConnection() {

		System.out.println("DBName=" + dbName);
		if (dbName.equals("all")) {
			List<DBHelper> list = BaseDBPage.getJsonDBValues(dbName);
			for (DBHelper dh : list) {
				DBConfig.dbConnection(dh.getUrl(), dh.getUsername(),
						dh.getPassword());
			}

		} else {

			List<String> list = BaseDBPage.getJsonDBValues(dbName);
			DBConfig.dbConnection(list.get(0), list.get(1), list.get(2));
		}
	}

}
