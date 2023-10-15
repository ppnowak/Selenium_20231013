package stacja.tabelka.v8.pageFactoryWithComponent.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import stacja.tabelka.v8.pageFactoryWithComponent.components.TableComponent;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    public Object decorate(ClassLoader loader, Field field) {
        if (TableComponent.class.isAssignableFrom(field.getType())) {
            ElementLocator locator = this.factory.createLocator(field);
            WebElement element = this.proxyForLocator(loader, locator);
            return new TableComponent(element);
        }
        return super.decorate(loader, field);
    }

}
