package nz.co.planit.pages;

import org.openqa.selenium.By;
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

    public Map<String, String> getPricePerProduct(){
        Map<String, String> pricePerProduct = new HashMap<>();
        int numbrOfRows = driver.findElements(By.xpath("//tbody/tr")).size();

        for(int row = 1; row <= numbrOfRows; row++){
            String productName = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[1]")).getText();
            String priceValue = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[2]")).getText();

            pricePerProduct.put(productName, priceValue);
        }

        return pricePerProduct;
    }

    public Map<String, String> getSubtotalPerProduct(){
        Map<String, String> subtotalPerProduct = new HashMap<>();
        int numbrOfRows = driver.findElements(By.xpath("//tbody/tr")).size();

        for(int row = 1; row <= numbrOfRows; row++){
            String productName = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[1]")).getText();
            String priceValue = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[4]")).getText();

            subtotalPerProduct.put(productName, priceValue);
        }

        return subtotalPerProduct;
    }
}
