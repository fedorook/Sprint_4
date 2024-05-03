package ru.yandex.praktikum.plain;

import org.junit.Test;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.page.MainPage;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    @Test
    public void orderNotFound() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOrderStatusButton();


        WebElement orderInput = webDriver.findElement(By.xpath("//input[@placeholder='Введите номер заказа']"));
        orderInput.sendKeys("23323");

        WebElement goButton = webDriver.findElement(By.xpath("//button[text()='Go!']"));
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();

        WebElement notFoundImg = webDriver.findElement(By.xpath("//img[@alt='Not found']"));
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(notFoundImg));
        assertTrue(notFoundImg.isDisplayed());

        webDriver.quit();
    }

    @Test
    public void createOrder() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement orderStatusButton  = webDriver.findElement(By.xpath("//div[contains(@class, 'Header')]//button[text()='Заказать']"));
        orderStatusButton.click();

        WebElement nameInput = webDriver.findElement(By.xpath("//input[@placeholder='* Имя']"));
        nameInput.sendKeys("Имя");

        WebElement lastnameInput = webDriver.findElement(By.xpath("//input[@placeholder='* Фамилия']"));
        lastnameInput.sendKeys("Фамилия");

        WebElement addressInput = webDriver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
        addressInput.sendKeys("Адрес");

        WebElement subwayInput = webDriver.findElement(By.xpath("//input[@placeholder='* Станция метро']"));
        subwayInput.click();

        WebElement arbatskayaStationMenu = webDriver.findElement(By.xpath("//button[@value='78'][./div[text()='Арбатская']]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", arbatskayaStationMenu);
        arbatskayaStationMenu.click();


        WebElement phoneInput = webDriver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
        phoneInput.sendKeys("89164887784");

        WebElement nextButton  = webDriver.findElement(By.xpath("//button[text()='Далее']"));
        nextButton.click();

        WebElement dateInput = webDriver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']"));
        dateInput.sendKeys("01.01.2025", Keys.ENTER);

        WebElement rentPeriodInput = webDriver.findElement(By.xpath("//div[text()='* Срок аренды']"));
        rentPeriodInput.click();

        WebElement rentPeriodMenuItem = webDriver.findElement(By.xpath("//div[text()='трое суток']"));
        rentPeriodMenuItem.click();

        WebElement createOrderButton = webDriver.findElement(By.xpath("//button[text()='Заказать']"));
        createOrderButton.click();

        webDriver.quit();

    }

}
