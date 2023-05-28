package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Condition.text;

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
        // ввод текста в поле subject и нажать enter
        SelenideElement history = $(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3 input").setValue("History").pressEnter();
        sleep(1000);
        $("label[for='hobbies-checkbox-3']").click();
        sleep(1000);
        $("#uploadPicture").uploadFile(new File("C://test_file.jpg"));
        sleep(1000);
        $("#currentAddress").setValue("Georgia, Batumi");
        //выбираем штат
        $("#state").click();
        $(".css-26l3qy-menu div").findAll("div").filterBy(text("Uttar Pradesh")).first().click();
        sleep(3000);
        // Выбор города
        $("#city").click();
        $(".css-26l3qy-menu div").findAll("div").filterBy(text("Agra")).first().click();
        sleep(3000);

    }
}
