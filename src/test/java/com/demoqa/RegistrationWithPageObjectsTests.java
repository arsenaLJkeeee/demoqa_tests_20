package com.demoqa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase{

SelenideElement firstNameInput = $("#firstName");
    @Test
     void successfulRegistrationTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        firstNameInput.setValue("Vladimir");
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
        // ввод h в поле subject и нажать enter
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test_file.jpg");
        $("#currentAddress").setValue("Georgia, Batumi");
        //выбираем штат
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        //выбираем город
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").pressEnter();
        // Проверка наличия окна с нужными значениями
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vladimir Borchevskiy"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("arsenaljkeeee10@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("5597078392"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("22 June,1992"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test_file.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Georgia, Batumi"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
    }
}