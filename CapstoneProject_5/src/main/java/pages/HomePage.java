package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate directly to Get WordPress page
    public void mouseOverDownloadAndClickGetWordPress() {
        driver.navigate().to("https://wordpress.org/download/");
    }

    // Navigate directly to Photo Directory
    public void clickPhotoDirectory() {
        driver.navigate().to("https://wordpress.org/photos/");
    }
}
