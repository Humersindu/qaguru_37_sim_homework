package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тест проверки блока фильтрации на странице библиотеки в GH и проверки наличия кода на странице раздела Wiki")
public class FindingBarInWikiPageCheckTest {
    private final String codeExampleForJUnit5 = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
            
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }""";

    /**
     * Запуск браузера и открытие стартовой страницы в GH,
     * поиск Selenide
     */
    @BeforeAll
    static void openSelenidePage() {
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
    }

    /**
     * Открытие главной страницы указанной библиотеки,
     * переход в раздел Wiki, поиск ссылки на страницу SoftAsserion,
     * поиск элемента с текстом JUnit5 и проверка наличия под ним блока кода
     */
    @Test
    void checkFindingInWikiPageGH () {
        $$("[data-testid=results-list] h3").first().$("a").click();
        $("#wiki-tab").shouldBe(visible).click();

        $("#wiki-pages-filter").sendKeys("soft");
        $$("[class$=py-2]")
                .findBy(text("SoftAssertions"))
                .shouldBe(visible)
                .$("a")
                .click();
        $(withTagAndText("h4", "JUnit5")).parent().sibling(0).shouldHave(text(codeExampleForJUnit5));
    }
}