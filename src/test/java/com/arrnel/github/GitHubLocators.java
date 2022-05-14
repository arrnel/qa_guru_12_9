package com.arrnel.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GitHubLocators {

    public SelenideElement junit5ExampleCodeHeader() {
        return $x("//h4[text()='3. Using JUnit5 extend test class:']").as("Блок JUnit5");
    }

    public SelenideElement wikiPageFromList(String text) {
        return $x("//a[text()='" + text + "']").as("Страница " + text + " в списке 'Wiki'");
    }

    public SelenideElement pageHeader(String text) {
        return $x("//h1[text()='" + text + "']").as("Заголовок страницы '" + text + "'");
    }

    public SelenideElement wikiFilter() {
        return $("#wiki-pages-filter").as("Поиск в Wiki");
    }

    public SelenideElement wikiTab() {
        return $("a[href*='wiki']").as("Вкладка контекстного меню 'Wiki'");
    }


}
