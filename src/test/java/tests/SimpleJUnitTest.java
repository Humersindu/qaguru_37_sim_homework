package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    int number;

    @BeforeAll
    static void beforeAll () {
        System.out.println("\n >>>>>>> before All \n");
    }

    @AfterAll
    static void afterAll () {
        System.out.println("\n >>>>>>> after All \n");
    }

    @BeforeEach
    void valueAssigment () {
        System.out.println("Значение number становится равным " + result ());
        number = result();
    }

    @AfterEach
    void resetValus () {
        number = 0;
        System.out.println("Значение number становится равным  + number");
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(number>2);
        System.out.println("\n Тест № 1 \n");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(number>2);
        System.out.println("\n Тест № 2 \n");
    }

    @Test
    void thirdTest() {
        Assertions.assertTrue(number>2);
        System.out.println("\n Тест № 3 \n");
    }

    private int result () {
        return 3;
    }

}
