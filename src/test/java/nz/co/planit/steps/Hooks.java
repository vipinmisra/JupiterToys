package nz.co.planit.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import framework.lib.PropertiesHandler;


public class Hooks {

    public static WebDriver driver;
    public static Properties properties;

    @Before
    public void step(){
        // create a chrome driver object
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // read the properties
        properties = new PropertiesHandler().loadProperties("src/test/resources/global.properties");
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
