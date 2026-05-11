package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='header_container']//button[text()='Open Menu']")
    private WebElement menuButton;

    @FindBy(xpath = "//div[@class='bm-menu']//a[@id='logout_sidebar_link']")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@class='inventory_list']//button[contains(text(),'Add to cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        waitForVisibility(pageTitle);
        return pageTitle.getText();
    }

    public void logout() {
        click(menuButton);
        click(logoutLink);
    }

    public void addFirstItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            click(addToCartButtons.get(0));
        }
    }

    public void goToCart() {
        waitForVisibility(cartLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cartLink);
    }

    public void sortBy(String value) {
        waitForVisibility(sortDropdown);
        Select select = new Select(sortDropdown);
        select.selectByValue(value);
    }

    public List<String> getItemNames() {
        return itemNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void scrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
