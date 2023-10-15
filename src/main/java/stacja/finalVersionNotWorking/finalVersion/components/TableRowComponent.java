package stacja.finalVersionNotWorking.finalVersion.components;

import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TableRowComponent extends TemplateComponent {

    @FindBy(css = "th, td")
    List<WebElement> cells;

    @Setter
    private List<String> columnsNames;

    public TableRowComponent(WebElement wrappedElement) {
        super(wrappedElement);
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
