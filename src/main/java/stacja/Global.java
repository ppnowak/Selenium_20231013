package stacja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stacja.tabelka.v3.MarketSharePage;

import java.util.List;
import java.util.function.Consumer;

public class Global {

    public static final String PAGE_URL = "https://breathtaking.website/selenium_20231014";

    public static void runInBrowser(Consumer<WebDriver> action) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            action.accept(driver);
        } finally {
            driver.quit();
        }
    }

}
