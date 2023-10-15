package stacja.finalVersionNotWorking.finalVersion.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import stacja.finalVersionNotWorking.finalVersion.components.TemplateComponent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.List;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    public Object decorate(ClassLoader loader, Field field) {
        if (TemplateComponent.class.isAssignableFrom(field.getType())) {
            ElementLocator locator = this.factory.createLocator(field);
            WebElement element = this.proxyForLocator(loader, locator);
            return new TemplateComponent(element);
        } else if (List.class.isAssignableFrom(field.getType())) {
            Class<?> wrappedClass = (Class) (((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
            if (wrappedClass != null && TemplateComponent.class.isAssignableFrom(wrappedClass)) {
                ElementLocator locator = this.factory.createLocator(field);
                InvocationHandler handler = new TemplateComponentLocatingElementListHandler(locator);
                List<TemplateComponent> proxy = (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
                return proxy;
            }
        }
        return super.decorate(loader, field);
    }

}
