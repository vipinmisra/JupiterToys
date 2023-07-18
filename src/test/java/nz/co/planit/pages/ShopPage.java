package nz.co.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nz.co.planit.lib.Hooks.driver;
import static framework.lib.HelperMethods.*;

public class ShopPage {

    @FindBy(linkText = "Buy")
    WebElement buyButton;

    public ShopPage(){
        PageFactory.initElements(driver, this);
        waitForElement(buyButton, 10);
    }

    public Map<String, List<Object>> addProducts (Map<String, String> productsData){
        Map<String, List <Object>> productDetails = new HashMap<>();

        for(String product : productsData.keySet()){
            // pick the price of the product
            float price = Float.parseFloat(driver.findElement(By.xpath("//h4[text() = '" + product
                    + "']/..//span")).getText().replace("$", ""));

            // click on the buy button for the number of times specified as quantify
            for(int index = 0; index <  Integer.parseInt(productsData.get(product)); index++) {
                driver.findElement(By.xpath("//h4[text() = '" + product
                        + "']/..//a")).click();
            }

            // add the price and quantity of each product to the map
            ArrayList<Object> detailsList = new ArrayList<>();
            detailsList.add(price);
            detailsList.add(productsData.get(product));
            productDetails.put(product, detailsList);
        }
        return productDetails;
    }
}
