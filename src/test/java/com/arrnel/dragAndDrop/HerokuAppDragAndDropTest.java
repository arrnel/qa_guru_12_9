package com.arrnel.dragAndDrop;

import com.arrnel.allure.Allure;
import com.arrnel.allure.AttachmentType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class HerokuAppDragAndDropTest {

    HerokuApp heroku = new HerokuApp();
    Allure allure = new Allure();

    @BeforeEach
    void beforeEach() {
        Configuration.browserSize = "1920x1080";
        heroku.open();
    }

    @Test
    void changePlacesTest() {

        step("Первая перестановка A с B", () -> {
            heroku.dragAndDropAToB();
            heroku.assertBBefore();
            allure.attachment(AttachmentType.SCREENSHOT, "Скриншот B перед A");
        });


        step("Вторая перестановка B с A", () -> {
            heroku.dragAndDropBToA();
            heroku.assertABefore();
            allure.attachment(AttachmentType.SCREENSHOT, "Скриншот A перед B");
        });


        step("Третья перестановка B с A", () -> {
            heroku.dragAndDropBToA();
            heroku.assertBBefore();
            allure.attachments("Скриншот B перед A", "Страница");
        });


    }


    @AfterEach
    void tearDown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
