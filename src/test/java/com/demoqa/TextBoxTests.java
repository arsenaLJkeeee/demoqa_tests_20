package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = FIREFOX;
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vladimir");
        $("#lastName").setValue("Borchevskiy");
        $("#userEmail").setValue("arsenaljkeeee10@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("5597078392");

        // Клик для открытия датапикера
        $("#dateOfBirthInput").click();
        // Клик для выбора месяца (например, июнь)
        $(".react-datepicker__month-select").selectOption("June");
        // Клик для выбора года (например, 1992)
        $(".react-datepicker__year-select").selectOption("1992");
        // Клик для выбора даты (например, 22)
        $(".react-datepicker__day--022").click();
        // ввод текста в поле subject
        $(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3 input").setValue("some subjects");
       sleep(15000);

    }
}
