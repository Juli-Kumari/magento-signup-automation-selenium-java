package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserDashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".base")
    WebElement homePageText;

    @FindBy(css = ".logged-in")
    WebElement userName;

    public String getUserName(){
        String name = wait.until(ExpectedConditions.visibilityOf(userName)).getText();
        return name;
    }

    public String displayedHomePage(){
        String text = wait.until(ExpectedConditions.visibilityOf(homePageText)).getText();
        return text;
    }



}
