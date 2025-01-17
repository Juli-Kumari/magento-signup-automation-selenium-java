package pages;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public CustomerLoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement enterEmail;

    @FindBy(css = "input[name='login[password]']")
    WebElement enterPassword;

    @FindBy(css = ".primary#send2")
    WebElement signInButton;

    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(enterEmail)).sendKeys(email);
    }

    public void enterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOf(enterPassword)).sendKeys(pass);
    }

    public void clickOnSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }


}
