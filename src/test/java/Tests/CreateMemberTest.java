package Tests;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import Pages.CreateMemberPage;
import Utils.ConfigReader;

class CreateMemberTest extends DriverManager {

    private static final Logger logger = LogManager.getLogger(CreateMemberTest.class);
    private CreateMemberPage createMemberPage;
    private ConfigReader configReader;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private String randomEmail;
    private String passwordLessEight;
    private String passwordNoNumber;
    private String passwordNoUpperCase;
    private String passwordNoLowerCase;

    @BeforeEach
    public void setUp() {
        super.setUp();
        logger.info("Test started.");
        createMemberPage = PageFactory.initElements(driver, CreateMemberPage.class);
        createMemberPage = new CreateMemberPage(driver);
        configReader = new ConfigReader();
        name = configReader.getProperty("valid.name");
        surname = configReader.getProperty("valid.surname");
        phone = configReader.getProperty("valid.phone");
        password = configReader.getProperty("valid.password");
        passwordLessEight = configReader.getProperty("valid.passwordLessEight");
        passwordNoNumber = configReader.getProperty("valid.passwordNoNumber");
        passwordNoUpperCase = configReader.getProperty("valid.passwordNoUpperCase");
        passwordNoLowerCase = configReader.getProperty("valid.passwordNoLowerCase");
        randomEmail = createMemberPage.generateRandomEmail();
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
        logger.info("Test finished.");
    }

    @Test
    @Description("Valid membership creation scenario")
    @DisplayName("Successful Membership Creation Test")
    public void CreateMemberSuccess() {
        createMemberPage.completeCommonSteps();


        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPassword(password);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.clickRegisterButton();

        createMemberPage.assertElementVisible(createMemberPage.enterVerificationCode, "Enter Verification Code field");
    }

    @Test
    @Description("Scenario for membership creation with a blank name")
    @DisplayName("Blank Name Membership Creation Test")
    public void BlankName() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPhone(phone);
        createMemberPage.sendKeysPassword(password);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a blank last name")
    @DisplayName("Blank Last Name Membership Creation Test")
    public void BlankLastName() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPhone(phone);
        createMemberPage.sendKeysPassword(password);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a blank phone")
    @DisplayName("Blank Phone Membership Creation Test")
    public void BlankPhone() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPassword(password);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a blank password")
    @DisplayName("Blank Password Membership Creation Test")
    public void BlankPassword() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPhone(phone);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a blank email")
    @DisplayName("Blank Email Membership Creation Test")
    public void BlankEMail() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysPhone(phone);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a password less than eight characters")
    @DisplayName("Password Less Than Eight Characters Test")
    public void PasswordLessEightCharacters() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPhone(phone);
        createMemberPage.sendKeysPassword(passwordLessEight);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a password containing no number")
    @DisplayName("Password Without Number Test")
    public void PasswordWithoutNumber() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPassword(passwordNoNumber);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a password containing no uppercase letter")
    @DisplayName("Password Without Uppercase Letter Test")
    public void passwordWithoutUpperLetterCase() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPhone(phone);
        createMemberPage.sendKeysPassword(passwordNoUpperCase);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

    @Test
    @Description("Scenario for membership creation with a password containing no lowercase letter")
    @DisplayName("Password Without Lowercase Letter Test")
    public void passwordWithoutLowerLetterCase() {
        createMemberPage.completeCommonSteps();

        createMemberPage.sendKeysName(name);
        createMemberPage.sendKeysLastName(surname);
        createMemberPage.sendKeysEmail(randomEmail);
        createMemberPage.sendKeysPhone(phone);
        createMemberPage.sendKeysPassword(passwordNoLowerCase);

        createMemberPage.completeOtherCommonSteps();

        createMemberPage.assertElementVisible(createMemberPage.registerButtonDisabled, "Register button disabled");
    }

}
