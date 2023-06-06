package com.demoqa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase{
   RegistrationPage registrationPage = new RegistrationPage();

    @Test
     void successfulRegistrationTest() {
       registrationPage.openPage()
               .setFirstName("Vladimir")
               .setLastName("Borchevskiy")
               .setUserEmail("arsenaljkeeee10@gmail.com")
               .setGender("Male")
               .setUserNumber("5597078392")
               .setBirthDay("22","June","1992")
               .setSubjects("Computer Science")
               .setHobbie("Sports","Music")
               .uploadPicture("test_file.jpg")
               .setCurrentAddress("Georgia, Batumi")
               .setState("Uttar Pradesh")
               .setCity("Agra")
               .checkStudentName("Vladimir Borchevskiy")
               .checkStudentEmail("arsenaljkeeee10@gmail.com")
               .checkStudentGender("Male")
               .checkStudentMobile("5597078392")
               .checkDateOfBirth("22 June,1992")
               .checkSubjects("Computer Science");

        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test_file.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Georgia, Batumi"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
    }
}