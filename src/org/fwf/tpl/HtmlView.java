package org.fwf.tpl;

import org.fwf.mvc.View;

public class HtmlView extends View {

    private StringBuilder html;

    public HtmlView() {
        html = new StringBuilder();
    }

    private HtmlView append(String toAppend) {
        html.append(toAppend);
        return this;
    }

    public HtmlView open(String tag) {
        append("<").append(tag).append(">");
        return this;
    }

    public HtmlView close(String tag) {
        append("</").append(tag).append(">");
        return this;
    }

    public HtmlView raw(String raw) {
        append(raw);
        return this;
    }

    public HtmlView insert() {
        return append("INSERT");
    }

    @Override
    public String render() {
        return html.toString();
    }
}
