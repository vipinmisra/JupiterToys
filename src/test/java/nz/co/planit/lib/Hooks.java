package nz.co.planit.lib;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void step(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @After
    public void teardown() throws InterruptedException {
        //driver.quit();
    }
}
