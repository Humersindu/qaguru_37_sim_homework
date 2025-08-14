package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест проверки блока фильтрации на странице библиотеки в GH и проверки наличия кода на странице раздела Wiki")
public class FindingBarInWikiPageCheckTest {

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
        String wikiURL = Selenide.webdriver().driver().url();
        assertTrue(wikiURL.contains("selenide/wiki"), "Открыта страница с несоответствующим URL");

        $$(".Box-row.px-2.py-2").get(17).$("a").shouldHave(exactTextCaseSensitive("SoftAssertions")).click();
        $(withTagAndText("h4","JUnit5" )).parent().sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
