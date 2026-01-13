package utilies;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

public class Helper {

	
	public void  readPropertyfile() throws FileNotFoundException {
		
		FileInputStream  fs = new FileInputStream(".\\config.properties");
		Properties prop = new Properties();
		try {
			prop.load(fs);
			String pageurl =prop.getProperty("url");
			System.out.println(pageurl);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
