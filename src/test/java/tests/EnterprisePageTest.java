package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterprisePageTest {

    /**
     * Запуск браузера и открытие стартовой страницы в GH
     */
    @BeforeAll
    static void openGitHubPage() {
        open("https://github.com/");
    }

    /**
     * Поиск кнопки открытия страницы Enterprise
     * и проверка корректности открытия страницы
     */
    @Test
    void navigateAndCheckEnterprisePage () {
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
        Assertions.assertTrue(webdriver().driver().url().contains("github.com/enterprise"), "Открыта некорректная страница");
    }
}
