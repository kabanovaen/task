package task;

import static data.Page.getDriver;

import check.YandexChecks;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import data.YandexPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * TaskTest.
 *
 * @author Ekaterina_Kabanova
 */

public class TaskTest {

    private YandexPage yandexPage;
    private WebDriver driver;

    @DataProvider
    public Object[][] search() {
        return new Object[][]{
                {"погода"}, {"Липецк"}, {"Лото"}};
    }

    @BeforeMethod
    public void before() {
        driver = getDriver();
        yandexPage = new YandexPage();
        yandexPage.openYandex();
    }

    @Test(description = "Вывести на экран запарсинное содержимое выпадающего списка поиска", dataProvider = "search")
    @Severity(SeverityLevel.NORMAL)
    public void yandexSearchTest(String input) {
        yandexPage.clickSearchSetValue(input);
        List<String> dropdown = yandexPage.getDropdown(input);
        dropdown.forEach(Util::println);
        yandexPage.clickClear();
    }

    @Test(description = "Проверить корректное отображение вкладки \\\"Картинки\\\"")
    @Severity(SeverityLevel.NORMAL)
    public void yandexImagesTest() {
        YandexChecks yandexChecks = new YandexChecks();
        yandexPage.clickImages();
        yandexChecks.checkImagesCorrect(yandexPage);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }

}
