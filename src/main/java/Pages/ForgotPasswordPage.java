package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(xpath = "//button[@class=\"nav-link parent menu-button btn-menu-desktop-login user\"]")
    public static WebElement loginButton;

    @FindBy(xpath = "//a[@class=\"header-user-items-menu-button empty-button login-button\"]")
    public static WebElement memberLogin;

    @FindBy(xpath = "//span[text()='Telefon']")
    public static WebElement telephone;

    @FindBy(xpath = "//h1[text()='Şifre sıfırlama bağlantısını gönderdik']")
    public static WebElement sentResetPasswordMessage;

    @FindBy(xpath = "//button[@class=\"submit-button\"]")
    public static WebElement submitButton;

    @FindBy(id = "forgottenPassLink")
    public static WebElement forgottenPass;

    @FindBy(id = "name")
    public static WebElement name;

    @FindBy(id = "lastname")
    public static WebElement lastname;

    @FindBy(id = "phone")
    public static WebElement phone;

    @FindBy(xpath = "//button[@class='submit-button' and @disabled='disabled']")
    public static WebElement submitButtonDisabled;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysEmail(String email) {
        sendKeysElement(this.email, email, "Email field");
    }

    public void sendKeysName(String name) {
        sendKeysElement(this.name, name, "Name Field");
    }

    public void sendKeysLastName(String lastname) {
        sendKeysElement(this.lastname, lastname, "Lastname Field");
    }

    public void sendKeysPhone(String phone) {
        sendKeysElement(this.phone, phone, "Phone field");
    }

    public static void completeCommonSteps() {
        assertElementVisible(loginButton, "Login button");
        clickElement(loginButton, "Login button");

        assertElementVisible(memberLogin, "Member Login button");
        clickElement(memberLogin, "Member Login button");

        assertElementVisible(forgottenPass, "Forgotten Pass button");
        clickElementWithJS(driver, forgottenPass, "Forgotten Pass button");
        assertElementVisible(email, "Username or Email field");
    }

    public static void checkNameLastnamePhone() {
        assertElementVisible(name, "Name Field");
        assertElementVisible(lastname, "Surname Field");
        assertElementVisible(phone, "Phone Field");
    }
}