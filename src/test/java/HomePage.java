import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BasePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By txtSearchbox=By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']");
    private By txtMovieNameResult=By.xpath("//h1[contains(@class,'styles__EventHeading')]");
    private By imgCityChennai=By.xpath("//img[@alt='CHEN']");
    private By txtBoxMovie=By.xpath("//span[contains(text(),'Search for Movies')]");
    private By dropdwnCheckMovie=By.xpath("//span[contains(@class,'ellipsis')]");


    public void verifyCity() throws IOException {
        SelectCity();
        Assert.assertEquals(getText(dropdwnCheckMovie),"Chennai");
        Report.extentTest.log(Status.PASS,"City Changed to Chennai", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
    }
//   public void SearchMovie(String movieName) throws InterruptedException {
//       SelectCity();
//       Thread.sleep(2000);
//       WebElement element;
//       click(txtBoxMovie);
//       element=fetchElement(txtSearchbox);
//       Thread.sleep(2000);
//       element.sendKeys(Keys.ENTER);
//       Assert.assertEquals(getMovieName(),movieName,"Movie Name not matching");
//       check
//   }

   public void SelectCity(){
       driver.findElement(imgCityChennai).click();
   }


   private String getMovieName(){
       return  fetchElement(txtMovieNameResult).getText();
   }
}
