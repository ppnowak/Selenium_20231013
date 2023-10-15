package stacja.tabelka.v3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stacja.Global;

import java.time.Duration;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // wyswietlic: tytul tabeli, kolumny, udzial Chrome na rynku
        Global.runInBrowser(driver -> {
            MarketSharePage page = new MarketSharePage(driver);
            page.open();

            String title = page.getTitle();
            System.out.println(String.format("Title: %s", title));

            List<String> columnNames = page.getColumnsNames();
            System.out.println(String.format("Column names: %s", columnNames));

            page.waitForRecords();

            String browserName = "Firefox";
            int mktShareColPos = columnNames.indexOf("Share");
            var cells = page.findRowByColumnValue("Browser", browserName);
            if (cells != null) {
                var marketShareElement = cells.get(mktShareColPos);
                System.out.println(String.format("Market share for %s is: %s",
                        browserName, marketShareElement.getText()));
            }
        });

    }

}
