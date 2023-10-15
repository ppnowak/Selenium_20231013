package stacja.shop.v2.factory;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import stacja.shop.v2.components.ShopItemComponent;

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
        if (List.class.isAssignableFrom(field.getType())) {
            Class<?> wrappedClass = (Class) (((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
            if (wrappedClass != null && ShopItemComponent.class.isAssignableFrom(wrappedClass)) {
                ElementLocator locator = this.factory.createLocator(field);
                InvocationHandler handler = new ShopItemComponentLocatingElementListHandler(locator);
                List<ShopItemComponent> proxy = (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
                return proxy;
            }
        }
        return super.decorate(loader, field);
    }

}
