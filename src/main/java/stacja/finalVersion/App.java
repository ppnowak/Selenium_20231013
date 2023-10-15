package stacja.finalVersion;

import stacja.Global;
import stacja.finalVersion.pages.MarketSharePage;
import stacja.finalVersion.pages.ShopPage;

import java.util.List;

public class App {

    public static void main(String[] args) {


        Global.runInBrowser(driver -> {
            // wyswietlic dla kazdego przedmiotu: nazwe, cene, url obrazka i dodac do koszyka
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

            // wyswietlic: tytul tabeli, kolumny, udzial Chrome na rynku
            MarketSharePage sharePage = new MarketSharePage(driver);
            sharePage.open();

            String title = sharePage.getTable().getTitle();
            System.out.println(String.format("Title: %s", title));

            List<String> columnNames = sharePage.getTable().getColumnsNames();
            System.out.println(String.format("Column names: %s", columnNames));

//            sharePage.getTable().waitForRecords();

            String browserName = "Chrome";
            String marketShare = sharePage.getMarketShareForBrowser(browserName);
            System.out.println(String.format("Market share for %s is: %s", browserName, marketShare));

        });

    }

}
