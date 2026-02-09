package scooterpagebject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    //Поле "Имя"
    private final String NAME = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Имя')]";
    //Поле "Фамилия"
    private final String SURNAME = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Фамилия')]";
    //Поле "Адрес: куда привезти заказ"
    private final String ADDRESS = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Адрес')]";
    //Поле "Станция метро
    private final String SUBWAY = "//div[@class='select-search__value']//input[contains(@placeholder, '* Станция метро')]";
    //Поле выбора станции метро
    private final String SUBWAY_CHOISE = "//div[contains(@class, 'select-search')]//div[text()='%s']";
    //Поле "Телефон: на него позвонит курьер
    private final String PHONE = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Телефон')]";
    //Кнопка "Далее"
    private final String NEXT = "//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']";
    //Поле "Когда привезти самокат"
    private final String WHEN = "//div[@class='react-datepicker__input-container']//input[contains(@placeholder, '* Когда привезти')]";
    //Поле "Срок аренды"
    private final String RENT_PERIOD = "//div[@class='Dropdown-control']//div[@class='Dropdown-placeholder']";
    //Выбор срока аренды
    private final String RENT_OPTION = "//div[contains(@class, 'Dropdown-menu')]//div[text()='%s']";
    //Поле "Цвет самоката" - Черный жемчуг
    private final String BLACK_COLOUR = "//input[@id='black']";
    //Поле "Цвет самоката" - серая безысходность
    private final  String GREY_COLOUR = "//input[@id='grey']";
    //Поле "Комментарий для курьера"
    private final String COMMENT = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, 'Комментарий')]";
    //Кнопка "Назад"
    private final String BACK_BUTTON = "//div[@class='Order_Buttons__1xGrp']//button[contains(@class, 'Button_Inverted__3IF-i')]";
    //Кнопка подтверждения заказа
    private final String YES_BUTTON = "//div[@class='Order_Buttons__1xGrp']//button[text()='Да']";
    //Окно подтверждения заказа
    private final String CONFIRM = "//div[contains(text(), 'Заказ оформлен')]";
    //Кнопка "Заказать" верхняя
    private final String UP_ORDER_BUTTON = "//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']";
    //Кнопка "Заказать" нижняя
    private final String DOWN_ORDER_BUTTON = "//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']";

    public WebDriver driver;

    public OrderPage (WebDriver driver){
        this.driver = driver;
    }

    public void fillName(String name) {
        driver.findElement(By.xpath(NAME)).sendKeys(name);
    }

    public void fillSurname(String surname){
        driver.findElement(By.xpath(SURNAME)).sendKeys(surname);
    }

    public void fillAddress(String address){
        driver.findElement(By.xpath(ADDRESS)).sendKeys(address);
    }

    public void fillSubway(String station){
        driver.findElement(By.xpath(SUBWAY)).sendKeys(station);
        By option = By.xpath(String.format(SUBWAY_CHOISE, station));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(option));

        driver.findElement(option).click();
    }

    public void fillPhone(String phone){
        driver.findElement(By.xpath(PHONE)).sendKeys(phone);
    }

    public void clickNext(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEXT)));
        scrollToElement(By.xpath(NEXT));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEXT)));

        WebElement button = driver.findElement(By.xpath(NEXT));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", button);
    }

    public void fillWhen(String date){
        driver.findElement(By.xpath(WHEN)).sendKeys(date);
        driver.findElement(By.xpath(WHEN)).sendKeys(Keys.ENTER);
    }

    public void fillRentPeriod(String period){
        driver.findElement(By.xpath(RENT_PERIOD)).click();
        By options = By.xpath(String.format(RENT_OPTION, period));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(options));

        driver.findElement(options).click();
    }

    public void chooseColour(String colour){
        if (colour.equalsIgnoreCase("black")) {
            driver.findElement(By.xpath(BLACK_COLOUR)).click();
        }
        else {
            driver.findElement(By.xpath(GREY_COLOUR)).click();
        }
    }

    public void fillComment(String  comment){
        scrollToElement(By.xpath(COMMENT));
        driver.findElement(By.xpath(COMMENT)).sendKeys(comment);
    }

    public void submitOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DOWN_ORDER_BUTTON)));
        scrollToElement(By.xpath(DOWN_ORDER_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DOWN_ORDER_BUTTON)));

        WebElement button = driver.findElement(By.xpath(DOWN_ORDER_BUTTON));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", button);
        driver.findElement(By.xpath(YES_BUTTON)).click();
    }

    public boolean isOrderSuccessDisplay(){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM))).isDisplayed();
    }

    private void scrollToElement (By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}
