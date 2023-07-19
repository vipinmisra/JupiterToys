package nz.co.planit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.Map;

import static nz.co.planit.lib.Hooks.driver;
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
        // There is a bug in the application; we need to refresh the contact page else cannot act on objects
        sleep(1);
        driver.navigate().refresh();
        waitForElement(forenameTextBox, 10);
    }

    public void submitForm(Map<String, String> formData) {
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

        // click on submit button
        submitButton.click();
    }

    public Map<String, String> getErrorMessages() {
        Map<String, String> errorMessages = new HashMap<>();
        try {
            errorMessages.put("Forename", forenameErrorMessageLabel.getText());
        } catch (Exception e) {
        }
        try {
            errorMessages.put("Email", emailErrorMessageLabel.getText());
        } catch (Exception e) {
        }
        try {
            errorMessages.put("Message", messageErrorMessageLabel.getText());
        } catch (Exception e) {
        }
        return errorMessages;
    }

    public boolean doesErrorMessageExist(String field) {
        boolean exists = false;

        // wait for the back button
        waitForElement(backButton, 60);

        try {
            switch (field.toLowerCase()) {
                case "forename":
                    forenameErrorMessageLabel.getText();
                    break;
                case "email":
                    emailErrorMessageLabel.getText();
                    break;
                case "message":
                    messageErrorMessageLabel.getText();
                    break;
            }
            exists = true;
        } catch (Exception e) {
        }

        return exists;
    }

    public String getSuccessMessage() {
        waitForElement(successMessageLabel, 60);
        return successMessageLabel.getText();
    }
}
