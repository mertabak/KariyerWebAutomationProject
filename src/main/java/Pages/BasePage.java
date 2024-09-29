package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    // Constructor to initialize WebDriver and WebDriverWait for page classes
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click an element and log the action
    public static void clickElement(WebElement element, String elementName) {
        try {
            element.click();
            logger.info("Clicked successfully on " + elementName);
        } catch (Exception e) {
            logger.error("Failed to click " + elementName + ": " + e.getMessage(), e);
            throw new RuntimeException("Failed to click element: " + e.getMessage(), e);
        }
    }

    // Method to send text to an element and log the action
    public void sendKeysElement(WebElement element, String text, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            logger.info("Text entered into element: {} = '{}'", elementName, text);
        } catch (Exception e) {
            logger.error("Failed to enter text into element: {}", elementName, e);
            throw new RuntimeException("Failed to enter text into element: " + e.getMessage(), e);
        }
    }

    // Method to generate a random email address
    public static String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString();
        String email = "testuser_" + uuid + "@example.com";
        logger.info("Generated random email: {}", email);
        return email;
    }

    // Method to wait for a given duration and log the action
    public void staticWait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
            logger.info("Waited for {} milliseconds.", milliseconds);
        } catch (InterruptedException e) {
            logger.error("Error occurred during wait.", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error occurred during wait: " + e.getMessage(), e);
        }
    }

    // Method to check if an element is visible and log the result
    public static void assertElementVisible(WebElement element, String elementName) {
        try {
            if (element.isDisplayed()) {
                logger.info(elementName + " is visible.");
            } else {
                logger.warn(elementName + " is not visible.");
            }
        } catch (Exception e) {
            logger.error("Error while checking visibility for " + elementName + ": " + e.getMessage(), e);
            throw new RuntimeException("Failed to visibility element: " + e.getMessage(), e);
        }
    }

    // Method to click an element using JavaScript and log the action
    public static void clickElementWithJS(WebDriver driver, WebElement element, String elementName) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", element);
            logger.info("Clicked successfully on " + elementName + " using JavaScript.");
        } catch (Exception e) {
            logger.error("Failed to click " + elementName + " using JavaScript: " + e.getMessage(), e);
            throw new RuntimeException("Failed to click element with JavaScript: " + e.getMessage(), e);
        }
    }
}
