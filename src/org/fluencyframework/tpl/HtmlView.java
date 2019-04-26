package org.fluencyframework.tpl;

import org.fluencyframework.Configuration;
import org.fluencyframework.lan.Translations;
import org.fluencyframework.mvc.View;
import org.fluencyframework.net.Server;
import org.fluencyframework.oop.Register;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlView implements View {

    private StringBuilder html;
    private String language = Configuration.get(Configuration.APP_DEFAULT_LANGUAGE);

    public HtmlView() {
        html = new StringBuilder();
    }

    public HtmlView setLanguage(String language) {
        this.language = language;
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

    public HtmlView when(boolean condition, Then then) {
        if (condition) {
            then.then(this);
        }
        return this;
    }

    public HtmlView when(boolean condition, Then then, Otherwise otherwise) {
        if (condition) {
            then.then(this);
        } else {
            otherwise.otherwise(this);
        }
        return this;
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
        String result = html.toString();

        Translations translations = Register.getTranslations().get(language);
        if (translations != null && result.contains("###")) {
            Matcher matcher = Pattern.compile("###(\\w+)###").matcher(html);
            int lastMatchPos = 0;
            while (matcher.find()) {
                String key = matcher.group(1);
                if (translations.contains(key)) {
                    result = result.replace(matcher.group(0), translations.get(key));
                }
            }
        }

        return result;
    }

    @FunctionalInterface
    public interface ForEach<T> {
        void then(T object, HtmlView htmlView);

        default void execute(Object object, HtmlView htmlView) {
            then((T) object, htmlView);
        }
    }

    @FunctionalInterface
    public interface Then {
        void then(HtmlView then);
    }

    @FunctionalInterface
    public interface Otherwise {
        void otherwise(HtmlView otherwise);
    }
}
