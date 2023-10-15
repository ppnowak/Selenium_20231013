package stacja.shop.v1.notWorking;

import stacja.Global;
import stacja.shop.v1.notWorking.pages.ShopPage;

public class App {

    public static void main(String[] args) {

        // wyswietlic dla kazdego przedmiotu: nazwe, cene, url obrazka i dodac do koszyka
        Global.runInBrowser(driver -> {
            ShopPage page = new ShopPage(driver);
            page.open();
//            var item = page.getItem();
            for (var item : page.getItems()) {
                System.out.println(String.format("%s | %s | %s",
                        item.getName(),
                        item.getPrice(),
                        item.getImageUrl()
                ));
            }
        });

    }

}
