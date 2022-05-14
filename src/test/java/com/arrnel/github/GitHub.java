package com.arrnel.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;

public class GitHub {

    GitHubLocators locator = new GitHubLocators();

    public void assertJUnit5ExampleCodeExist() {

        Allure.step("Проверка наличия блока кода для JUnit5", () ->
                locator.junit5ExampleCodeHeader().shouldBe(Condition.visible).scrollIntoView(true)
        );

    }


    public GitHub openPage(String text) {

        Allure.step("Переход на страницу " + text + "", () -> {
            locator.wikiPageFromList(text).shouldBe(Condition.visible).click();
            locator.pageHeader(text).shouldHave(Condition.exactText(text));
        });

        return this;

    }

    public GitHub search(String text) {

        Allure.step("Поиск страницы " + text + "", () -> {
            locator.wikiFilter().shouldBe(Condition.visible).click();
            locator.wikiFilter().sendKeys(text);
            locator.wikiPageFromList(text).shouldBe(Condition.visible);

        });

        return this;

    }


    public GitHub goToWiki() {

        Allure.step("Перейти на вкладку сайта 'Wiki'", () -> {
            locator.wikiTab().shouldBe(Condition.visible).click();
            locator.wikiTab().shouldHave(Condition.cssClass("selected")).click();
        });

        return this;

    }

    public GitHub open() {

        Allure.step("Перейти на страницу проекта selenide в github", () ->
                Selenide.open("https://github.com/selenide/selenide")
        );

        return this;

    }

}
