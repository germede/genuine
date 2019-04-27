package org.fluentness.templating;

import org.fluentness.Configuration;
import org.fluentness.ClassRegister;
import org.fluentness.localization.Translations;
import org.fluentness.view.View;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MarkupTemplate<T extends MarkupTemplate<?>> implements Template {

    private String language = Configuration.getString(Configuration.APP_DEFAULT_LANGUAGE);

    public T setLanguage(String language) {
        this.language = language;
        return self();
    }

    private StringBuilder document;

    public MarkupTemplate() {
        document = new StringBuilder();
    }

    public T open(String tag) {
        return (T) append("<").append(tag).append(">");
    }

    public T set(String key, String value) {
        document.replace(document.length() - 1, document.length(), " ");
        return (T) append(key).append("=\"").append(value).append("\">");
    }

    public T close(String tag) {
        return (T) append("</").append(tag).append(">");
    }

    public T comment(String comment) {
        return (T) append("<!--").append(comment).append("-->");
    }

    public T append(String toAppend) {
        document.append(toAppend);
        return self();
    }

    public T include(View view) {
        return append(view.renderTemplate());
    }

    public T when(boolean condition, Then then) {
        if (condition) {
            then.then(this);
        }
        return self();
    }

    public T when(boolean condition, Then then, Otherwise otherwise) {
        if (condition) {
            then.then(this);
        } else {
            otherwise.otherwise(this);
        }
        return self();
    }

    @SuppressWarnings("unchecked")
    public T forEach(Iterable<?> objects, ForEach<?> forEach) {
        objects.forEach((Consumer<? super Object>) object -> forEach.execute(object, this));
        return self();
    }

    // render
    @Override
    public String render() {

        // translate
        Translations translations = ClassRegister.getTranslations().get(language);
        if (translations != null) {
            Matcher matcher = Pattern.compile("###(\\w+)###").matcher(document);
            while (matcher.find()) {
                String key = matcher.group(1);
                if (translations.contains(key)) {
                    document.replace(matcher.start(),matcher.end(),translations.get(key));
                }
            }
        }
        return document.toString();
    }

    // lambdas
    @FunctionalInterface
    public interface Then {

        void then(MarkupTemplate then);

    }
    @FunctionalInterface
    public interface Otherwise {

        void otherwise(MarkupTemplate otherwise);

    }
    @FunctionalInterface
    public interface ForEach<S> {

        void forEach(S object, MarkupTemplate template);
        default void execute(Object object, MarkupTemplate template) {
            forEach((S) object, template);
        }

    }

    // necessary for fluent setter
    protected abstract T self();
}
