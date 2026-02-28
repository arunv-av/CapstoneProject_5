package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DownloadPage;
import pages.HomePage;
import pages.PhotoDirectoryPage;

public class WordPressSteps extends BaseTest {

    HomePage homePage;
    DownloadPage downloadPage;
    PhotoDirectoryPage photoPage;

    @Given("user launches WordPress website")
    public void launchWebsite() {
        driver.get("https://wordpress.org/");
    }

    @Then("verify page title")
    public void verifyTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("WordPress.org"),
                "Page title does not contain expected text");
    }


    @When("user navigates to Get WordPress page")
    public void navigateToGetWordPress() {
        homePage = new HomePage(driver);
        homePage.mouseOver();
    }

    @Then("verify Get WordPress text")
    public void verifyText() {
        downloadPage = new DownloadPage(driver);
        Assert.assertEquals(downloadPage.getPageText(), "Get WordPress");
    }

    @When("user navigates to Photo Directory")
    public void navigateToPhotoDirectory() {
        homePage.photoDirectoryClick();
    }

    @And("user searches photo {string}")
    public void searchPhoto(String photoName) {
        photoPage = new PhotoDirectoryPage(driver);
        photoPage.searchImage(photoName);
    }

    @Then("verify photos are displayed")
    public void verifyPhotos() {
        photoPage.isImageDisplayed();
    }
}
