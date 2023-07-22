package nz.co.planit.pages;

import org.openqa.selenium.By;

import static framework.lib.HelperMethods.sleep;
import static nz.co.planit.steps.Hooks.driver;

public abstract class Header {

    public void selectMenuItem(String menu)  {
        driver.findElement(By.xpath("//a[@href = '#/"+ menu.toLowerCase() + "']")).click();

        // There is a bug in the application; we need to refresh the contact page else cannot act on objects

        if (menu.equalsIgnoreCase("contact")) {
            sleep(1);
            driver.navigate().refresh();
        }
    }
}
