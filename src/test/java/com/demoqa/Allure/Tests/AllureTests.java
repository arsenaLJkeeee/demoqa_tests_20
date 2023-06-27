package com.demoqa.Allure.Tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AllureTests extends TestBase {
    public static final String
            valueOfSearch = "selenide",
            numberOfIssue = "2355";
    public static SelenideElement
            headerSearch = $(".header-search-input"),
            issuesTab = $("#issues-tab"),
            selenideRepo = $("a[href=\"/selenide/selenide\"]");

    @Test
    void SelenideTest() {
        open(baseUrl);
        headerSearch.shouldBe(visible, Duration.ofSeconds(5000)).click();
        headerSearch.setValue(valueOfSearch).pressEnter();
        selenideRepo.shouldBe(visible, Duration.ofSeconds(5000)).click();
        issuesTab.shouldBe(visible, Duration.ofSeconds(50000)).click();
        $(withText(numberOfIssue)).should(exist);
    }

    @Test
    void stepLambdaTest() {
        step("Открываю страницу", () -> open(baseUrl));
        step("Ищу репозиторий: " + valueOfSearch, () -> {
            headerSearch.click();
            headerSearch.setValue(valueOfSearch).pressEnter();
            selenideRepo.click();
        });
        step("Выбираю Issue", () -> {
            issuesTab.shouldBe(visible, Duration.ofSeconds(50000));
            issuesTab.click();
        });
        step("Проверяю номер Issue: " + numberOfIssue, () -> {
            $(withText(numberOfIssue)).should(exist);
        });
    }

    @Test
    void annotationStepTest() {
        WebSteps webSteps = new WebSteps();
        webSteps
                .openMainPage()
                .searchRepo(valueOfSearch)
                .clickOnTab()
                .checkIssueNumber(numberOfIssue);
    }
}