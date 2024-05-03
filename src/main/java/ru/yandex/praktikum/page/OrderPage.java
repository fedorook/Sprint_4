package ru.yandex.praktikum.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriver webDriver;
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By lastnameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final String stationMenuItemLocator = "//div[text()='%s']";
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButtonLocator = By.xpath("//button[text()='Далее']");
    private final By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriodInputLocator = By.xpath("//div[text()='* Срок аренды']");
    private final By rentPeriodMenuItemLocator = By.xpath("//div[text()='трое суток']");
    private final By createOrderButtonLocator = By.xpath("//button[text()='Заказать']");
    private final By yesButtonLocator = By.xpath("//button[(text()='Да')]");




    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillCustomerInfo(String name, String lastname, String address, String subwayTitle, String phone) {
        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);

        WebElement lastnameInput = webDriver.findElement(lastnameInputLocator);
        lastnameInput.sendKeys(lastname);

        WebElement addressInput = webDriver.findElement(addressInputLocator);
        addressInput.sendKeys(address);

        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.click();

        WebElement arbatskayaStationMenu = webDriver.findElement(By.xpath(String.format(stationMenuItemLocator, subwayTitle)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", arbatskayaStationMenu);
        arbatskayaStationMenu.click();


        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phone);
    }

    public void clickNextButton() {
        WebElement nextButton  = webDriver.findElement(nextButtonLocator);
        nextButton.click();
    }

    public void fillRentInfo(String date) {
        WebElement dateInput = webDriver.findElement(dateInputLocator);
        dateInput.sendKeys(date, Keys.ENTER);

        WebElement rentPeriodInput = webDriver.findElement(rentPeriodInputLocator);
        rentPeriodInput.click();

        WebElement rentPeriodMenuItem = webDriver.findElement(rentPeriodMenuItemLocator);
        rentPeriodMenuItem.click();
    }

    public void clickCreateOrderButton() {
        WebElement createOrderButton = webDriver.findElement(createOrderButtonLocator);
        createOrderButton.click();
    }

//    public void clickYesButton() {
//        WebElement yesButton = webDriver.findElement(yesButtonLocator);
//        new WebDriverWait(webDriver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(yesButton));
//        yesButton.click();
//    }
}
