package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
private final WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderStatusButton() {
        WebElement orderStatusButton  = webDriver.findElement(By.xpath("//button[text()='Статус заказа']"));
        orderStatusButton.click();
    }
}
