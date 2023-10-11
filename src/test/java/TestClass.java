import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {
    ExtentTest extenttest;
    @Test
    public void openBrowser() {
        System.out.println("Test openBrowser Started");
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Appium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("Test openBrowser Completed");
    }

    @Test
    public void openClock() {
        extenttest = extent.createTest("Clock Started");
        extenttest.log(Status.INFO,"This will click on the alarm icon");
        WebElement alarm = driver.findElement(By.xpath("//nh[@content-desc=\"Alarm\"]/android.widget.ImageView"));
        alarm.click();
        WebElement addAlarm = driver.findElement(By.id("com.google.android.deskclock:id/fab"));
        addAlarm.click();
        extenttest.log(Status.PASS, "Test is pass");
    }


}
