package stacja.tabelka.v7.pageFactoryWithComponent;

import stacja.Global;
import stacja.tabelka.v7.pageFactoryWithComponent.pages.MarketSharePage;

import java.util.List;

public class App {

    public static void main(String[] args) {

        // wyswietlic: tytul tabeli, kolumny, udzial Chrome na rynku
        Global.runInBrowser(driver -> {
            MarketSharePage page = new MarketSharePage(driver);
            page.open();

            String title = page.getTable().getTitle();
            System.out.println(String.format("Title: %s", title));

            List<String> columnNames = page.getTable().getColumnsNames();
            System.out.println(String.format("Column names: %s", columnNames));

            page.getTable().waitForRecords();

            String browserName = "Chrome";
            var row = page.getTable().findRowByColumnValue("Browser", browserName);
            if (row != null) {
                var marketShare = row.getCellValue("Share");
                System.out.println(String.format("Market share for %s is: %s",
                        browserName, marketShare));
            }

        });

    }

}
