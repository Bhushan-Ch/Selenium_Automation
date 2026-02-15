package utils;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void initConfig() throws IOException {
        String env = System.getProperty("env", "sit").toLowerCase();

        String filePath = "src/main/resources/config/env." + env + ".properties";

        FileInputStream fis = new FileInputStream(filePath);
        prop = new Properties();
        prop.load(fis);
    }


    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}

	
	


