package nz.co.planit.pages;
import static nz.co.planit.lib.Hooks.driver;

public class HomePage extends Header{

    public HomePage(){
        this.navigate();
    }

    public void navigate(){
        driver.get("https://jupiter.cloud.planittesting.com/");
    }
}
