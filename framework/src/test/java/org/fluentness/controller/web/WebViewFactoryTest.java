package org.fluentness.controller.web;

import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.controller.web.markup.html.ContainerHtmlView;
import org.fluentness.controller.web.markup.html.EmptyHtmlView;
import org.fluentness.controller.web.markup.html.HtmlView;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebViewFactoryTest {

    @Test
    public void stringContainerHtmlViews_markupElementIsCreatedCorrectly() throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        for (Method method : WebViewFactory.class.getMethods()) {
            if (method.getReturnType().equals(ContainerHtmlView.class) && method.getParameters()[0].getType().equals(String.class)) {
                ContainerHtmlView test = (ContainerHtmlView) method.invoke(null, "testInner");
                Assert.assertEquals(method.getName(), test.getTag());
                Assert.assertNull(test.getInnerViews());
                Assert.assertEquals("testInner", test.getInnerText());
                Assert.assertTrue(test.getAttributes().isEmpty());
                test.href("testHref");
                Assert.assertEquals("testHref", test.getAttributes().get("href"));
                i++;
            }
        }
        Assert.assertEquals(108, i);
    }

    @Test
    public void viewContainerHtmlViews_markupElementIsCreatedCorrectly() throws InvocationTargetException, IllegalAccessException {
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
                Assert.assertEquals(method.getName(), testWithInner.getTag());
                Assert.assertEquals(2, testWithInner.getInnerViews().length);
                Assert.assertNull(testWithInner.getInnerText());
                Assert.assertTrue(testWithInner.getAttributes().isEmpty());
                testWithInner.href("testHref");
                Assert.assertEquals("testHref", testWithInner.getAttributes().get("href"));
                i++;
            }
        }
        Assert.assertEquals(108, i);
    }

    @Test
    public void emptyHtmlViews_markupElementIsCreatedCorrectly() throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        for (Method method : WebViewFactory.class.getMethods()) {
            if (method.getReturnType().equals(EmptyHtmlView.class)) {
                EmptyHtmlView test = (EmptyHtmlView) method.invoke(null);
                Assert.assertEquals(method.getName(), test.getTag());
                Assert.assertTrue(test.getAttributes().isEmpty());
                test.href("testHref");
                Assert.assertEquals("testHref", test.getAttributes().get("href"));
                i++;
            }
        }
        Assert.assertEquals(14, i);
    }

    @Test
    public void htmlViews_htmlAttributesAreAddedCorrectly() throws InvocationTargetException, IllegalAccessException {
        MarkupView test = WebViewFactory.p("test");
        int i = 0;
        for (Method method : HtmlView.class.getDeclaredMethods()) {
            test = (MarkupView) method.invoke(test, "testValue");
            String name = method.getName();
            String methodName = name.charAt(name.length() - 1) == '_' ?
                name.replace("_", "") :
                name.replace("_", "-");
            Assert.assertEquals("testValue", test.getAttributes().get(methodName));
            i++;
        }
        Assert.assertEquals(115, i);
    }

}
