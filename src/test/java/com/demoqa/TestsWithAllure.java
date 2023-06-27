package com.demoqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestsWithAllure extends TestBase {

private static final String firstName = "Vladimir";
    private static final String eMail = "arsenaljkeeee10@gmail.com";
    private static final String currentAddress = "Georgia, Batumi";
    private static final String permanentAddress = "Earth";

    @Test
    void successTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем страницу TextBox", () -> {open("/text-box");});
        step("Вводим имя", () -> {$("#userName").setValue(firstName);});
        step("Вводим текущий адрес", () -> {$("#currentAddress").setValue(currentAddress);});
        step("Вводим постоянный адрес", () -> {$("#permanentAddress").setValue(permanentAddress);});
        step("Кликаем Подтвердить", () -> {$("#submit").click();});

    }
}
