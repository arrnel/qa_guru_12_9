package com.arrnel.dragAndDrop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HerokuAppLocators {

    public SelenideElement columnA() {
        return $("#column-a").as("Блок 'A'");
    }

    public SelenideElement columnB() {
        return $("#column-b").as("Блок 'B'");
    }

    public SelenideElement firstColumnText() {
        return $("div[id*='column-']:first-child > header").as("Первый блок");
    }

}
