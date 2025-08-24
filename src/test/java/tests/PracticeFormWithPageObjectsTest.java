package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormWithPageObjectsTest extends BaseTest{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    /**
     * Тест проверки заполнения всех полей и отправки формы
     */
    @Test
    void allFieldsFillingPositiveTest () {
        practiceFormPage.openPage()
                //Заполнение форм
                .setFirstName("Homer")
                .setLastName("Simpson")
                .setUserEmail("hjsimpson@sprf.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("05", "June", "1975")
                .setSubjects("maths, physics, chemistry, history")
                .setHobbies()
                .uploadFile("oldmanyellstosky.jpg")
                .setAddress("Old Ham Lane Pedmore  Stourbridge DY9 0UN UNITED KINGDOM")
                .setState(0)
                .setCity(1)

                .submitClick()

                //Проверки
                .successSubmitCheck("Thanks for submitting the form")
                .checkResult("Student Name", "Homer Simpson")
                .checkResult("Student Email", "hjsimpson@sprf.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Address", "Old Ham Lane Pedmore  Stourbridge DY9 0UN UNITED KINGDOM");

        System.out.println("Позитивный тест на проверку отправки формы по всем полям пройден");
    }

    /**
     *  Тест проверки заполнения обязательных полей и отправки формы
     */
    @Test
    void requiredFieldsFillingPositiveTest () {
        practiceFormPage.openPage()
                //Заполнение форм
                .setFirstName("Homer")
                .setLastName("Simpson")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("05", "June", "1975")

                .submitClick()

                //Проверки
                .successSubmitCheck("Thanks for submitting the form")
                .checkResult("Student Name", "Homer Simpson")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890");

        System.out.println("Позитивный тест на проверку отправки формы по обязательным полям пройден");
    }

    /**
     * Тест проверки отправки пустой формы и работы валидации
     */
    @Test
    void fillFieldsNegativeTest () {
        practiceFormPage.openPage()

                //Отправка формы без заполнения полей
                .submitClick()

                //Проверка активации валидации на форме
                .emptyFieldsSubmitCheck();

        System.out.println("негативный тест на проверку отправки формы с пустыми полями пройден");
    }
}
