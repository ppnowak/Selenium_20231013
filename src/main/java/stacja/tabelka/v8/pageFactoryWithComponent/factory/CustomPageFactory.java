package stacja.tabelka.v8.pageFactoryWithComponent.factory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class CustomPageFactory {

    public static void init(SearchContext context, Object obj) {
        var elementLocatorFactory = new DefaultElementLocatorFactory(context);
        var fieldDecorator = new CustomFieldDecorator(elementLocatorFactory);
        PageFactory.initElements(fieldDecorator, obj);
    }

}
