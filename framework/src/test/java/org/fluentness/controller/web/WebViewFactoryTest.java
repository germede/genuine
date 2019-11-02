package org.fluentness.controller.web;

import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.controller.web.markup.html.ContainerHtmlView;
import org.fluentness.controller.web.markup.html.EmptyHtmlView;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class WebViewFactoryTest {

    @Test
    public void stringContainerHtmlViewMethods_areCalled_markupElementAreCreated() throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        for (Method method : WebViewFactory.class.getMethods()) {
            if (method.getReturnType().equals(ContainerHtmlView.class) && method.getParameters()[0].getType().equals(String.class)) {
                ContainerHtmlView test = (ContainerHtmlView) method.invoke(null, "testInner");
                assertEquals(method.getName(), test.getTag());
                assertNull(test.getInnerViews());
                assertEquals("testInner", test.getInnerText());
                assertTrue(test.getAttributes().isEmpty());
                test.href("testHref");
                assertEquals("testHref", test.getAttributes().get("href"));
                i++;
            }
        }
        assertEquals(108, i);
    }

    @Test
    public void viewContainerHtmlViewMethods_areCalled_markupElementAreCreated() throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        for (Method method : WebViewFactory.class.getMethods()) {
            if (method.getReturnType().equals(ContainerHtmlView.class) && method.getParameters()[0].isVarArgs()) {
                ContainerHtmlView testWithInner = (ContainerHtmlView) method.invoke(null,
                    new Object[]{
                        new MarkupView[]{
                            WebViewFactory.div("testInner").class_("testClass"),
                            WebViewFactory.input().type("text")
                        }
                    }
                );
                assertEquals(method.getName(), testWithInner.getTag());
                assertEquals(2, testWithInner.getInnerViews().length);
                assertNull(testWithInner.getInnerText());
                assertTrue(testWithInner.getAttributes().isEmpty());
                testWithInner.href("testHref");
                assertEquals("testHref", testWithInner.getAttributes().get("href"));
                i++;
            }
        }
        assertEquals(108, i);
    }

    @Test
    public void emptyHtmlViewMethods_areCalled_markupElementAreCreated() throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        for (Method method : WebViewFactory.class.getMethods()) {
            if (method.getReturnType().equals(EmptyHtmlView.class)) {
                EmptyHtmlView test = (EmptyHtmlView) method.invoke(null);
                assertEquals(method.getName(), test.getTag());
                assertTrue(test.getAttributes().isEmpty());
                test.href("testHref");
                assertEquals("testHref", test.getAttributes().get("href"));
                i++;
            }
        }
        assertEquals(14, i);
    }


}
