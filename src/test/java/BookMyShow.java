import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BookMyShow{

    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        driver= Browser.openBrowser("chrome","https://in.bookmyshow.com/");

    }
    @Test
    public void checkCity() throws IOException {
        Report.CreateTest("CheckCity");
        Report.extentTest.log(Status.INFO,"Checking City");
        HomePage homePage=new HomePage(driver);
        homePage.verifyCity();
    }

    @Test
    public void checkCity2() throws IOException {
        Report.CreateTest("CheckCity2");
        Report.extentTest.log(Status.INFO,"Checking City");
        HomePage homePage=new HomePage(driver);
        homePage.verifyCity();
    }

    @AfterMethod
    public void tearDown(){
        Browser.closeBrowser(driver);
    }
}
