package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PhotoDirectoryPage {

    WebDriver driver;
    WebDriverWait wait;

    // Photo cards on search result page
    By photos = By.cssSelector("article, figure");

	
	
	By Search=By.xpath("//input[@placeholder='Search photos']");
	By image=By.xpath("//li[contains(@class,'hentry')]");
	
	public PhotoDirectoryPage(WebDriver driver) {
		this.driver=driver;
	}

	
	
	public void searchImage(String s) {
		driver.findElement(Search).sendKeys(s);
		driver.findElement(Search).sendKeys(Keys.ENTER);	
	}
	public void isImageDisplayed() {
		int s=driver.findElements(image).size();
		if(s>0) {
			System.out.println("True");
			}
		else {
			System.out.println("Error");
			}
		}

//    public boolean areImagesDisplayed() {
//
//        List<WebElement> imageList = wait.until(
//                ExpectedConditions.numberOfElementsToBeMoreThan(photos, 0)
//        );
//
//        return imageList.size() > 0;
//    }
}
