package com.qa.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;


    public ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "Configuration/Config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Configuration.properties not found" + propertyFilePath);
        }
    }

    public String getPlatformName() {
        String platformName = properties.getProperty("platformName");
        if (platformName != null)
            return platformName;
        else
            throw new RuntimeException("Platform name is not define in config file");
    }

    public String getAutomationName() {
        String automationName = properties.getProperty("automationName");
        if (automationName != null) return automationName;
        else throw new RuntimeException("Automation Name is not define in config file");
    }

    public String getAppPackage() {
        String appPackage = properties.getProperty("appPackage");
        if (appPackage != null) return appPackage;
        else throw new RuntimeException("AppPackage is not define in config file");
    }

    public String getAppActivity() {
        String appActivity = properties.getProperty("appActivity");
        if (appActivity != null) return appActivity;
        else throw new RuntimeException("appActivity is not define in config file");
    }

    public String getApkPath() {
        String apkPath = properties.getProperty("apkPath");
        if (apkPath != null) return apkPath;
        else throw new RuntimeException("apkPath is not define in config file");
    }

    public String getNoReset() {
        String noReset = properties.getProperty("noReset");
        if (noReset != null) return noReset;
        else throw new RuntimeException("noReset is not define in config file");
    }

    public String getURL() {
        String URL = properties.getProperty("URL");
        if (URL != null) return URL;
        else throw new RuntimeException("URL is not define in config file");
    }

}
