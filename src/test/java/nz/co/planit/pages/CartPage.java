package nz.co.planit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.Map;

import static nz.co.planit.lib.Hooks.driver;
import static framework.lib.HelperMethods.*;

public class CartPage {

    @FindBy(id = "forename")
    WebElement forenameTextBox;
    @FindBy(xpath = "//*[contains(@class, 'total')]")
    WebElement totalLabel;


    public CartPage(){
        PageFactory.initElements(driver, this);

        sleep(1);
    }

    public String getTotalValue(){
        return totalLabel.getText().split(" ")[1];
    }
}
