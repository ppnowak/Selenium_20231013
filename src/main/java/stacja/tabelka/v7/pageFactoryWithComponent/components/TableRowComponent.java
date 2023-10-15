package stacja.tabelka.v7.pageFactoryWithComponent.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TableRowComponent {

    @FindBy(css = "th, td")
    List<WebElement> cells;

    private final List<String> columnsNames;


    public TableRowComponent(WebElement element, List<String> columnsNames) {
        this.columnsNames = columnsNames;
        PageFactory.initElements(element, this);
    }

    public String getCellValueByIndex(int position) {
        return cells.get(position).getText();
    }

    private int getColumnIndex(String columnName) {
        return columnsNames.indexOf(columnName);
    }

    public String getCellValue(String columnName) {
        return getCellValueByIndex(getColumnIndex(columnName));
    }

}
