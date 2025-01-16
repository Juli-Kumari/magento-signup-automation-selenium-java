package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    WebDriverWait wait;
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='page-header']//a[contains(text(), 'Create an Account')]")
    WebElement createAnAccountBtn;

    public void clickCreateAnAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(createAnAccountBtn)).click();
    }
}