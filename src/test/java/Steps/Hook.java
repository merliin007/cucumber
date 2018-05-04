//
// File Created by miguel_aguilar on 5/3/2018 12:27 PM
//
package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        System.out.println("opening browser: Firefox");
        File src = new File("src");
        File gecko = new File(src, "geckodriver.exe");

        System.setProperty("webdriver.firefox.marionette", gecko.getAbsolutePath());
        base.driver = new FirefoxDriver();
        base.driver.manage().window().maximize();

    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot
            System.out.println(scenario.getName());
        }
        System.out.println("Closing browser: MOCK");
        if(base.driver!=null) {
            base.driver.close();
        }
    }
}
