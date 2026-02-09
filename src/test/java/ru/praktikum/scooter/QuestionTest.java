package ru.praktikum.scooter;

import Utils.Answers;
import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import scooterPageObject.MainPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest extends BaseTest {

    @ParameterizedTest
    @EnumSource(Answers.class)
    void CheckAnswersTextForEachQuestions (Answers answer) {

        MainPage mainpage = new MainPage(driver);
        mainpage.openMainPage();

        mainpage.clickQuestionByText(answer.getQuestionText());

        String actualText = mainpage.getAnswerByQuestionText(answer.getQuestionText(), answer.getAnswerText());

        assertEquals(answer.getAnswerText(), actualText);
    }

}
