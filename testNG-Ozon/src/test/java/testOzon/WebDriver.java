package testOzon;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WebDriver {
    public FirefoxDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void close() {
        driver.close();
    }
}
