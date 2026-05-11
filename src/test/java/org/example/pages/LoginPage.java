package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='login-box']//input[@data-test='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//div[@class='login-box']//input[@data-test='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[contains(@class,'login-box')]//input[@type='submit' and contains(@class,'submit-button')]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }
}
