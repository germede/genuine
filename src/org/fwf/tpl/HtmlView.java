package org.fwf.tpl;

import org.fwf.mvc.View;

import java.util.function.Consumer;

public class HtmlView implements View {

    private StringBuilder html;

    public HtmlView() {
        html = new StringBuilder();
    }

    public HtmlView append(String toAppend) {
        html.append(toAppend);
        return this;
    }

    public HtmlView open(String tag, HtmlAttribute... attributes) {
        String toAppend = "";
        for (HtmlAttribute attribute : attributes) {
            toAppend = toAppend.concat(" ").concat(attribute.key).concat("=\"").concat(attribute.value).concat("\"");
        }
        return append("<").append(tag).append(" ").append(toAppend.trim()).append(">");
    }

    public HtmlView close(String tag) {
        return append("</").append(tag).append(">");
    }

    public HtmlView include(View view) {
        return append(view.render());
    }

    public HtmlView includeIf(boolean condition, View view) {
        if (condition) {
            return append(view.render());
        }
        return this;
    }

    public HtmlView includeIf(boolean condition, String raw) {
        if (condition) {
            return append(raw);
        }
        return this;
    }

    public HtmlView forEach(Iterable<?> objects, ForEach<?> forEachLambda) {
        objects.forEach((Consumer<? super Object>) object -> forEachLambda.execute(object,this));
        return this;
    }

    public HtmlView title(String title) {
        open(HtmlTag.title).append(title).close(HtmlTag.title);
        return this;
    }

    @Override
    public String render() {
        return html.toString();
    }

    @FunctionalInterface
    public interface ForEach<T> {
        void then(T object, HtmlView htmlView);

        default void execute(Object object, HtmlView htmlView) {
            then((T) object, htmlView);
        }
    }

}
