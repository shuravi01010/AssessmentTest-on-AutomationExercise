package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        final Calendar cal = Calendar.getInstance();
        DateFormat dateFormat1 = new SimpleDateFormat("dd-M-yyyy hh");
        String date = dateFormat1.format(cal.getTime());
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/smartGuess" + date + ".html");
        reporter.config().setReportName("AutomationExercise");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Shuravi Parvin");
        extentReports.setSystemInfo("Position", "Test Automation Engineer");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        return extentReports;
    }
}
