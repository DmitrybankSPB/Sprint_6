package ru.praktikum.scooter;

import Utils.Answers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import scooterPageObject.MainPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

    private WebDriver driver;

    @ParameterizedTest
    @EnumSource(Answers.class)
    void CheckAnswersTextForEachQuestions (Answers answer) {
        driver = new ChromeDriver();

        MainPage mainpage = new MainPage(driver);
        mainpage.openMainPage();

        mainpage.clickQuestionByIndex(answer.getIndex());

        String actualText = mainpage.getAnswerByIndex(answer.getIndex(), answer.getAnswerText());

        assertEquals(answer.getAnswerText(), actualText);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
