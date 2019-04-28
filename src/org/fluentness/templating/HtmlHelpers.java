package org.fluentness.templating;

import java.io.Serializable;

public class HtmlHelpers extends ControlFlowFunctions {

    private HtmlHelpers() {
    }


    //Special tags
//    public static ContainerTag customElement(String tagName) {
//        return new ContainerTag(tagName);
//    }
//
//    public static EmptyTag emptyTag(String tagName) {
//        return new EmptyTag(tagName);
//    }
//
//    public static Text fileAsEscapedString(String path) {
//        return innerText(InlineStaticResource.getFileAsString(path));
//    }
//
//    public static UnescapedText fileAsString(String path) {
//        return rawHtml(InlineStaticResource.getFileAsString(path));
//    }
//
//    public static ContainerTag styleWithInlineFile(String path) {
//        return InlineStaticResource.get(path, InlineStaticResource.TargetFormat.CSS);
//    }
//
//    public static ContainerTag scriptWithInlineFile(String path) {
//        return InlineStaticResource.get(path, InlineStaticResource.TargetFormat.JS);
//    }
//
//    public static ContainerTag styleWithInlineFile_min(String path) {
//        return InlineStaticResource.get(path, InlineStaticResource.TargetFormat.CSS_MIN);
//    }
//
//    public static ContainerTag scriptWithInlineFile_min(String path) {
//        return InlineStaticResource.get(path, InlineStaticResource.TargetFormat.JS_MIN);
//    }

    public static Serializable comment(String comment) {
        return new DomInner("<!--" + comment + "-->");
    }

    public static Serializable doctype() {
        return new DomInner("<!DOCTYPE html>");
    }


    public static Serializable inner(String text) {
        return new DomInner(text);
    }

}

