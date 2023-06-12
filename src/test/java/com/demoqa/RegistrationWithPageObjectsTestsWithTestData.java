package com.demoqa;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static com.demoqa.utils.RandomUtils.*;


public class RegistrationWithPageObjectsTestsWithTestData extends TestBase{
   RegistrationPage registrationPage = new RegistrationPage();

    @Test
     void successfulRegistrationTest() {
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
                address = faker.address().fullAddress();

       registrationPage.openPage()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setUserEmail(userEmail)
               .setGender(userGender)
               .setUserNumber(phoneNumber)
               .setBirthDay(day,month,year)
               .setSubjects(subject)
               .setHobbie(hobbie)
               .uploadPicture("test_file.jpg")
               .setCurrentAddress(address)
               .setState(state)
               .setCity(city)
               .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", "test_file.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", "State and City" + " " + state + " " + city);
    }
}