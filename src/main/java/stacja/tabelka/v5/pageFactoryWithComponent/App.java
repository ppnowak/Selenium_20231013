package stacja.tabelka.v5.pageFactoryWithComponent;

import stacja.Global;

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

            String browserName = "Firefox";
            int mktShareColPos = columnNames.indexOf("Share");
            var cells = page.getTable().findRowByColumnValue("Browser", browserName);
            if (cells != null) {
                var marketShareElement = cells.get(mktShareColPos);
                System.out.println(String.format("Market share for %s is: %s",
                        browserName, marketShareElement.getText()));
            }

        });

    }

}
