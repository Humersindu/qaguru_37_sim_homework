package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropRectangleTest {

    /**
     * Настройки для запуска теста
     */
    @BeforeEach
    void setUp () {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    /**
     * Подготовка тестовых данных для следующего теста
     */
    @AfterEach
    void prepareToNextTest () {
        refresh();
    }

    /**
     * Проверка перемещения квадрата (прямоугольника)
     * с помощью имитации зажатия ЛКМ
     */
    @Test
    void moveRectangleByMoveToElementAndCheck () {
        Selenide.open("/drag_and_drop");

        actions()
                .moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"))
                .release()
                .perform();
        $("#column-a").shouldHave(Condition.exactText("B"));
        $("#column-b").shouldHave(Condition.exactText("A"));
    }

    /**
     * Проверка перемещения квадрата (прямоугольника)
     * с помощью функции dragAndDrop
     */
    @Test
    void moveRectangleByDragAndDropAndCheck () {
        Selenide.open("/drag_and_drop");

        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(Condition.exactText("B"));
        $("#column-b").shouldHave(Condition.exactText("A"));
    }
}
