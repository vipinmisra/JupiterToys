package nz.co.planit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.Map;

import static nz.co.planit.steps.Hooks.driver;
import static framework.lib.HelperMethods.*;

public class ContactPage extends Header {


    @FindBy(id = "forename")
    WebElement forenameTextBox;
    @FindBy(id = "email")
    WebElement emailTextBox;
    @FindBy(id = "message")
    WebElement messageTextBox;

    @FindBy(xpath = "//span[contains(@ui-if, 'form.forename')]")
    WebElement forenameErrorMessageLabel;
    @FindBy(xpath = "//span[contains(@ui-if, 'form.email')]")
    WebElement emailErrorMessageLabel;
    @FindBy(xpath = "//span[contains(@ui-if, 'form.message')]")
    WebElement messageErrorMessageLabel;

    @FindBy(linkText = "Submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    WebElement successMessageLabel;
    @FindBy(linkText = "« Back")
    WebElement backButton;

    public ContactPage() {
        PageFactory.initElements(driver, this);
        waitForElement(forenameTextBox, 10);
    }

    public void enterFormData(Map<String, String> formData, boolean submitFormData) {
        for (String field : formData.keySet()) {
            switch (field) {
                case "Forename":
                    forenameTextBox.sendKeys(formData.get(field));
                    break;
                case "Email":
                    emailTextBox.sendKeys(formData.get(field));
                    break;
                case "Message":
                    messageTextBox.sendKeys(formData.get(field));
            }
        }

        // click on submit button if asked to
        if(submitFormData)
            submitButton.click();
    }

    public Map<String, String> getErrorMessages() {
        Map<String, String> errorMessages = new HashMap<>();
        String foreName = "";
        String email = "";
        String message = "";

        try {
            foreName = forenameErrorMessageLabel.getText();
        } catch (Exception e) {}

        try {
            email = emailErrorMessageLabel.getText();
        } catch (Exception e) {}

        try {
            message = messageErrorMessageLabel.getText();
        } catch (Exception e) {}

        errorMessages.put("Forename", foreName);
        errorMessages.put("Email", email);
        errorMessages.put("Message", message);

        return errorMessages;
    }

    public String getSuccessMessage() {
        waitForElement(successMessageLabel, 60);
        return successMessageLabel.getText();
    }
}
