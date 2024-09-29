package Tests;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import Pages.ForgotPasswordPage;
import Utils.ConfigReader;

class ForgotPasswordTest extends DriverManager {

    private static final Logger logger = LogManager.getLogger(CreateMemberTest.class);
    private ForgotPasswordPage forgotPasswordPage;
    private ConfigReader configReader;
    private String name;
    private String surname;
    private String phone;
    private String randomEmail;
    private String wrongUsername;

    @BeforeEach
    public void setUp() {
        super.setUp();
        logger.info("Test started.");
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        configReader = new ConfigReader();
        name = configReader.getProperty("valid.name");
        surname = configReader.getProperty("valid.surname");
        phone = configReader.getProperty("valid.phone");
        wrongUsername = configReader.getProperty("valid.wrongUsername");
        randomEmail = ForgotPasswordPage.generateRandomEmail();
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
        logger.info("Test finished.");
    }

    @Test
    @Description("Scenario for sending a reset password mail")
    @DisplayName("Send Reset Password Mail Test")
    public void SendResetPasswordMail() {
        forgotPasswordPage.completeCommonSteps();

        forgotPasswordPage.sendKeysEmail(randomEmail);
        forgotPasswordPage.clickElement(forgotPasswordPage.submitButton, "Submit Button");

        forgotPasswordPage.assertElementVisible(forgotPasswordPage.sentResetPasswordMessage, "Text of Sent Reset Password Message");
    }

    @Test
    @Description("Scenario for sending a reset password message")
    @DisplayName("Send Reset Password Message Test")
    public void SendResetPasswordMessage() {
        forgotPasswordPage.completeCommonSteps();

        forgotPasswordPage.clickElement(forgotPasswordPage.telephone, "Telephone Button");
        forgotPasswordPage.checkNameLastnamePhone();
        forgotPasswordPage.sendKeysName(name);
        forgotPasswordPage.sendKeysLastName(surname);
        forgotPasswordPage.sendKeysPhone(phone);
        forgotPasswordPage.clickElement(forgotPasswordPage.submitButton, "Submit Button");

        forgotPasswordPage.assertElementVisible(forgotPasswordPage.sentResetPasswordMessage, "Text of Sent Reset Password Message");
    }

    @Test
    @Description("Scenario for reset password with wrong email and username format")
    @DisplayName("Wrong Email and Username Format Test")
    public void WrongEMailorUsernameFormat() {
        forgotPasswordPage.completeCommonSteps();

        forgotPasswordPage.sendKeysEmail(wrongUsername);

        forgotPasswordPage.assertElementVisible(forgotPasswordPage.submitButtonDisabled, "Disabled Submit Button");
    }

    @Test
    @Description("Scenario for forgot password with a blank email")
    @DisplayName("Blank Email Test")
    public void BlankEMail() {
        forgotPasswordPage.completeCommonSteps();
        forgotPasswordPage.assertElementVisible(forgotPasswordPage.submitButtonDisabled, "Disabled Submit Button");
    }

    @Test
    @Description("Scenario for forgot password with a blank name")
    @DisplayName("Blank Name Test")
    public void BlankName() {
        forgotPasswordPage.completeCommonSteps();

        forgotPasswordPage.clickElement(forgotPasswordPage.telephone, "Telephone Button");
        forgotPasswordPage.checkNameLastnamePhone();
        forgotPasswordPage.sendKeysLastName(surname);
        forgotPasswordPage.sendKeysPhone(phone);

        forgotPasswordPage.assertElementVisible(forgotPasswordPage.submitButtonDisabled, "Disabled Submit Button");

    }

    @Test
    @Description("Scenario for forgot password with a blank surname")
    @DisplayName("Blank Surname Test")
    public void BlankSurname() {
        forgotPasswordPage.completeCommonSteps();

        forgotPasswordPage.clickElement(forgotPasswordPage.telephone, "Telephone Button");
        forgotPasswordPage.checkNameLastnamePhone();
        forgotPasswordPage.sendKeysName(name);
        forgotPasswordPage.sendKeysPhone(phone);

        forgotPasswordPage.assertElementVisible(forgotPasswordPage.submitButtonDisabled, "Disabled Submit Button");
    }

    @Test
    @Description("Scenario for forgot password with a blank phone")
    @DisplayName("Blank Phone Test")
    public void BlankPhone() {
        forgotPasswordPage.completeCommonSteps();

        forgotPasswordPage.clickElement(forgotPasswordPage.telephone, "Telephone Button");
        forgotPasswordPage.checkNameLastnamePhone();
        forgotPasswordPage.sendKeysName(name);
        forgotPasswordPage.sendKeysPhone(surname);

        forgotPasswordPage.assertElementVisible(forgotPasswordPage.submitButtonDisabled, "Disabled Submit Button");
    }

}
