package com.atmecs.db.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BaseDBPage {

	
	public static List getJsonDBValues(String dbName) {

		final String fileName = "src/java/resources/project_db.json";
		if (dbName.equals("all")) {

			JSONObject jsonObject = (JSONObject) readJsonFile(fileName);
			List<DBHelper> list = new ArrayList();
			for (Iterator iterator = jsonObject.keySet().iterator(); iterator
					.hasNext();) {
				DBHelper hc = new DBHelper();

				String key = (String) iterator.next();
				JSONObject json = (JSONObject) jsonObject.get(key);
				String url = json.get("url").toString();
				String username = json.get("username").toString();
				String password = json.get("password").toString();

				hc.setUrl(url);
				hc.setUsername(username);
				hc.setPassword(password);
				list.add(hc);

			}

			return list;
		} else {

			List<String> list = new ArrayList();
			String url = "", username = "", password = "";
			JSONObject jsonObject = (JSONObject) readJsonFile(fileName);
			JSONObject json = (JSONObject) jsonObject.get(dbName);
			url = json.get("url").toString();
			username = json.get("username").toString();
			password = json.get("password").toString();
			list.add(url);
			list.add(username);
			list.add(password);
			return list;
		}
	}



	public static  Object readJsonFile(String fileName) {
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {

			obj = parser.parse(new FileReader(fileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
