package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
private final WebDriver webDriver;
private By orderStatusLocator = By.xpath("//button[text()='Статус заказа']");
private By orderNumberInputLocator = By.xpath("//input[@placeholder='Введите номер заказа']");
private By goButtonLocator = By.xpath("//button[text()='Go!']");
private By notFoundImageLocator = By.xpath("//img[@alt='Not found']");
private By createOrderButtonLocator = By.xpath("//div[contains(@class, 'Header')]//button[text()='Заказать']");





    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderStatusButton() {
        WebElement orderStatusButton  = webDriver.findElement(orderStatusLocator);
        orderStatusButton.click();
    }

    public void enterOrderNumber(String orderNumber) {
        WebElement orderInput = webDriver.findElement(orderNumberInputLocator);
        orderInput.sendKeys(orderNumber);
    }

    public void clickGoButton() {
        WebElement goButton = webDriver.findElement(goButtonLocator);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
    }

    public boolean notFoundImageIsDisplayed() {
        WebElement notFoundImg = webDriver.findElement(notFoundImageLocator);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(notFoundImg));
        return notFoundImg.isDisplayed();
    }

    public void clickCreateOrder() {
        WebElement createOrderButton  = webDriver.findElement(createOrderButtonLocator);
        createOrderButton.click();
    }
}
