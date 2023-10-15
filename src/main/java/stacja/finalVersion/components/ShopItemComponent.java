package stacja.finalVersion.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopItemComponent extends TemplateComponent {

    @FindBy(css = "h4")
    private WebElement name;

    @FindBy(css = ".pricing-card-title")
    private WebElement price;

    @FindBy(css = "img")
    private WebElement image;

    @FindBy(css = ".btn")
    private WebElement addButton;

    public ShopItemComponent(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String getName() {
        return name.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getImageUrl() {
        return image.getAttribute("src");
    }

    public void add() {
        addButton.click();
    }

}
