package com.arrnel.allure;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

public class Allure {

    public void attachments(String screenshotName, String pageName) {

        io.qameta.allure.Allure.step("Приложения", () -> {

            io.qameta.allure.Allure.getLifecycle().addAttachment(
                    screenshotName,
                    "image/png",
                    "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));

            io.qameta.allure.Allure.getLifecycle().addAttachment(
                    pageName,
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));

        });

    }

    public void attachment(AttachmentType attachmentType, String attachmentTitle) {

        if (attachmentType == AttachmentType.PAGE) {

            io.qameta.allure.Allure.step("Приложение", () ->

                io.qameta.allure.Allure.getLifecycle().addAttachment(
                        attachmentTitle,
                        "text/html",
                        "html",
                        WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8))

            );

        } else if (attachmentType == AttachmentType.SCREENSHOT) {

            io.qameta.allure.Allure.step("Приложение", () ->

                io.qameta.allure.Allure.getLifecycle().addAttachment(
                        attachmentTitle,
                        "image/png",
                        "png",
                        ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES))

            );

        }

    }

}
