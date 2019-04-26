package org.fluentness.view;

import org.fluentness.Configuration;
import org.fluentness.common.ClassRegister;
import org.fluentness.translation.Translations;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MarkupView<T extends MarkupView<?>> implements View {

    protected abstract T self();

    private String language = Configuration.get(Configuration.APP_DEFAULT_LANGUAGE);
    public T setLanguage(String language) {
        this.language = language;
        return self();
    }

    private StringBuilder document;

    public MarkupView() {
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

    public T append(String toAppend) {
        document.append(toAppend);
        return self();
    }

    public T include(View view) {
        return append(view.render());
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
        return (T) this;
    }

    // view interface methods
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

        void then(MarkupView then);
    }

    @FunctionalInterface
    public interface Otherwise {

        void otherwise(MarkupView otherwise);
    }

    @FunctionalInterface
    public interface ForEach<S> {
        void forEach(S object, MarkupView htmlView);

        default void execute(Object object, MarkupView htmlView) {
            forEach((S) object, htmlView);
        }
    }
}
