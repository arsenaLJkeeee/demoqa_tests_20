package com.demoqa.Allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class AllureWebSteps {
    public static final String baseUrl = "https://github.com/";
    @Step("Открываю страницу Github")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Ищу репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликаю по ссылке репозитория {repo}")
    public void clickOnRepositoryText(String repo) {
        $(byTagAndText("a", repo)).click();
    }

    @Step("Проверяю наличие текста issue")
    public void shouldSeeIssue(String issue) {
        $(withText(issue)).should(exist);
    }
}
