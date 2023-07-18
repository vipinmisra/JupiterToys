package nz.co.planit.pages;

import org.openqa.selenium.By;

import static framework.lib.HelperMethods.sleep;

import static nz.co.planit.lib.Hooks.driver;

public abstract class Header {

    public void selectMenuItem(String menu)  {
        driver.findElement(By.linkText(menu)).click();
        sleep(1);
        driver.navigate().refresh();
    }
}
