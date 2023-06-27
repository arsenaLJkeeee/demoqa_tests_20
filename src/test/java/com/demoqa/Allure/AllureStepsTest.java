package com.demoqa.Allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.Allure.AllureWebSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class AllureStepsTest {
    private static final String REPOSITORY = "Selenide/";
    private static final String ISSUE = "issue";
    public static final String baseUrl = "https://github.com/";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываю страницу Github", () -> {
            open(baseUrl);
        });

        step("Ищу репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаю по ссылке репозитория" + REPOSITORY, () -> {
            $(byTagAndText("a", REPOSITORY));
        });
        step("Проверяю наличие текста issue", () -> {
            $(withText(ISSUE)).should(exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        AllureWebSteps steps = new AllureWebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryText(REPOSITORY);
        steps.shouldSeeIssue(ISSUE);

    }
}