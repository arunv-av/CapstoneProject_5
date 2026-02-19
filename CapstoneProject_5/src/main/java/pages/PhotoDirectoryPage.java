package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotoDirectoryPage {

    WebDriver driver;
    WebDriverWait wait;

    // Photo cards on search result page
    By photos = By.cssSelector("article, figure");

    public PhotoDirectoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Direct URL-based search (stable)
    public void searchPhoto(String photoName) {
        driver.navigate().to(
                "https://wordpress.org/photos/search/" + photoName + "/"
        );
    }

    public boolean areImagesDisplayed() {

        List<WebElement> imageList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(photos, 0)
        );

        return imageList.size() > 0;
    }
}
