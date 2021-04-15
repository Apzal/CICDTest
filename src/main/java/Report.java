import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Report {

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    @BeforeTest
    public void initializeReport(){

        String currentdirectory=System.getProperty("user.dir");
        extentSparkReporter=new ExtentSparkReporter(currentdirectory+"/report/extentreport.html");
        extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Application","Demo");
    }

    public static void CreateTest(String testName){
        extentTest= extentReports.createTest(testName);
    }


    @AfterTest
    public void CloseReport(){
        extentReports.flush();
    }





}
