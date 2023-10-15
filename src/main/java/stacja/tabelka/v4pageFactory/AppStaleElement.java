package stacja.tabelka.v4pageFactory;

import org.openqa.selenium.WebElement;
import stacja.Global;

import java.util.List;

public class AppStaleElement {

    public static void main(String[] args) {

        // wyswietlic: tytul tabeli, kolumny, udzial Chrome na rynku
        Global.runInBrowser(driver -> {

            MarketSharePage page = new MarketSharePage(driver);
            page.open();

            // to rozwiazanie spowoduje StaleElementReferenceException
//            for (WebElement column : page.getColumnsList()) {
//                System.out.println(String.format("Value: %s", column.getText()));
//                driver.navigate().refresh();
//            }

            for (var i=0; i<page.getColumnsList().size(); i++) {
                var column = page.getColumnsList().get(i);
                System.out.println(String.format("Value: %s", column.getText()));
                driver.navigate().refresh();
            }

//            var title = page.getTitleElement();
//            for (var i=0;i<5;i++) {
//                System.out.println(String.format("Value: %s", title.getText()));
//                driver.navigate().refresh();
//            }

        });

    }

}
