package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail");

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }
    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }
    public void setUserEmail(String value) {
        userEmailInput.setValue(value);
    }
}
