package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderTest {
    private WebDriver webDriver;
    @Before
    public void setuo() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderNotFound() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("23323");
        mainPage.clickGoButton();

        assertTrue(mainPage.notFoundImageIsDisplayed());
    }

    @Test
    public void createOrderFromHeader() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickCreateOrderInHeader();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo("Имя", "Фамилия", "Адрес", "Арбатская", "89164887784");
        orderPage.clickNextButton();
        orderPage.fillRentInfo("01.01.2025");
        orderPage.clickCreateOrderButton();
        orderPage.clickYesButton();

        assertTrue(orderPage.successStringIsDisplayed());
    }

    @Test
    public void createOrderFromBottom() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickCreateOrderInBottom();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo("Сергей", "Иванов", "Соколово-Мещерская 6", "Планерная", "89160001234");
        orderPage.clickNextButton();
        orderPage.fillRentInfo("10.10.2024");
        orderPage.clickCreateOrderButton();
        orderPage.clickYesButton();

        assertTrue(orderPage.successStringIsDisplayed());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
