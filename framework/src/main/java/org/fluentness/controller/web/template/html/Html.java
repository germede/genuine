package org.fluentness.controller.web.template.html;

import org.fluentness.Fluentness;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.service.translator.Translator;

import java.util.stream.IntStream;

import static org.fluentness.controller.web.template.html.HtmlAttribute.*;

public class Html implements WebTemplate {

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }

    @Override
    public IntStream chars() {
        return null;
    }

    @Override
    public IntStream codePoints() {
        return null;
    }


    protected final String tag;
    protected CharSequence[] html;

    public Html(String tag, CharSequence[] html) {
        this.tag = tag;
        this.html = html;
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        StringBuilder inner = new StringBuilder();
        for (CharSequence item : html) {
            String render = item.toString();
            if (render.startsWith(HtmlAttribute.ATTR)) {
                // if attribute, check for actions
                handleIdAttribute(attributes, render);
                attributes.append(render.replace(ATTR, " ")).append("\"");
            } else {
                // if inner html, do translation
                inner.append(Fluentness.getInstance(Translator.class)
                    .translate(render, AbstractWebController.request.get().getLanguages()));
            }
        }
        return "<" + tag + attributes + ">" + inner + "</" + tag + ">";
    }

    private void handleIdAttribute(StringBuilder attributes, String render) {
        if (render.startsWith(ID.toString())) {
            String id = render.substring(render.indexOf("=\"") + 2);
            if (AbstractWebController.methodPathMap.containsKey(id)) {
                String path = AbstractWebController.methodPathMap.get(id);
                attributes.append(" href=\"").append(path).append("\"");
                if (AbstractWebController.request.get().getUri().toString().startsWith(path)) {
                    attributes.append(" data=\"").append("current").append("\"");
                }
            }
        }
    }
}
