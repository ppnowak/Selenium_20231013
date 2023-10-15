package stacja.shop.v2;

import stacja.Global;
import stacja.shop.v2.pages.ShopPage;

public class App {

    public static void main(String[] args) {

        // wyswietlic dla kazdego przedmiotu: nazwe, cene, url obrazka i dodac do koszyka
        Global.runInBrowser(driver -> {
            ShopPage page = new ShopPage(driver);
            page.open();
            // Kod ponizej generuje StaleElementReferenceExceptio
//            for (var item : page.getItems()) {
//                System.out.println(String.format("%s | %s | %s",
//                        item.getName(),
//                        item.getPrice(),
//                        item.getImageUrl()
//                ));
//                item.add();
//            }

            for (var i=0; i<page.getItems().size(); i++) {
                var item = page.getItems().get(i);
                System.out.println(String.format("%s | %s | %s",
                        item.getName(),
                        item.getPrice(),
                        item.getImageUrl()
                ));
                item.add();
            }
        });

    }

}
