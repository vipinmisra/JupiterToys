package nz.co.planit.pages;

import org.openqa.selenium.By;

import static nz.co.planit.steps.Hooks.driver;

public abstract class Header {

    public void selectMenuItem(String menu)  {
        driver.findElement(By.xpath("//a[@href = '#/"+ menu.toLowerCase() + "']")).click();
    }
}
