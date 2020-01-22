package data;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class YandexPage extends Page {

    @FindBy(xpath = "//input[@id='text']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='popup__content']//li")
    private List<WebElement> dropdown;

    @FindBy(xpath = "//a[contains(text(),'Картинки')]")
    private WebElement images;

    @FindBy(xpath = "//span[contains(@class, 'input__clear')]")
    private WebElement clear;

    @Step("Открытие страницы")
    public void openYandex() {
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
    }

    @Step("Ввод значения '{value}' в поле поиска")
    public void clickSearchSetValue(String value) {
        search.click();
        search.sendKeys(value);
    }

    @Step("Выбрать вкладку \"Картинки\"")
    public void clickImages() {
        images.click();
    }

    @Step("Нажать очистить поиск")
    public void clickClear() {
        clear.click();
    }

    @Step("Получить значения поиска по слову")
    public List<String> getDropdown(String str) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@class='popup__content']//li"), str));
        return dropdown.stream().map(WebElement::getText).map(e -> e.replaceAll("\\n", " ")).collect(Collectors.toList());
    }

    @Step("Получить значения url")
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
