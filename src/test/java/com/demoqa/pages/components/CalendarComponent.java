package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        // Клик для открытия датапикера
        $("#dateOfBirthInput").click();
        // Клик для выбора месяца (например, июнь)
        $(".react-datepicker__month-select").selectOption(month);
        // Клик для выбора года (например, 1992)
        $(".react-datepicker__year-select").selectOption(year);
        // Клик для выбора даты (например, 22)
        $(".react-datepicker__day--0"+day).click();
    }
}
