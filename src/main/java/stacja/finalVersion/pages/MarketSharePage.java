package stacja.finalVersion.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import stacja.Global;
import stacja.finalVersion.components.TableComponent;

public class MarketSharePage extends TemplatePage {

    @Getter
    @FindBy(css = ".container")
    private TableComponent table;

    public MarketSharePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(Global.PAGE_URL + "/table/");
    }

    public String getMarketShareForBrowser(String browserName) {
        var row = getTable().findRowByColumnValue("Browser", browserName);
        if (row != null) {
            return row.getCellValue("Share");
        }
        return null;
    }


}
