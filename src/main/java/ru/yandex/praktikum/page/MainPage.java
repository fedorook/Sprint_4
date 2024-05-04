package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
private final WebDriver webDriver;
// 'Статус заказа' button
private final By orderStatusLocator = By.xpath("//button[text()='Статус заказа']");
// 'да все привыкли' cookies agreement button
private final By cookiesButtonLocator = By.id("rcc-confirm-button");
// 'Введите номер заказа' input field
private final By orderNumberInputLocator = By.xpath("//input[@placeholder='Введите номер заказа']");
// 'Go!' button
private final By goButtonLocator = By.xpath("//button[text()='Go!']");
// 'Not found' image
private final By notFoundImageLocator = By.xpath("//img[@alt='Not found']");
// 'Заказать' button in the header
private final By createOrderHeaderButtonLocator = By.xpath("//div[contains(@class, 'Header')]//button[text()='Заказать']");
// 'Заказать' button in the bottom
private final By createOrderBottomButtonLocator = By.xpath("//div[contains(@class, 'Header')]//button[text()='Заказать']");
// Accordion question locator
private final String questionLocator = "accordion__heading-%s";
// Accordion answer locator
private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderStatusButton() {
        WebElement orderStatusButton  = webDriver.findElement(orderStatusLocator);
        orderStatusButton.click();
    }

    public void enterOrderNumber(String orderNumber) {
        WebElement orderInput = webDriver.findElement(orderNumberInputLocator);
        new WebDriverWait(webDriver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderInput));
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

    // A method for createOrder test starting from the Header order button
    public void clickCreateOrderInHeader() {
        WebElement createOrderButton  = webDriver.findElement(createOrderHeaderButtonLocator);
        createOrderButton.click();
    }

    // A method for createOrder test starting from the Bottom order button
    public void clickCreateOrderInBottom() {
        WebElement createOrderButton  = webDriver.findElement(createOrderBottomButtonLocator);
        createOrderButton.click();
    }

    public void closeCookiesWindow() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(cookiesButtonLocator));
        cookiesButton.click();
    }
// Accordion-related methods
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element)
        ));
        element.click();
    }

    public boolean answerIsDisplayed(String expetedAnswer) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(answerLocator, expetedAnswer))));
        return element.isDisplayed();
    }
}
