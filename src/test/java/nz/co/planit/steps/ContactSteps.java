package nz.co.planit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import nz.co.planit.pages.ContactPage;
import nz.co.planit.pages.HomePage;
import nz.co.planit.lib.Hooks;

import java.util.Map;

public class ContactSteps {


    HomePage homePage;
    ContactPage contactPage;


    @Given("I am on the Jupiter Toys home page")
    public void i_am_on_the_jupiter_toys_home_page() {
        homePage = new HomePage();
    }


    @Given("^I navigate to (.*) page$")
    public void i_navigate_to_contact_page(String menu) {
        homePage.selectMenuItem(menu);
    }

    @When("I submit the form with the following values")
    public void i_submit_the_form_with_the_following_values(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);

        contactPage = new ContactPage();
        contactPage.submitForm(formData);

    }

    @Then("I should get the following error messages")
    public void i_should_get_the_following_error_messages(DataTable dataTable) {

    }

    @Then("I should not get any error messages")
    public void i_should_not_get_any_error_messages() {

    }

}
