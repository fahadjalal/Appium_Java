import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass extends Reports {


    public static void main(String[] args) throws MalformedURLException {

        //openCalculator();
    }

    static AppiumDriver driver;
    static Eyes eyes;

    @BeforeTest
    public static void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "FahadJ");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0.0");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554"); //the id you get when you run the adb devices command
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.deskclock");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.deskclock.DeskClock");

//        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
//        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
//        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver(url, caps);
        eyes = new Eyes();
        eyes.setApiKey("0Q9945yrgpeoLrJTR9pzXRIo1Uh2VW897AqU1ACaLVpC0110");
        eyes.setMatchLevel(MatchLevel.STRICT);
        System.out.println("Application Started");
//        WebElement clock = driver.findElement(By.xpath("//nh[@content-desc=\"Alarm\"]/android.widget.ImageView"));
//        clock.click();
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
        eyes.abortIfNotClosed();
    }


}
