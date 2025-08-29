package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.DataGenerator;

import static utils.Constant.*;

public class PracticeFormPOAndJavaFakerTest extends BaseTest{

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    DataGenerator dataGenerator = new DataGenerator();

    String firstName = dataGenerator.setFirstName();
    String lastname = dataGenerator.setLastName();
    String email = dataGenerator.setUserEmail();
    String address = dataGenerator.setAddress();
    String number = dataGenerator.setNumber();
    String fullName = String.format("%s %s", firstName, lastname);
    String gender = dataGenerator.setGender();
    String day = dataGenerator.dayNumber();
    String month = dataGenerator.month();
    String year = dataGenerator.year(1950, 2000);
    int state = dataGenerator.stateNumber();
    int city = dataGenerator.cityNumber();

    /**
     * Тест проверки заполнения всех полей и отправки формы
     */
    @Test
    void allFieldsFillingPositiveTest () {
        practiceFormPage.openPage()
                .deleteBanner()
                //Заполнение форм
                .setFirstName(firstName)
                .setLastName(lastname)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubjects(SUBJECTS)
                .setHobbies()
                .uploadFile(PICTURE_PATH)
                .setAddress(address)
                .setState(state)
                .setCity(city)

                .submitClick()

                //Проверки
                .successSubmitCheck(TABLE_RESULT_BANNER)
                .checkResult(TABLE_RESULT_NAME, fullName)
                .checkResult(TABLE_RESULT_EMAIL, email)
                .checkResult(TABLE_RESULT_GENDER, gender)
                .checkResult(TABLE_RESULT_MOBILE, number)
                .checkResult(TABLE_RESULT_ADDRESS, address);

        System.out.println("Позитивный тест на проверку отправки формы по всем полям пройден");
    }

    /**
     *  Тест проверки заполнения обязательных полей и отправки формы
     */
    @Test
    void requiredFieldsFillingPositiveTest () {
        practiceFormPage.openPage()
                .deleteBanner()
                //Заполнение форм
                .setFirstName(firstName)
                .setLastName(lastname)
                .setGender(gender)
                .setUserNumber(number)
                .setDateOfBirth(day, month, year)

                .submitClick()

                //Проверки
                .successSubmitCheck(TABLE_RESULT_BANNER)
                .checkResult(TABLE_RESULT_NAME, fullName)
                .checkResult(TABLE_RESULT_GENDER, gender)
                .checkResult(TABLE_RESULT_MOBILE, number);

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
