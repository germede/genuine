package org.fluentness.controller.web.template.html;

import org.fluentness.Fluentness;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.service.translator.Translator;

import java.util.stream.IntStream;

import static org.fluentness.controller.web.template.html.HtmlAttribute.*;

public abstract class Html implements WebTemplate {

    protected final String tag;
    protected final StringBuilder attributes;
    protected final StringBuilder inner;

    public Html(String tag, CharSequence[] html) {
        this.tag = tag;
        attributes = new StringBuilder();
        inner = new StringBuilder();

        Translator translator = Fluentness.getInstance(Translator.class);
        String[] languages = AbstractWebController.request.get().getLanguages();

        for (CharSequence item : html) {
            String render = item.toString();
            if (render.startsWith(HtmlAttribute.SEPARATOR)) {
                // if attribute
                render = render.substring(SEPARATOR.length());
                String[] split = render.split(SEPARATOR);
                String key = split[0];
                String value = split.length == 2 ? translator.translate(split[1], languages) : "";
                if (key.equals("id")) {
                    handleIdAttribute(value);
                }
                attributes.append(' ').append(key).append("=\"").append(value).append("\"");
            } else {
                // if inner html, do translation
                inner.append(translator.translate(render, languages));
            }
        }
    }

    private void handleIdAttribute(String value) {
        if (AbstractWebController.methodPathMap.containsKey(value)) {
            String path = AbstractWebController.methodPathMap.get(value);
            attributes.append(" href=\"").append(path).append("\"");
            if (AbstractWebController.request.get().getUri().toString().startsWith(path)) {
                attributes.append(" data=\"").append("current").append("\"");
            }
        }
    }

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

}
