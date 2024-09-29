package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMemberPage extends BasePage {

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(xpath = "//button[@class=\"nav-link parent menu-button btn-menu-desktop-login user\"]")
    public static WebElement loginButton;

    @FindBy(id = "surname")
    public static WebElement surname;

    @FindBy(id = "acikRiza")
    public static WebElement explicitConsentCheckbox;

    @FindBy(id = "eIleti")
    public static WebElement electronicMessageCheckbox;

    @FindBy(xpath = "//a[@class=\"header-user-items-menu-button register-button\"]")
    public static WebElement createMember;

    @FindBy(xpath = "//button[@data-test='register-button' and @disabled='disabled']")
    public static WebElement registerButtonDisabled;

    @FindBy(xpath = "//span[@data-test='validation-title' and contains(@class, 'validation-title')]")
    public static WebElement enterVerificationCode;

    @FindBy(id = "name")
    public static WebElement name;

    @FindBy(xpath = "//button[@data-test=\"register-button\"]")
    public static WebElement registerButton;

    @FindBy(id = "phone")
    public static WebElement phone;

    public CreateMemberPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysEmail(String email) {
        sendKeysElement(this.email, email, "Email Field");
    }

    public void sendKeysName(String name) {
        sendKeysElement(this.name, name, "Name Field");
    }

    public void sendKeysLastName(String lastname) {
        sendKeysElement(this.surname, lastname, "Surname Field");
    }

    public void sendKeysPhone(String phone) {
        sendKeysElement(this.phone, phone, "Phone Field");
    }

    public void sendKeysPassword(String password) {
        sendKeysElement(this.password, password, "Password Field");
    }

    public void clickRegisterButton() {
        clickElement(registerButton, "Register Button");
    }

    public void completeCommonSteps() {
        assertElementVisible(loginButton, "Login button");
        clickElement(loginButton, "Login button");

        assertElementVisible(createMember, "Create Member button");
        clickElement(createMember, "Create Member button");

        assertElementVisible(name, "Name field");
        assertElementVisible(surname, "Surname field");
        assertElementVisible(email, "Email field");
        assertElementVisible(password, "Password field");
    }

    public void completeOtherCommonSteps() {
        clickElementWithJS(driver, explicitConsentCheckbox, "Text of Explicit Consent");
        clickElementWithJS(driver, electronicMessageCheckbox, "Text of Electronic Message");
    }
}