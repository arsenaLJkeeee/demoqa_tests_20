package com.demoqa.Allure.Tests;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.Allure.Tests.AllureTests.*;


public class WebSteps {
    @Step("Открываю страницу")
    public WebSteps openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Ищу репозиторий: {repo}")
    public WebSteps searchRepo(String repo) {
        headerSearch.shouldBe(visible, Duration.ofSeconds(5000)).click();
        headerSearch.setValue(repo).pressEnter();
        selenideRepo.shouldBe(visible, Duration.ofSeconds(5000)).click();
        return this;
    }

    @Step("Кликаю на Issue")
    public WebSteps clickOnTab() {
        issuesTab.shouldBe(visible, Duration.ofSeconds(5000));
        issuesTab.click();
        return this;
    }

    @Step("Проверяю номер Issue: {issueNumber}")
    public WebSteps checkIssueNumber(String issueNumber) {
        $(withText(issueNumber)).should(exist);
        return this;
    }
}