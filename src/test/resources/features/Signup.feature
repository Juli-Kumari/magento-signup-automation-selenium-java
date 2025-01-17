Feature: Create an Account and Login Tests

  Background:
    Given the user is on the Magento sign-up page

    @CreateNewAccount
  Scenario Outline: User Registration with Valid Details
    When the user enters "<FirstName>" as First Name
    And the user enters "<LastName>" as Last Name
    And the user enters "<Email>" as Email
    And the user enters "<Password>" as Password
    And the user confirms the password with "<ConfirmPassword>"
    And the user submits the form using Create an Account button
    Then the user should see a "<success message>" as success message for registration

    Examples:
      | FirstName | LastName | Email               | Password     | ConfirmPassword | success message|
      | Juli33      | Kumari      | juli323@gmail.com     | Test@1234    | Test@1234       | Thank you for registering with Main Website Store.|

      @RegisterWithInvalidEmail
  Scenario Outline: User Registration with Invalid Email
    When the user enters "<FirstName>" as First Name
    And the user enters "<LastName>" as Last Name
    And the user enters "<Email>" as Email
    And the user enters "<Password>" as Password
    And the user confirms the password with "<ConfirmPassword>"
    And the user submits the form using Create an Account button
    Then the user should see an "<error message>" as error message for invalid email

    Examples:
      | FirstName | LastName | Email       | Password     | ConfirmPassword | error message|
      | Juli      | Kumari      | juli.com    | Test@1234    | Test@1234       |Please enter a valid email address (Ex: johndoe@domain.com).               |

  @RegisterWithInvalidPassword
  Scenario Outline: User Registration with Mismatched Passwords
    When the user enters "<FirstName>" as First Name
    And the user enters "<LastName>" as Last Name
    And the user enters "<Email>" as Email
    And the user enters "<Password>" as Password
    And the user confirms the password with "<ConfirmPassword>"
    And the user submits the form using Create an Account button
    Then the user should see an "<error message>" as error message for mismatched passwords

    Examples:
      | FirstName | LastName | Email               | Password     | ConfirmPassword | error message |
      | Juli      | Kumari      | juli@example.com     | Test@1234    | test@1234       | Please enter the same value again.           |

    @SignInWithValidCredential
  Scenario Outline: User Sign-in with Valid Credentials
    When the user enters "<Email>" as Email in customer login page
    And the user enters "<Password>" as Password in customer login page
    And the user click on Signin Button
    Then the user should successfully navigate to the user dashboard as "<username>"

    Examples:
      | Email               | Password     | username|
      | juli@gmail.com     | Test@1234    |Juli Kumari|

  @SignInWithInValidCredential
  Scenario Outline: User Sign-in with Incorrect Password
    When the user enters "<Email>" as Email in customer login page
    And the user enters "<Password>" as Password in customer login page
    And the user click on Signin Button
    Then the user should see an "<error message>" as error message for incorrect password

    Examples:
      | Email               | Password      | error message|
      | juli@gmail.com     | WrongPassword | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.|

