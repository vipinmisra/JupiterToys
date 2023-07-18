package nz.co.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static nz.co.planit.lib.Hooks.driver;

public abstract class Header {

    public void selectMenuItem(String menu){
        driver.findElement(By.linkText(menu)).click();
        driver.navigate().refresh();
    }
}
