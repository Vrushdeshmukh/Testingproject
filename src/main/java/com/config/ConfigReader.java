package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
   
	private static Properties prop;//??
	
	public static void loadConfig() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/resources/Config.properties";
		FileInputStream fis=new FileInputStream(path);
		prop=new Properties();
		prop.load(fis);
		
	}
	 public static String get(String key)
	 {
		 return prop.getProperty(key);
	 }

	
}
