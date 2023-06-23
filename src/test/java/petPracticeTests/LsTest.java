package petPracticeTests;

import com.demoqa.LsTestBase;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class LsTest extends LsTestBase {


    @Test
    void successTest() {
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