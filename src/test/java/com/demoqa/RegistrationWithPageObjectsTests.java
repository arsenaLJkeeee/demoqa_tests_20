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
               .checkStudentName("Vladimir Borchevskiy")
               .checkStudentEmail("arsenaljkeeee10@gmail.com")
               .checkStudentGender("Male")
               .checkStudentMobile("5597078392")
               .checkDateOfBirth("22 June,1992")
               .checkSubjects("Computer Science")
               .checkHobbies("Sports, Music")
               .checkPicture("test_file.jpg")
               .checkAddress("Georgia, Batumi")
               .checkStateAndCity("Uttar Pradesh");
    }
}