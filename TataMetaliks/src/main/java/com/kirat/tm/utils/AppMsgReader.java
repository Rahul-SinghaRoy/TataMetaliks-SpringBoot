package com.kirat.tm.utils;



import java.io.InputStream;
import java.util.Properties;

import com.kirat.tm.constants.AppMsgProp;



public class AppMsgReader {

	private static Properties prop = null;

	private static void loadPropertiesFile() {
		try {
			if (prop == null) {
				prop = new Properties();
				InputStream in = OLCUtil.class.getClass().getResourceAsStream(AppMsgProp.CONFIGURATION_FILE_NAME);
				if (in == null) {
					in = new OLCUtil().getClass().getClassLoader().getResourceAsStream(AppMsgProp.CONFIGURATION_FILE_NAME);
				}
				prop.load(in);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getValue(String key) {
		loadPropertiesFile();
		String value = "";
		try {
			value = prop.getProperty(key).toString();
			return value;
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return value;
	}
}
