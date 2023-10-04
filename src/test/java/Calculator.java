import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    public class Main {
        public static void main(String[] args) throws MalformedURLException {

            openCalculator();
        }
    }
    static AppiumDriver driver;
    public static  void openCalculator() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "V2027");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0.0");
        caps.setCapability("udid", ""); //the id you get when you run the adb devices command
        caps.setCapability("appPackage", "com.android.bbkcalculator");
        caps.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url,caps);
        System.out.println("Application Started");
    }


}
