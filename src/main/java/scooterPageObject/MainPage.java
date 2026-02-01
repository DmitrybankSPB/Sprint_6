package scooterPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    //URL страницы
    private final String MAIN_URL = "https://qa-scooter.praktikum-services.ru/";
    //Кнопка с вопросом "Сколько это стоит? И как оплатить?"
    private final String COST_QUEST = "//div[@id='accordion__heading-0']";
    //Кнопка с вопросом "Хочу сразу несколько самокатов! Так можно?"
    private final String SOME_SCOOTERS_QUEST = "//div[@id='accordion__heading-1']";
    //Кнопка с вопросом "Как рассчитывается время аренды?"
    private final String TIME_QUEST = "//div[@id='accordion__heading-2']";
    //Кнопка с вопросом "Можно ли заказать самокат прямо на сегодня?"
    private final String TODAY_QUEST = "//div[@id='accordion__heading-3']";
    //Кнопка с вопросом "Можно ли продлить заказ или вернуть самокат раньше?"
    private final String CHANGE_TIME_QUEST = "//div[@id='accordion__heading-4']";
    //Кнопка с вопросом "Вы привозите зарядку вместе с самокатом?"
    private final String CHARGER_QUEST = "//div[@id='accordion__heading-5']";
    //Кнопка с вопросом "Можно ли отменить заказ?"
    private final String CANCEL_QUEST = "//div[@id='accordion__heading-6']";
    //Кнопка с вопросом "Я жизу за МКАДом, привезёте?"
    private final String MKAD_QUEST = "//div[@id='accordion__heading-7']";
    //Кнопка "Заказать" вверху страницы
    private final String UP_ORDER_BUTTON = "//button[@class='Button_Button__ra12g']";
    //Кнопка "Заказать" в середине страницы
    private final String DOWN_ORDER_BUTTON = "//button[contains(@class, 'Button_Middle__1CSJM')]";

    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_URL);
    }

    public void clickCostQuest() {
        driver.findElement(By.xpath(COST_QUEST)).click();
    }

    public void clickSomeScootersQuest() {
        driver.findElement(By.xpath(SOME_SCOOTERS_QUEST)).click();
    }

    public void clickTimeQuest() {
        driver.findElement(By.xpath(TIME_QUEST)).click();
    }

    public void clickTodayQuest() {
        driver.findElement(By.xpath(TODAY_QUEST)).click();
    }

    public void clickChangeTimeQuest() {
        driver.findElement(By.xpath(CHANGE_TIME_QUEST)).click();
    }

    public void clickChargerQuest() {
        driver.findElement(By.xpath(CHARGER_QUEST)).click();
    }

    public void clickCancelQuest() {
        driver.findElement(By.xpath(CANCEL_QUEST)).click();
    }

    public void MkadQuest() {
        driver.findElement(By.xpath(MKAD_QUEST)).click();
    }

}
