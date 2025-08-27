package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.DropDownComponent;
import pages.components.ResultTableComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.Constant.HOBBIES;

public class PracticeFormPage {
    private static final SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            currentAddress = $("#currentAddress"),
            uploadButton = $("#uploadPicture"),
            genderWrapper = $("#genterWrapper"),
            hobbiesWrapper =  $("#hobbiesWrapper"),
            submitButton = $("#submit"),
            modalContent = $("[class=modal-content]"),
            modalHeader = $("[class=modal-header]"),
            calendarInput = $("#dateOfBirthInput"),
            userForm = $("#userForm"),
            subjectButton = $("#react-select-2-option-0");


    CalendarComponent calendar = new CalendarComponent();
    DropDownComponent dropDown = new DropDownComponent();
    ResultTableComponent resultTable = new ResultTableComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName (String name) {
        PracticeFormPage.firstName.setValue(name);

        return this;
    }

    public PracticeFormPage setLastName (String name) {
        lastName.setValue(name);

        return this;
    }

    public PracticeFormPage setUserEmail (String email) {
        userEmail.setValue(email);

        return this;
    }

    public PracticeFormPage setUserNumber (String number) {
        userNumber.setValue(number);

        return this;
    }

    public PracticeFormPage setGender (String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public PracticeFormPage setSubjects (List <String> subjects) {
        subjectsInput.click();
        for (String subject : subjects) {
            subjectsInput.setValue(subject);
            subjectButton.click();
        }

        return this;
    }

    public PracticeFormPage setSubjects (String subjects) {
        subjectsInput.setValue(subjects);

        return this;
    }

    public PracticeFormPage setAddress (String address) {
        currentAddress.setValue(address);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage uploadFile (String path) {
        uploadButton.uploadFromClasspath(path);

        return this;
    }

    public PracticeFormPage setHobbies () {
        for (String hobby : HOBBIES) {
            hobbiesWrapper.$(byText(hobby)).click();
        }

        return this;
    }


    public PracticeFormPage setState (int district) {
        dropDown.selectState(district);

        return this;
    }

    public PracticeFormPage setCity (int city) {
        dropDown.selectCity(city);

        return this;
    }

    public PracticeFormPage submitClick () {
        submitButton.click();

        return this;
    }

    public PracticeFormPage successSubmitCheck (String bannerText) {
        modalContent.shouldBe(appear);
        modalHeader.shouldHave(text(bannerText));

        return this;
    }

    public PracticeFormPage emptyFieldsSubmitCheck() {
        userForm.shouldHave(attribute("class", "was-validated"));

        return this;
    }
    public PracticeFormPage checkResult (String key, String value) {
        resultTable.checkResult(key, value);

        return this;
    }
}