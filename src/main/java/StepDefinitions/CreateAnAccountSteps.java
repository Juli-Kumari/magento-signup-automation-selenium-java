package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CreateNewCustomerAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.UserDashboardPage;


import java.io.IOException;

public class CreateAnAccountSteps {

    WebDriver driver;
    HomePage homePage;
    CreateNewCustomerAccountPage customerAccountPage;
    CustomerLoginPage loginPage;
    UserDashboardPage dashboardPage;

    @Before
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        customerAccountPage = new CreateNewCustomerAccountPage(driver);
        loginPage = new CustomerLoginPage(driver);
        dashboardPage = new UserDashboardPage(driver);

        driver.manage().window().maximize();

    }

    @Given("the user is on the Magento sign-up page")
    public void the_user_is_on_the_magento_sign_up_page() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user enters {string} as First Name")
    public void the_user_enters_as_first_name(String firstName) {
        homePage.clickCreateAnAccountButton();
        customerAccountPage.enterFirstName(firstName);
    }
    @When("the user enters {string} as Last Name")
    public void the_user_enters_as_last_name(String lastName) {
        customerAccountPage.enterLastName(lastName);
    }
    @When("the user enters {string} as Email")
    public void the_user_enters_as_email(String email) {
      customerAccountPage.enterEmail(email);
    }
    @When("the user enters {string} as Password")
    public void the_user_enters_as_password(String password) {
        customerAccountPage.enterPassword(password);
    }
    @When("the user confirms the password with {string}")
    public void the_user_confirms_the_password_with(String confirmPassword) {
        customerAccountPage.enterConfirmPassword(confirmPassword);
    }
    @When("the user submits the form using Create an Account button")
    public void the_user_submits_the_form_using_create_an_account_button() {
        customerAccountPage.clickOnSubmitButton();
    }
    @Then("the user should see a {string} as success message for registration")
    public void the_user_should_see_a_as_success_message_for_registration(String expectedMessage) {
      String actualMessage = customerAccountPage.successMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("the user should see an {string} as error message for invalid email")
    public void the_user_should_see_an_as_error_message_for_invalid_email(String expectedErrorMessage) {
        String actualErrorMessage = customerAccountPage.emailErrorMessaage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("the user should see an {string} as error message for mismatched passwords")
    public void the_user_should_see_an_please_enter_the_same_value_again_as_error_message_for_mismatched_passwords(String mismatchedPasswordMsg) {
        String actualErrorMessage = customerAccountPage.passwordConfirmationErrorMessaage();
        Assert.assertEquals(mismatchedPasswordMsg, actualErrorMessage);
    }

    @When("the user enters {string} as Email in customer login page")
    public void the_user_enters_as_email_in_customer_login_page(String email) {
        homePage.clickOnSignInButton();
        loginPage.enterEmail(email);

    }
    @When("the user enters {string} as Password in customer login page")
    public void the_user_enters_as_password_in_customer_login_page(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user click on Signin Button")
    public void the_user_click_on_signin_button() {
        loginPage.clickOnSignInButton();
    }

    @Then("the user should successfully navigate to the user dashboard as {string}")
    public void the_user_should_successfully_navigate_to_the_user_dashboard(String expectedUserName) {
        dashboardPage.displayedHomePage();
        String actualName = dashboardPage.getUserName();
        Assert.assertTrue(actualName.contains(expectedUserName));
    }

    @Then("the user should see an {string} as error message for incorrect password")
    public void the_user_should_see_an_as_error_message_for_incorrect_password(String errorMessage) {
       String actualMsg = loginPage.getErrorMessage();
       Assert.assertEquals(actualMsg, errorMessage);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}