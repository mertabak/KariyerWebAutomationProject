
Selenium TDD Automation Project

This project is a test automation suite for Kariyer.net, focusing on two main pages: the "Login" and "Forgot Password" pages. 
The Tests are built using Selenium, Java, and the JUnit5 framework, with Maven as the dependency management tool. 
The project follows TDD principles and includes logging and reporting capabilities through Log4j and Allure Reports.


Project Structure

Pages: Contains the Page Object Model (POM) for the pages being tested.
BasePage.java: A base class providing common methods for page interaction such as clickElement, sendKeysElement, waitElement, and generateRandomEmail.
CreateMemberPage.java: Contains methods to interact with the registration page.
ForgotPasswordPage.java: Contains methods to interact with the forgot password page.
Tests: Contains the test classes with the test scenarios.

Tests
CreateMemberTest.java: Includes test cases for various membership creation scenarios.
ForgotPasswordTest.java: Includes test cases for resetting a password via email and phone.

Utils
ConfigReader.java: Handles reading configuration data such as base URL and test data from a data.properties file.

Resources
data.properties: Contains test data such as valid names, phone numbers, and passwords.
log4j2.xml: Configuration for logging using Log4j2.


Tools and Technologies
Selenium WebDriver: For automating browser interactions.
JUnit5: Used for structuring and running the tests.
Maven: Dependency management and build automation tool.
Log4j2: Logging library to provide insights into test execution.
Allure Reports: Integrated for generating detailed test execution reports.

Test Scenarios

CreateMemberTest
Successful Membership Creation Test: Validates that a new user can be successfully registered.
Blank Field Tests: Ensures appropriate errors are shown when required fields like name, email, or phone are left blank.
Password Validation Tests: Tests for password strength, including scenarios for missing numbers, uppercase, or lowercase letters.

ForgotPasswordTest
Send Reset Password Email: Validates that a reset password email can be sent with valid email input.
Send Reset Password Message: Tests password reset via phone, ensuring fields like name and phone number are required.
Invalid Email Formats: Ensures the system doesn't accept incorrect email formats during password reset.

Reporting
Allure Reports is integrated to provide detailed test execution results, including step-by-step details and logs for failed tests.

Notes
The project avoids code repetition through reusable methods in the BasePage class.
Follows best practices such as OOP, proper naming conventions, and clean, extendable class architecture.
The project is ready to be extended with additional test cases and new features if required.

