package petPracticeTests;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.LsTestBase;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LsTest extends LsTestBase {

    @Test
    void redesignCupisWalletClickTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {open(baseUrl);});
        step("Принимаем куки", () -> {$(byText("Принять все")).shouldBe(visible, Duration.ofSeconds(10000)).click();});
        step("Кликаем по кнопке Вход", () -> {$(byText("Вход")).shouldBe(visible, Duration.ofSeconds(10000)).click();});
        step("Вводим номер телефона", () -> {$("#mobilePhone").shouldBe(visible, Duration.ofSeconds(10000)).setValue("1014203177");});
        step("Вводим пароль", () -> {$("#password").shouldBe(visible, Duration.ofSeconds(10000)).setValue("123123eE");});
        step("Кликаем по кнопке Войти", () -> {$(byText("Войти")).shouldBe(visible).click();});
        $(".bottom-menu_eG-q").lastChild().shouldBe(visible, Duration.ofSeconds(10000)).click();
        $(".wallet__buttons-e1c20c").$(byText("Пополнить")).shouldBe(visible, Duration.ofSeconds(10000)).click();
        $(byText("Кошелек ЦУПИС")).shouldBe(visible, Duration.ofSeconds(10000)).click(ClickOptions.usingJavaScript());
    }
}