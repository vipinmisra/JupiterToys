package framework.lib;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class HelperMethods {

    public static void sleep(int seconds)  {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch( InterruptedException e){}
    }

    public static void waitForElement(WebElement element, int seconds){
        int trials = 0;
        while(trials < seconds) {
            try {
                element.getSize();
                return;
            } catch (NoSuchElementException e) {}

            trials++;
            sleep(1);
        }
    }
}
