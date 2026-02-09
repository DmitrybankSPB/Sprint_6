package scooterPageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {
    //URL страницы
    private final String MAIN_URL = "https://qa-scooter.praktikum-services.ru/";
    //Общая часть xpath для вопросов
    private final String QUEST = "//div[contains(@class,'accordion__button') and text() = '%s']";
    //Общая часть xpath для ответов
    private final String ANSWERS = "//div[contains(@class, 'accordion__button') and text() = '%s']/ancestor::div[@data-accordion-component='AccordionItem']//div[@data-accordion-component='AccordionItemPanel']";
    //Кнопка "Заказать" вверху страницы
    private final String UP_ORDER_BUTTON = "//button[@class='Button_Button__ra12g']";
    //Кнопка "Заказать" в середине страницы
    private final String DOWN_ORDER_BUTTON = "//div[@class='Home_FinishButton__1_cWm']//button[contains(text(), 'Заказать')]";
    //Кнопка принятия cookies
    private final String COOKIE_BUTTON = "//button[@id='rcc-confirm-button']";

    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_URL);
    }

    //Вопрос по индексу
   /* private By questionByIndex(int index) {
        return By.xpath(QUEST+index+"']");
    }

    //Ответ по индексу
    private By answerByIndex(int index) {
        return By.xpath(ANSWERS+index+"']");
    }

    private void waitForElement (By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void scrollToElement (By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestionByIndex(int index) {
        By question = questionByIndex(index);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(question));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    public String getAnswerByIndex(int index, String expectedText) {
        By answer = answerByIndex(index);

        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(answer, expectedText));
        return driver.findElement(answer).getText();
    }*/

    public void clickQuestionByText (String questionText) {
        By locator = By.xpath(String.format(QUEST, questionText));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", question);

        try {
            question.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", question);
        }
    }

    public String getAnswerByQuestionText(String questionText, String expectedText){
        By locator = By.xpath(String.format(ANSWERS, questionText));

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));

        return driver.findElement(locator).getText();
    }

    public void clickUpOrderButton(){
        driver.findElement(By.xpath(UP_ORDER_BUTTON)).click();
    }

    public void clickDownOrderButton(){
        WebElement downOrderButton = driver.findElement(By.xpath(DOWN_ORDER_BUTTON));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", downOrderButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DOWN_ORDER_BUTTON)));

        try{
            element.click();
        } catch (ElementClickInterceptedException e){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        }
    }

    public void acceptCookiesIfPresent(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COOKIE_BUTTON)));
            cookie.click();
        }
        catch (TimeoutException ignored){
        }
    }
}
