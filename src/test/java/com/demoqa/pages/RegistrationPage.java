package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }  public void setLastName(String value) {
        lastNameInput.setValue(value);
    }  public void setUserEmail(String value) {
        userEmailInput.setValue(value);
    }
}
