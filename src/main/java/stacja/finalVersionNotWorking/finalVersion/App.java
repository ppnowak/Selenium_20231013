package stacja.finalVersionNotWorking.finalVersion;

import stacja.Global;
import stacja.finalVersionNotWorking.finalVersion.pages.MarketSharePage;
import stacja.finalVersionNotWorking.finalVersion.pages.ShopPage;

import java.util.List;

public class App {

    public static void main(String[] args) {

        // wyswietlic dla kazdego przedmiotu: nazwe, cene, url obrazka i dodac do koszyka
        Global.runInBrowser(driver -> {
            ShopPage page = new ShopPage(driver);
            page.open();
            for (var i=0; i<page.getItems().size(); i++) {
                var item = page.getItems().get(i);
                System.out.println(String.format("%s | %s | %s",
                        item.getName(),
                        item.getPrice(),
                        item.getImageUrl()
                ));
                item.add();
            }

            MarketSharePage sharePage = new MarketSharePage(driver);
            page.open();

            String title = sharePage.getTable().getTitle();
            System.out.println(String.format("Title: %s", title));

            List<String> columnNames = sharePage.getTable().getColumnsNames();
            System.out.println(String.format("Column names: %s", columnNames));

            sharePage.getTable().waitForRecords();

            String browserName = "Chrome";
            var row = sharePage.getTable().findRowByColumnValue("Browser", browserName);
            if (row != null) {
                var marketShare = row.getCellValue("Share");
                System.out.println(String.format("Market share for %s is: %s",
                        browserName, marketShare));
            }

        });

    }

}
