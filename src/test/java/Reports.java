import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Reports {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void reportSetUp() {
        htmlReporter = new ExtentHtmlReporter("External.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void reportTeaDown() {
        extent.flush();
    }
}
