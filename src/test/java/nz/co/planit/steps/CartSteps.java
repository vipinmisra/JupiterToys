package nz.co.planit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import nz.co.planit.pages.CartPage;
import nz.co.planit.pages.ShopPage;
import org.junit.Assert;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class CartSteps {

    ShopPage shopPage;
    CartPage cartPage;
    Map<String, List<Object>> productDetails;

    @When("I choose to buy the following products")
    public void choseProductsToBuy(DataTable dataTable){

        Map<String, String> productsData = dataTable.asMap(String.class, String.class);

        shopPage = new ShopPage();
        productDetails = shopPage.addProducts(productsData);
    }

    @Then ("I validate the price displayed per product")
    public void validatePricePerProduct(){
        for (String product : productDetails.keySet()){
            System.out.println(product);
            System.out.println("--------");
            System.out.println(productDetails.get(product).get(0));
            System.out.println(productDetails.get(product).get(1));
            System.out.println();
        }
    }
    @Then("I validate the subtotal per product")
    public void validateSubtotalPerProduct(){

    }

    @Then("I validate the total amount ot be paid")
    public void validateTotalAmount(){
        float expectedTotal = 0f;
        DecimalFormat df = new DecimalFormat("0.0");

        for (String product : productDetails.keySet()){

            expectedTotal += (Float) productDetails.get(product).get(0) * Integer.parseInt(String.valueOf(productDetails.get(product).get(1)));
        }


        CartPage cartPage = new CartPage();
        String actualTotal = cartPage.getTotalValue();

        System.out.println("Expected total " + df.format(expectedTotal));
        System.out.println("Actual total " + actualTotal);

        Assert.assertEquals(df.format(expectedTotal), actualTotal);
    }
}
