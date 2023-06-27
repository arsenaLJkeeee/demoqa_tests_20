package com.demoqa.Allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AllureTest {
    public static final String baseUrl = "https://github.com/";
    @Test
    public void SelenideTestIssueCheck() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(baseUrl);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Selenide/");
        $(".header-search-input").submit();
        $(byTagAndText("a","selenide/"));
        $(withText("issue")).should(exist);
    }
}