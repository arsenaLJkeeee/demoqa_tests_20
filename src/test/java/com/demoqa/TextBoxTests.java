package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;


public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browser = FIREFOX;
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vladimir");
        $("#lastName").setValue("Borchevskiy");
        $("#userEmail").setValue("arsenaljkeeee10@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
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
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("C://test_file.jpg"));
        $("#currentAddress").setValue("Georgia, Batumi");
        //выбираем штат
        $("#state").click();
        $(".css-26l3qy-menu div").findAll("div").filterBy(text("Uttar Pradesh")).first().click();
        // Выбор города
        $("#city").click();
        $(".css-26l3qy-menu div").findAll("div").filterBy(text("Agra")).first().click();
        $(byText("Submit")).pressEnter();
        // Проверка наличия окна с нужными значениями
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vladimir Borchevskiy"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("arsenaljkeeee10@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("5597078392"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("22 June,1992"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("History"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test_file.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Georgia, Batumi"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
}
}