package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateNewCustomerAccountPage {
    WebDriver driver;
    WebDriverWait wait;

    public CreateNewCustomerAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id="lastname")
    WebElement lastName;

    @FindBy(id = "email_address")
    WebElement emailAddress;

    @FindBy(id="password")
    WebElement passwordEle;

    @FindBy(id = "password-confirmation")
    WebElement passwordConfirmation;

    @FindBy(className ="submit")
    WebElement submitButton;

    @FindBy(css = "div[role='alert']")
    WebElement successMessage;

    public void enterFirstName(String fiName){
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fiName);
    }

    public void enterLastName(String laName){
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(laName);

    }
    public void enterEmail(String email){

        wait.until(ExpectedConditions.visibilityOf(emailAddress)).sendKeys(email);

    }
    public void enterPassword(String password){

        wait.until(ExpectedConditions.visibilityOf(passwordEle)).sendKeys(password);

    }
    public void enterConfirmPassword(String confirmPassword){
        wait.until(ExpectedConditions.visibilityOf(passwordConfirmation)).sendKeys(confirmPassword);
    }

    public void clickOnSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String successMessage(){
        String successMsg= wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();

        return successMsg;
    }
}
