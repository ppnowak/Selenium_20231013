package stacja;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    @Getter
    private static By selector = By.cssSelector(".header__title");

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://stacja.it/");
            var title = driver.findElement(getSelector());
            System.out.println(title.getText());
        } finally {
            driver.quit();
        }

    }

}
