package com.demoqa;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


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
               .submitForm();

        registrationPage.checkResult("Student Name", "Vladimir Borchevskiy")
                .checkResult("Student Email", "arsenaljkeeee10@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "5597078392")
                .checkResult("Date of Birth", "22 June, 1992")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "test_file.jpg")
                .checkResult("Address", "Georgia, Batumi")
                .checkResult("State and City", "Uttar Pradesh, Agra");
    }
}