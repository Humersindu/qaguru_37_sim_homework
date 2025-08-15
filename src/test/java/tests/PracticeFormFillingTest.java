package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormFillingTest {

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFieldsAndCheckOutput () {
        //Открытие тестируемой страницы
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        //Заполнение текстовых полей
        $("#firstName").sendKeys("Homer");
        $("#lastName").sendKeys("Simpson");
        $("#userEmail").sendKeys("hjsimpson@sprf.com");
        $("#userNumber").sendKeys("1020304050");
        $("#subjectsInput").sendKeys("maths, physics, chemistry, history");
        $("#currentAddress").sendKeys("Old Ham Lane Pedmore  Stourbridge DY9 0UN UNITED KINGDOM");

        //Выбор значения для датапикера
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(by("value", "4")).click();
        $(".react-datepicker__year-select").click();
        $(by("value", "1988")).click();
        $(".react-datepicker__day--025").click();

        //Радиобаттоны и чек-боксы
        $("#genterWrapper").$(byText("Male")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        //Добавление файла
        $("#uploadPicture").uploadFromClasspath("oldmanyellstosky.jpg");

        //Выбор значений в выпадающем списке
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        //Передача данных
        $("#submit").click();

        //Проверка открытия модального окна
        $("[class=modal-content]").shouldBe(appear);
        $("[class=modal-header]").shouldHave(text("Thanks for submitting the form"));

        //Проверка соответствия передаваемых значений отображаемым
        $(".table").shouldHave(text("Homer"));
        $(".table").shouldHave(text("Simpson"));
        $(".table").shouldHave(text("hjsimpson@sprf.com"));
        $(".table").shouldHave(text("1020304050"));
        $(".table").shouldHave(text("Old Ham Lane Pedmore  Stourbridge DY9 0UN UNITED KINGDOM"));

        //Закрытие модального окна
        $("#closeLargeModal").click();
    }
}
