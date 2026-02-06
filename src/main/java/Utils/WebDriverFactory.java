package Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
                firefoxDriver.manage().window().setSize(new Dimension(1920, 1080));
                return firefoxDriver;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriver chromeDriver = new ChromeDriver(chromeOptions);
                chromeDriver.manage().window().setSize(new Dimension(1920, 1080));
                return chromeDriver;
        }
    }
}
