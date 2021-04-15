import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Random;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement fetchElement(By elementlocator){
        WebDriverWait wait=new WebDriverWait(driver,20);
        return wait.until(ExpectedConditions.elementToBeClickable(elementlocator));
    }

    public String getText(By elementlocator){
        return fetchElement(elementlocator).getText();
    }

    public String takeScreenshot() throws IOException {

        File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Random random=new Random();
        String fileName="Screenshot"+random.nextInt(10000);

        Files.move
                (Paths.get(screenshot.getAbsolutePath()),
                        Paths.get(System.getProperty("user.dir")+"/report/"+fileName+".png"));
        return  fileName+".png";
    }
}
