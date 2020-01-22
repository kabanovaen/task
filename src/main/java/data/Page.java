package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class Page {

    public static WebDriver driver = null;

    public Page() {
        PageFactory.initElements(getDriver(), this);
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
