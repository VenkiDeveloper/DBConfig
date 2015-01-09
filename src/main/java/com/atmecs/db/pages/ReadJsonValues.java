package com.atmecs.db.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonValues {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(
					"src/java/resources/project_db.json"));
			JSONObject jsonObject = (JSONObject) obj;
			// System.out.println("size="+jsonObject.size());
			List<HelperClass> list = new ArrayList();
			for (Iterator iterator = jsonObject.keySet().iterator(); iterator
					.hasNext();) {
				HelperClass hc = new HelperClass();
				
				String key = (String) iterator.next();
				// System.out.println(jsonObject.get(key));
				JSONObject json = (JSONObject) jsonObject.get(key);
				 String url = json.get("url").toString();
				 String username = json.get("username").toString();
				 String password = json.get("password").toString();
				
				 hc.setUrl(url);
				 hc.setUsername(username);
				 hc.setPassword(password);
				 list.add(hc);
				System.out.println("asdbvas"+list);
				
			}

			// JSONObject json = (JSONObject) jsonObject.get("Oracle");

			// System.out.println(json.get("url"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class HelperClass{
	
	private String url;
	private String username;
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}