package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.TestEnvironment;

import java.net.MalformedURLException;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    static WebDriver driver;

    @Before
    public void openBrowser() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        driver = TestEnvironment.selectTestExecutionEnvironment();
        LOGGER.info("Launch Chrome Browser");
    }

    @After
    public  void closeBrowser() {
        ActOn.browser(driver).closeBrowser();
        LOGGER.info("Close Chrome Browser");
    }
}
