package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataClass {
	Properties prop;

	public ConfigDataClass() {
		File src = new File(System.getProperty("user.dir") + "\\configration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		String browserName = prop.getProperty("browser");
		return browserName;
	}

	public String getUrl() {
		String getURL = prop.getProperty("Url");
		return getURL;
	}

}
