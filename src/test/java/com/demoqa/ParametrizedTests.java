package com.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests extends ParametrizedTestsTestBase {

    @BeforeEach
    void openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @DisplayName("Заполненная форма должна показывать корректные данные при нажатии на submit, используем CsvSource")
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
    @DisplayName("Заполненная форма должна показывать корректные данные при нажатии на submit, используем MethodSource")
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
    @DisplayName("При вводе параметров без символа @ после клика Submit инпут отображает ошибку")
    @ParameterizedTest
    @ValueSource(
            strings = {"Olga", "Olgamail.ru", "Olginskaya street", "123*&%$#)("}
    )
    void emailWithoutProperSymbolShouldShowError(String eMail) {
        $("#userEmail").setValue(eMail);
        $("#submit").click();
        $("#userEmail").shouldBe(cssClass("field-error"));
    }
}
