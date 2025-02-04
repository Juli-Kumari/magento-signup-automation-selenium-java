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

    @FindBy(xpath = "//*[@class='page-header']//a[contains(text(), 'Sign In')]")
    WebElement signInBtn;

    public void clickButton(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public void clickCreateAnAccountButton() {
        clickButton(createAnAccountBtn);
    }

    public void clickOnSignInButton() {
        clickButton(signInBtn);
    }
}