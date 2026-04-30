import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;


public class FirstSeleniumTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }
    
    @Test
    public void testSearch() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("Eötvös Loránd University"));

        SearchResultPage searchResultPage = mainPage.search("Student guide 2025");
        String bodyText = searchResultPage.getBodyText();
        Assert.assertTrue(bodyText.contains("Searched content"));
        Assert.assertTrue(bodyText.contains("Student guide 2025/26"));
    }

    @Test
    public void testSearch2() {
        String[] searchQueries={"something","asd","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"};
        for(String searchQuery : searchQueries) {
            MainPage mainPage = new MainPage(this.driver);
            SearchResultPage searchResultPage = mainPage.search(searchQuery);
            String bodyText = searchResultPage.getBodyText();
            Assert.assertTrue(bodyText.contains("Searched content"));
        }  
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
