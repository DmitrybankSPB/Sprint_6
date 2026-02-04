package scooterPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {
    //URL страницы
    private final String MAIN_URL = "https://qa-scooter.praktikum-services.ru/";
    //Общая часть xpath для вопросов
    private final String QUEST = "//div[@id='accordion__heading-";
    //Общая часть xpath для ответов
    private final String ANSWERS = "//div[@id='accordion__panel-";
    //Кнопка "Заказать" вверху страницы
    private final String UP_ORDER_BUTTON = "//button[@class='Button_Button__ra12g']";
    //Кнопка "Заказать" в середине страницы
    private final String DOWN_ORDER_BUTTON = "//div[@class='Home_FinishButton__1_cWm']//button[contains(@class, 'Button_Middle__1CSJM')]";

    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_URL);
    }

    //Вопрос по индексу
    private By questionByIndex(int index) {
        return By.xpath(QUEST+index+"']");
    }

    //Ответ по индексу
    private By answerByIndex(int index) {
        return By.xpath(ANSWERS+index+"']");
    }

    private void waitForElement (By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void scrollToElement (By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestionByIndex(int index) {
        By question = questionByIndex(index);

        waitForElement(question);
        scrollToElement(question);
        driver.findElement(question).click();
    }

    public String getAnswerByIndex(int index, String expectedText) {
        By answer = answerByIndex(index);

        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(answer, expectedText));
        return driver.findElement(answer).getText();
    }

}
