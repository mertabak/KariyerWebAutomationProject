package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Utils.ConfigReader;

public class DriverManager {
    protected static WebDriver driver;
    protected ConfigReader configReader;
    protected ChromeOptions options;

    @BeforeEach
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        configReader = new ConfigReader();
        driver.get(configReader.getBaseUrl());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
