package ru.praktikum.scooter;

import Utils.WebDriverFactory;
import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import scooterPageObject.MainPage;
import scooterPageObject.OrderPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest extends BaseTest {

    @Test
    void UpOrderButtonFlow(){

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.clickUpOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillName("Иван");
        objOrderPage.fillSurname("Иванов");
        objOrderPage.fillAddress("Москва, ул. Ленина 12");
        objOrderPage.fillSubway("Кропоткинская");
        objOrderPage.fillPhone("89213423452");
        objOrderPage.clickNext();

        objOrderPage.fillWhen("15.03.2026");
        objOrderPage.fillRentPeriod("четверо суток");
        objOrderPage.chooseColour("black");
        objOrderPage.fillComment("Позвоните за час");
        objOrderPage.submitOrder();
        assertTrue(objOrderPage.isOrderSuccessDisplay(), "Экран подтверждения заказа не появился...");
    }

    @Test
    void downOrderButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.acceptCookiesIfPresent();
        objMainPage.clickDownOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillName("Сергей");
        objOrderPage.fillSurname("Сергеев");
        objOrderPage.fillAddress("Мира 47");
        objOrderPage.fillSubway("Лубянка");
        objOrderPage.fillPhone("89992234345");
        objOrderPage.clickNext();

        objOrderPage.fillWhen("23.05.2026");
        objOrderPage.fillRentPeriod("двое суток");
        objOrderPage.chooseColour("grey");
        objOrderPage.fillComment("Здравствуйте, спасибо, пожалуйста");
        objOrderPage.submitOrder();
        assertTrue(objOrderPage.isOrderSuccessDisplay(), "Экран подтверждения заказа не появился...");
    }

}
