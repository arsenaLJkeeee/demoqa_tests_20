package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.text;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            bithdayInput = $("#dateOfBirthInput"),
            subjectsInput = $ ("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            setPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            statecityInput = $("#stateCity-wrapper");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDay(String day, String month, String year) {
        bithdayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbie(String value, String value2) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        setPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        $("#state").click();
        statecityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        $("#city").click();
        statecityInput.$(byText(value)).click();
        $("#submit").pressEnter();
        return this;
    }
    public RegistrationPage checkStudentName(String expectedName) {
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(expectedName));
        return this;
    }

    public RegistrationPage checkStudentEmail(String expectedEmail) {
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(expectedEmail));
        return this;
    }
    public RegistrationPage checkStudentGender(String expectedGender) {
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(expectedGender));
        return this;
    }
    public RegistrationPage checkStudentMobile(String expectedMobile) {
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(expectedMobile));
        return this;
    }
    public RegistrationPage checkDateOfBirth(String expectedDateOfBirth) {
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(expectedDateOfBirth));
        return this;
    }
    public RegistrationPage checkSubjects(String expectedSubject) {
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(expectedSubject));
        return this;
    }

}
