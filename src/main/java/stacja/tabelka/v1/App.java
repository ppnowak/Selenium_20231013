package stacja.tabelka.v1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // wyswietlic: tytul tabeli, kolumny, udzial Chrome na rynku

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://breathtaking.website/selenium_20231014/table/");

        WebElement element = driver.findElement(By.cssSelector("h2"));
        String title = element.getText();
        System.out.println(String.format("Title: %s", title));

        List<WebElement> columns = driver.findElements(By.cssSelector("thead tr th"));
        List<String> columnNames = columns.stream().map(WebElement::getText).toList();
        System.out.println(String.format("Column names: %s", columnNames));

        WebElement table = driver.findElement(By.cssSelector("table"));
        ExpectedCondition condition = ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(table, "Loading...")
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(condition);

        String browserName = "Firefox";
        int browserColPos = columnNames.indexOf("Browser");
        int mktShareColPos = columnNames.indexOf("Share");
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            List<WebElement> cell = row.findElements(By.cssSelector("th, td"));
            WebElement browserElement = cell.get(browserColPos);
            if (browserName.equals(browserElement.getText())) {
                WebElement marketShareElement = cell.get(mktShareColPos);
                System.out.println(String.format("Market share for %s is: %s",
                        browserName, marketShareElement.getText()));
                break;
            }
        }

        driver.quit();

    }

}
