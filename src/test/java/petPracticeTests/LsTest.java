package petPracticeTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.LsTestBase;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class LsTest extends LsTestBase {


    @Test
    void redesignCupisWalletClickTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(baseUrl);
        $(byText("Вход")).click();
        $("#mobilePhone").shouldBe(visible).setValue("1014203177");
        $("#password").setValue("123123eE");
        $(byText("Войти")).click();
        $(".bottom-menu_eG-q").lastChild().click();
        $(".wallet__buttons-e1c20c").$(byText("Пополнить")).shouldBe(visible).click();
        $(".slider__inner_8tZn").$(byText("Кошелек ЦУПИС")).shouldBe(visible).click();
    }
}