package ru.yandex.praktikum.page;

import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver webDriver;
    // '* Имя' placeholder
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    // '* Фамилия' placeholder
    private final By lastnameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    // '* Адрес: куда привезти заказ' placeholder
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // '* Станция метро' placeholder
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    // A station in the drop-down menu, supporting passing parameters
    private final String stationMenuItemLocator = "//div[text()='%s']";
    // '* Телефон: на него позвонит курьер' placeholder
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // 'Далее' button
    private final By nextButtonLocator = By.xpath("//button[text()='Далее']");
    // '* Когда привезти самокат' placeholder
    private final By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // '* Срок аренды' placeholder
    private final By rentPeriodInputLocator = By.xpath("//div[text()='* Срок аренды']");
    // 'трое суток' option in drop-down menu
    private final By rentPeriodMenuItemLocator = By.xpath("//div[text()='трое суток']");
    // 'Заказать' button in the bottom, not in the header
    private final By createOrderButtonLocator = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    // 'Да' button
    private final By yesButtonLocator = By.xpath("//button[text()='Да']");
    // 'Заказ оформлен' string
    private final By successStringLocator = By.xpath("//div[text()='Заказ оформлен']");



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

    public void clickYesButton() {
        WebElement yesButton = webDriver.findElement(yesButtonLocator);
        yesButton.click();
    }

    public boolean successStringIsDisplayed() {
        WebElement successString = webDriver.findElement(successStringLocator);
        return successString.isDisplayed();
    }
}
