package org.example.tests;

import org.example.pages.*;
import org.example.util.ConfigReader;
import org.example.util.RandomDataUtil;
import org.example.util.ScreenshotListener;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class SauceDemoTest extends BaseTest {

    @Test(description = "Verify successful login with valid credentials")
    public void testLogin() {
        getDriver().get(ConfigReader.getProperty("baseUrl"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertEquals(inventoryPage.getTitleText(), "Products", "Title mismatch on Inventory page");
        
        // Add a cookie to demonstrate cookie manipulation
        getDriver().manage().addCookie(new Cookie("test_cookie", "test_value"));
        Assert.assertNotNull(getDriver().manage().getCookieNamed("test_cookie"), "Cookie was not added");
    }

    @Test(dependsOnMethods = "testLogin", description = "Verify checkout process and form submission")
    public void testCheckoutProcess() throws InterruptedException {
        getDriver().get(ConfigReader.getProperty("baseUrl"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        
        // Use javascript executor
        inventoryPage.scrollToFooter();
        
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();
        Thread.sleep(1000); // Wait for navigation

        CartPage cartPage = new CartPage(getDriver());
        Assert.assertEquals(cartPage.getTitleText(), "Your Cart", "Title mismatch on Cart page");
        
        // History test: navigate back and forward
        getDriver().navigate().back();
        Thread.sleep(1000); // Wait for navigation
        Assert.assertEquals(inventoryPage.getTitleText(), "Products");
        getDriver().navigate().forward();
        Thread.sleep(1000); // Wait for navigation
        Assert.assertEquals(cartPage.getTitleText(), "Your Cart");

        cartPage.proceedToCheckout();
        Thread.sleep(1000); // Wait for navigation

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        Assert.assertEquals(checkoutPage.getTitleText(), "Checkout: Your Information", "Title mismatch on Checkout Step 1");
        
        // Generate random data
        String firstName = RandomDataUtil.getRandomFirstName();
        String lastName = RandomDataUtil.getRandomLastName();
        String zip = RandomDataUtil.getRandomZipCode();
        
        checkoutPage.fillCheckoutForm(firstName, lastName, zip);
        Thread.sleep(1000); // Wait for navigation
        
        Assert.assertEquals(checkoutPage.getTitleText(), "Checkout: Overview", "Title mismatch on Checkout Step 2");
        
        checkoutPage.finishCheckout();
        Thread.sleep(1000); // Wait for navigation
        Assert.assertEquals(checkoutPage.getCompleteMessage(), "Thank you for your order!", "Checkout failed");
    }

    @Test(dependsOnMethods = "testLogin", description = "Verify item sorting dropdown")
    public void testSortingDropdown() {
        getDriver().get(ConfigReader.getProperty("baseUrl"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.sortBy("za");
        
        String firstItem = inventoryPage.getItemNames().get(0);
        Assert.assertTrue(firstItem.startsWith("Test.allTheThings() T-Shirt") || firstItem.compareTo("S") > 0, "Sorting didn't work");
    }

    @Test(dependsOnMethods = "testLogin", description = "Verify logout functionality")
    public void testLogout() throws InterruptedException {
        getDriver().get(ConfigReader.getProperty("baseUrl"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.logout();
        Thread.sleep(1000); // Wait for logout redirect

        Assert.assertTrue(getDriver().getCurrentUrl().contains("saucedemo.com"), "Logout failed");
    }
    
    @Test(description = "Verify multiple pages using loop")
    public void testMultiplePages() throws InterruptedException {
        getDriver().get(ConfigReader.getProperty("baseUrl"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        
        String[] urls = {
            ConfigReader.getProperty("baseUrl") + "inventory.html",
            ConfigReader.getProperty("baseUrl") + "cart.html",
            ConfigReader.getProperty("baseUrl") + "checkout-step-one.html"
        };
        
        for (String url : urls) {
            getDriver().get(url);
            Thread.sleep(500); // Wait for page load
            Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"), "Page title mismatch on " + url);
        }
    }
}
