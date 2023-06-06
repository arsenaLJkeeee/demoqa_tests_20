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
        submitForm();
        return this;
    }
    public RegistrationPage checkStudentName(String expectedName) {
        return checkResult("Student Name", expectedName);
    }

    public RegistrationPage checkStudentEmail(String expectedEmail) {
        return checkResult("Student Email", expectedEmail);
    }

    public RegistrationPage checkStudentGender(String expectedGender) {
        return checkResult("Gender", expectedGender);
    }

    public RegistrationPage checkStudentMobile(String expectedMobile) {
        return checkResult("Mobile", expectedMobile);
    }

    public RegistrationPage checkDateOfBirth(String expectedDateOfBirth) {
        return checkResult("Date of Birth", expectedDateOfBirth);
    }

    public RegistrationPage checkSubjects(String expectedSubject) {
        return checkResult("Subjects", expectedSubject);
    }

    public RegistrationPage checkHobbies(String expectedHobbies) {
        return checkResult("Hobbies", expectedHobbies);
    }

    public RegistrationPage checkPicture(String expectedPicture) {
        return checkResult("Picture", expectedPicture);
    }

    public RegistrationPage checkAddress(String expectedAddress) {
        return checkResult("Address", expectedAddress);
    }

    public RegistrationPage checkStateAndCity(String expectedStateAndCity) {
        return checkResult("State and City", expectedStateAndCity);
    }
    public RegistrationPage submitForm() {
        $("#submit").pressEnter();
        return this;
    }
    public RegistrationPage checkResult(String field, String expectedValue) {
        $(".table-responsive").$(byText(field)).parent().shouldHave(text(expectedValue));
        return this;
    }

}
