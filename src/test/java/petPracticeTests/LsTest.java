package petPracticeTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.LsTestBase;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class LsTest extends LsTestBase {


    @Test
    void redesignCupisWalletClickTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {open(baseUrl);});
        sleep(11000);
        step("Принимаем куки", () -> {$(byText("Принять все")).shouldBe(visible).click();});
        sleep(5000);
        step("Кликаем по кнопке Вход", () -> {$(byText("Вход")).shouldBe(visible).click();});
        sleep(10000);
        step("Вводим номер телефона", () -> {$("#mobilePhone").shouldBe(visible).setValue("1014203177");});
        sleep(10000);
        step("Вводим пароль", () -> {$("#password").setValue("123123eE");});
        sleep(10000);
        step("Кликаем по кнопке Войти", () -> {$(byText("Войти")).click();});
        sleep(10000);
        $(".bottom-menu_eG-q").lastChild().click();
        $(".wallet__buttons-e1c20c").$(byText("Пополнить")).shouldBe(visible).click();
        $(".payment-system-1db189").$(withText("Кошелек ЦУПИС")).click();
    }
}