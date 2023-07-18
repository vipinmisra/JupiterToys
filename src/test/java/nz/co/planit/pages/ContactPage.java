package nz.co.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static nz.co.planit.lib.Hooks.driver;

public class ContactPage extends Header{


    @FindBy(id = "forename")
    WebElement forenameTextBox;
    @FindBy(id = "email")
    WebElement emailTextBox;
    @FindBy(id = "message")
    WebElement messageTextBox;

    @FindBy(xpath = "//a[text()='Submit']")
    WebElement submitButton;


    public ContactPage(){
        PageFactory.initElements(driver, this);
    }

    public void submitForm(Map<String, String> formData){
        for(String field : formData.keySet()){
            switch (field){
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

}
