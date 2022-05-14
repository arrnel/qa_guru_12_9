package com.arrnel.dragAndDrop;

import com.arrnel.allure.Allure;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerokuApp {

    HerokuAppLocators locator = new HerokuAppLocators();
    Allure allure = new Allure();

    public void dragAndDropAToB() {
        step("Поменять местами блок 'A' и блок 'B'", () ->
                locator.columnA().shouldBe(visible).dragAndDropTo(locator.columnB())
        );

    }

    public void dragAndDropBToA() {
        step("Поменять местами блок 'B' и блок 'A'", () ->
                locator.columnB().shouldBe(visible).dragAndDropTo(locator.columnA())
        );
    }

    public void assertBBefore() {
        step("Проверить что блок 'B' первый", () ->
                assertEquals("B", locator.firstColumnText().getText())
        );
    }

    public void assertABefore() {
        step("Проверить что блок 'A' первый", () ->
                assertEquals("A", locator.firstColumnText().getText())
        );
    }

    public void open() {

        step("Перейти на страницу herokuApp", () ->
                Selenide.open("https://the-internet.herokuapp.com/drag_and_drop")
        );

    }

}

