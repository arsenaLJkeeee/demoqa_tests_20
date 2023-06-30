package com.demoqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;

import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;


public class RemoteRegistrationWithPageObjectsTestsWithTestData extends RemoteTestBase{
   RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
     void successfulRegistrationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomGender(),
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                day = getRandomDay(),
                month = getRandomMonth(),
                year = getRandomYear(),
                subject = getRandomSubject(),
                hobbie = getRandomHobbie(),
                state = getRandomState(),
                city = getRandomCity(state),
                address = faker.address().fullAddress(),
                picture = "test_file.jpg";

        step("Open page and fill the form", () -> {registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(phoneNumber)
                .setBirthDay(day,month,year)
                .setSubjects(subject)
                .setHobbie(hobbie)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();});

        step("Check the result", () -> {registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", "State and City" + " " + state + " " + city);});

    }
}