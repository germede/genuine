package org.fwf.tpl;

import org.fwf.mvc.View;
import org.fwf.net.Server;

import java.util.function.Consumer;

public class HtmlView implements View {

    private StringBuilder html;

    public HtmlView() {
        html = new StringBuilder();
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

    public HtmlView append(String toAppend) {
        html.append(toAppend);
        return this;
    }

    public HtmlView appendIf(boolean condition, String toAppend) {
        if (condition) {
            return append(toAppend);
        }
        return this;
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

    public HtmlView includeCss(String path) {
        return open(HtmlTag.link,
                new HtmlAttribute("rel", "stylesheet"),
                new HtmlAttribute("type", "text/css"),
                new HtmlAttribute("href", Server.getBaseAddress().concat("/res/").concat(path))
        );
    }

    public HtmlView includeJs(String path) {
        return open(HtmlTag.script,
                new HtmlAttribute("src", Server.getBaseAddress().concat("/res/").concat(path))
        ).close(HtmlTag.script);
    }

    public HtmlView forEach(Iterable<?> objects, ForEach<?> forEachLambda) {
        objects.forEach((Consumer<? super Object>) object -> forEachLambda.execute(object, this));
        return this;
    }

    public HtmlView title(String title) {
        return open(HtmlTag.title).append(title).close(HtmlTag.title);
    }

    public HtmlView meta(HtmlAttribute... attributes) {
        return open(HtmlTag.meta, attributes);
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
