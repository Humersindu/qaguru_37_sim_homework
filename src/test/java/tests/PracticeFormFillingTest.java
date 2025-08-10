package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormFillingTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFieldAndCheckOutput () {
        open("/automation-practice-form");
        $("#firstName").sendKeys("Homer");
        $("#lastName").sendKeys("Simpson");
        $("#userEmail").sendKeys("hjsimpson@sprf.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").sendKeys("1020304050");
    }

}
