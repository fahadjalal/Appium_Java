package com.qa.base;

import com.qa.utils.ConfigReader;
import com.qa.utils.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppFactory {
    public static AppiumDriver driver;
    public static ConfigReader configReader;

    @BeforeTest
    @Parameters({"platformName", "platformVersion", "deviceName"})
    public void init(String platformName, String platformVersion, String deviceName) throws MalformedURLException {
        try {
            configReader = new ConfigReader();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configReader.getAppPackage());
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configReader.getAppActivity());
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, configReader.getAutomationName());
            caps.setCapability(MobileCapabilityType.NO_RESET, configReader.getNoReset());
            URL url = new URL(configReader.getURL());
            driver = new AndroidDriver(url, caps);
            AppDriver.setDriver(driver);
            System.out.println("Application Started");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.WAIT));
    }

    public String getAttribute_(WebElement element, String attr) {
        return element.getAttribute(attr);
    }

    public void sendKeys_(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    @AfterTest
    public static void quiteDriver() {
        driver.quit();
    }
}


