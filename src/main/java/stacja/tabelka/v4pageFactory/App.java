package stacja.tabelka.v4pageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stacja.Global;

import java.util.List;

public class App {

    public static void main(String[] args) {

        // wyswietlic: tytul tabeli, kolumny, udzial Chrome na rynku
        Global.runInBrowser(driver -> {
            // opcja #1
//            MarketSharePage page = new MarketSharePage(driver);
//            PageFactory.initElements(driver, page);

            // opcja #2
//            MarketSharePage page = PageFactory.initElements(driver, MarketSharePage.class);

            // opcja #3 (konstruktor MarketSharePage posiada inicjalizacje w PageFactory)
//            MarketSharePage page = new MarketSharePage(driver);

            // opcja #4 (konstruktor z inicjalizacja PageFactory umieszczamy w TemplatePage,
            //           ktory nastepnie rozszerzamy)
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
