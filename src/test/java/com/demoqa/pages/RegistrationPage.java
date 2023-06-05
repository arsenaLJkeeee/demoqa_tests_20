package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");

    public void setFirstName() {
        firstNameInput.setValue("Vladimir");
    }  public void setLastName() {
        lastNameInput.setValue("Vladimir");
    }  public void setUserEmail() {
        userEmailInput.setValue("Vladimir");
    }
}
