package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
		
		 Properties pro;

		public ConfigReader() {
			File src = new File("./src/test/resources/configuration/config.properties");

			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
		}
		
		public String getXlpath() {
			String xlPath = pro.getProperty("excel_path");
			return xlPath;
		}
			
		public int get_InvaliduserID() {
			String getInvaliduserID = pro.getProperty("InvaliduserID");
			
			return Integer.parseInt(getInvaliduserID);		
		}
		
		public int get_userId() {
			String getuserId = pro.getProperty("userId");
			
			return Integer.parseInt(getuserId);		
		}
	}
