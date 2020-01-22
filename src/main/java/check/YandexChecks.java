package check;

import data.YandexPage;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * YandexChecks.
 *
 * @author Ekaterina_Kabanova
 */
public class YandexChecks {

    @Step("Проверить, что открыта вкладка \"Картинки\"")
    public void checkImagesCorrect(YandexPage yandexPage) {
        String url = yandexPage.getUrl();
        Assert.assertTrue(url.contains("images"),"Вкладка открыта не \"Картинки\"");
    }

}
