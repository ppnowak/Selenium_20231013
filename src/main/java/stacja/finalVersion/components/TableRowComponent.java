package stacja.finalVersion.components;

import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TableRowComponent extends TemplateComponent {

    @FindBy(css = "th, td")
    List<WebElement> cells;

    @FindBy(xpath = "../../thead/tr/th")
    List<WebElement> columnNamesElements;

    public TableRowComponent(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String getCellValueByIndex(int position) {
        return cells.get(position).getText();
    }

    private int getColumnIndex(String columnName) {
        List<String> columnsNames = columnNamesElements.stream().map(WebElement::getText).collect(Collectors.toList());
        return columnsNames.indexOf(columnName);
    }

    public String getCellValue(String columnName) {
        return getCellValueByIndex(getColumnIndex(columnName));
    }

}
