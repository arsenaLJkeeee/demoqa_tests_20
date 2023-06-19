package com.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests extends TestBase {

    @BeforeEach
    void openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @DisplayName("Заполненная форма должна показывать корректные данные при нажатии на submit")
    @CsvSource(value = {
            "Alex |  alex@mail.ru | Industrialnaia street | Permanent address of Alex",
            "Mikhail    |  mikhail@mail.ru | Mikhailovskaya street | Permanent address of Mikhail"
    },
            delimiter = '|')
    @ParameterizedTest
    void filledTextBoxPageShouldShowCorrectDataAfterSubmitClick(String firstName, String eMail, String currentAddress, String permanentAddress) {
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(eMail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();
        $$(byText(firstName));
        $$(byText(eMail));
        $$(byText(currentAddress));
        $$(byText(permanentAddress));
    }

    @ParameterizedTest
    @MethodSource("dataArguments")
    void filledTextBoxPageShouldShowCorrectDataUsingMethodSource(String firstName, String eMail, String currentAddress, String permanentAddress) {
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(eMail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $$(byText(firstName));
        $$(byText(eMail));
        $$(byText(currentAddress));
        $$(byText(permanentAddress));
    }

    static Stream<Arguments> dataArguments() {
        return Stream.of(
                Arguments.of("Sasha", "sasha@mail.ru", "Sashinskaya street", "Permanent address of Sasha"),
                Arguments.of("Grisha", "grisha@mail.ru", "Grishinskaya street", "Permanent address of Grisha")
        );
    }
}
