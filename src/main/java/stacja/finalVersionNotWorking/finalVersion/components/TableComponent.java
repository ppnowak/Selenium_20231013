package stacja.finalVersionNotWorking.finalVersion.components;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class TableComponent extends TemplateComponent {

    @Getter
    @FindBy(css = "table")
    private WebElement table;

    @Getter
    @FindBy(css = "h2")
    private WebElement titleElement;

    @Getter
    @FindBy(css = "thead tr th")
    List<WebElement> columnsList;

    @FindBy(css = "tbody tr")
    List<TableRowComponent> rows;

    public TableComponent(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void waitForRecords() {
        var wait = new FluentWait<WebElement>(getTable()).withTimeout(Duration.ofSeconds(10));
        wait.until(e -> !e.getText().contains("Loading..."));
    }

    public String getTitle() {
        return getTitleElement().getText();
    }

    public List<String> getColumnsNames() {
        return getColumnsList().stream().map(WebElement::getText).toList();
    }

    public List<TableRowComponent> getRows() {
        rows.forEach(row -> row.setColumnsNames(getColumnsNames()));
        return rows;
    }

    public TableRowComponent findRowByColumnValue(String columnName, String cellValue) {
        for (TableRowComponent row : getRows()) {
            String columnValue = row.getCellValue(columnName);
            if (cellValue.equals(columnValue)) {
                return row;
            }
        }
        return null;
    }


}
