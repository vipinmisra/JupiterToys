package nz.co.planit.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.Properties;
import framework.lib.PropertiesHandler;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Hooks {

    public static WebDriver driver;
    public static Properties properties;

    @Before
    public void step(){



        // read the properties
        properties = new PropertiesHandler().loadProperties("src/test/resources/global.properties");

        // read from the property file the browse to run the tests on
        String browser = properties.getProperty("BROWSER");

        // create driver object based on the browser requested
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
