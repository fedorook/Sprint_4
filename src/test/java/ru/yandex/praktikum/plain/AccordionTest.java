package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.page.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AccordionTest {

    private WebDriver webDriver;
    private int index;
    private String answer;


    public AccordionTest(int index, String answer) {
        this.index = index;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."}
        };
    }

    @Before
    public void setup() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void accodrionTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.expandQuestion(index);
        boolean answerIsDisplayed = mainPage.answerIsDisplayed(answer);
        assertTrue(answerIsDisplayed);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}


