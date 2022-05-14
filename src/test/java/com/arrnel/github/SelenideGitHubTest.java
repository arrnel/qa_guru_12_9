package com.arrnel.github;

import com.arrnel.allure.Allure;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelenideGitHubTest {

    GitHub gitHub = new GitHub();
    Allure allure = new Allure();

    @BeforeEach
    void beforeEach() {
        Configuration.browserSize = "1920x1080";
        gitHub.open();
    }

    @Test
    void junit5ExampleCodeExistInSoftAssertionsPageSelenideGitHubTest() {

        // Data
        String searchingText = "SoftAssertions";

        // Steps
        gitHub.goToWiki()
                .search(searchingText)
                .openPage(searchingText);

        //Assertions
        gitHub.assertJUnit5ExampleCodeExist();

        //Attachments
        allure.attachments("Скриншот страницы SoftAssertion", "Страница SoftAssertion");

    }

    @AfterEach
    void tearDown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
