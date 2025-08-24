package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends BaseTest{
    private static final String name = "Homer Simpson";
    private static final String email = "hjsimpson@sprf.com";
    private static final String currentAddress = "742 Evergreen Terrace, Springfield, USA";
    private static final String permanentAddress = "Springfield Nuclear Power Plant, 100 Industrial District, Springfield, USA";

    TextBoxPage textBoxPage = new TextBoxPage();

    /**
     *  Тест проверки заполнения части полей и отправки формы
     */
    @Test
    void checkNameAndEmailTextBox () {
        textBoxPage.openPage()
                .setName(name)
                .setEmail(email)

                .submitClick()

                .checkResult("Name", name)
                .checkResult("Email", email);

        System.out.println("Проверка отправки формы со полями Name и Email выполнена");
    }

    /**
     *  Тест проверки заполнения всех полей и отправки формы
     */
    @Test
    void checkAllFieldsTextBox () {
        textBoxPage.openPage()
                .setName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)

                .submitClick()

                .checkResultForFullFields(name, email, currentAddress, permanentAddress);

        System.out.println("Проверка отправки формы со всеми заполненными текстовыми полями выполнена");
    }
}