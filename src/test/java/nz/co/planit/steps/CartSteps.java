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
        cartPage = new CartPage();

        Map<String, String> actualPricePerProduct = cartPage.getPricePerProduct();

        for (String product : productDetails.keySet()){
            Assert.assertEquals("The price value for " + product + " product do not match.",
                    "$" + productDetails.get(product).get(0), actualPricePerProduct.get(product));
        }
    }
    @Then("I validate the subtotal per product")
    public void validateSubtotalPerProduct(){
        Map<String, String> actualSubtotalPerProduct = cartPage.getSubtotalPerProduct();

        float expectedSubtotal = 0f;
        DecimalFormat df = new DecimalFormat("0.00");

        for (String product : productDetails.keySet()){
            expectedSubtotal = (Float) productDetails.get(product).get(0) * Integer.parseInt(String.valueOf(productDetails.get(product).get(1)));
            Assert.assertEquals("The subtotal value for " + product + " product do not match.",
                    "$" + df.format(expectedSubtotal), actualSubtotalPerProduct.get(product));
        }
    }

    @Then("I validate the total amount ot be paid")
    public void validateTotalAmount(){
        float expectedTotal = 0f;
        DecimalFormat df = new DecimalFormat("0.0");

        for (String product : productDetails.keySet())
            expectedTotal += (Float) productDetails.get(product).get(0) * Integer.parseInt(String.valueOf(productDetails.get(product).get(1)));

        String actualTotal = cartPage.getTotalValue();
        Assert.assertEquals("The total amount on the Cart screen is not as expected", df.format(expectedTotal), actualTotal);
    }
}
