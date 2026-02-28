package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Menu locators (span-based – stable)
    By extend = By.xpath("//span[text()='Extend']");
    By getWordPress = By.xpath("//a[contains(text(),'Get WordPress')]");

    By community = By.xpath("//span[text()='Community']");
    By photoDirectory = By.xpath("//span[text()='Photo Directory']");

    // Hover on Extend → Click Get WordPress
    public void mouseOver() {

        WebElement extendMenu =
                wait.until(ExpectedConditions.visibilityOfElementLocated(extend));

        Actions act = new Actions(driver);
        act.moveToElement(extendMenu)
           .pause(Duration.ofSeconds(1)) // visible hover
           .perform();

        wait.until(ExpectedConditions.elementToBeClickable(getWordPress)).click();
    }

    // Hover Community → Click Photo Directory
    public void photoDirectoryClick() {

        WebElement communityMenu =
                wait.until(ExpectedConditions.visibilityOfElementLocated(community));

        Actions act = new Actions(driver);
        act.moveToElement(communityMenu)
           .pause(Duration.ofSeconds(1))   // visible hover
           .click()
           .perform();

        // After reaching Community page, go to Photo Directory
        driver.navigate().to("https://wordpress.org/photos/");
    }
}