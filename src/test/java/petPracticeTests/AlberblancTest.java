package petPracticeTests;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.LsTestBase;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AlberblancTest extends AlberBlancTestBase {
    @Tag("remote")
    @Test
    void rightBurgerShouldHaveMenu() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> open(baseUrl));
        step("Click on Careers", () -> {
            $(byText("Careers"))
                    .shouldBe(Condition.visible)
                    .click();
        });
        step("Check if CareerS text is present", () -> {
            $(byCssSelector(".font-title.text-header-2.text-headlines.uppercase.mb-4.sm_text-header-1-sm"))
                    .shouldHave(Condition.text("CareerS"));
        });

        step("Click on Team", () -> {
            $(byText("Team"))
                    .shouldBe(Condition.visible)
                    .click();
        });

        step("Check if 'THE TEAM' text is present", () -> {
            $(byCssSelector(".font-title.text-headlines.text-header-2.sm_text-header-1-sm.mb-10"))
                    .shouldHave(Condition.text("THE TEAM"));
        });


        step("Click on Events", () -> {
            $(byText("Events"))
                    .shouldBe(Condition.visible)
                    .click();
        });

        step("Check if 'Events' text is present", () -> {
            $(byCssSelector(".font-title.text-headlines.text-header-2.sm_text-header-1-sm.uppercase.mb-8"))
                    .shouldHave(Condition.text("Events"));
        });

        step("Click on Office", () -> {
            $(byText("Office"))
                    .shouldBe(Condition.visible)
                    .click();
        });

        step("Check if 'Offices' text is present", () -> {
            $(byCssSelector(".font-title.text-headlines.text-header-2.uppercase.mr-20.sm_text-header-1-sm.sm_mb-4.sm_mr-0"))
                    .shouldHave(Condition.text("Offices"));
        });
        sleep(5000);
    }
}
