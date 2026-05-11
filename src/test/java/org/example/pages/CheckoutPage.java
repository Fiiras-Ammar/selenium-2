package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        waitForVisibility(pageTitle);
        return pageTitle.getText();
    }

    public void fillCheckoutForm(String firstName, String lastName, String zipCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(zipCodeInput, zipCode);
        continueButton.submit();
    }

    public void finishCheckout() {
        click(finishButton);
    }

    public String getCompleteMessage() {
        waitForVisibility(completeHeader);
        return completeHeader.getText();
    }
}
