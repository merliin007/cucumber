//
// File Created by miguel_aguilar on 5/3/2018 12:37 PM
//
package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseUtil {

    public WebDriver driver;

    public void GrabScreenShot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("target/screenshots/screenshot-"+System.currentTimeMillis()+".jpg"));

    }
}
