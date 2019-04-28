package org.fluentness.templating;

import org.fluentness.ClassRegister;
import org.fluentness.Configuration;
import org.fluentness.localization.Translations;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlFlowFunctions {

    private String language = Configuration.getString(Configuration.APP_DEFAULT_LANGUAGE);

    public T setLanguage(String language) {
        this.language = language;
        return self();
    }

    public T close(String tag) {
        return (T) append("</").append(tag).append(">");
    }




    public Serializable iff(boolean condition, Then then) {
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

    public T forEach(Iterable<?> objects, ForEach<?> forEach) {
        objects.forEach((Consumer<? super Object>) object -> forEach.execute(object, this));
        return self();
    }

    // lambdas
    @FunctionalInterface
    public interface Then {

        void then(ControlFlowFunctions then);

    }
    @FunctionalInterface
    public interface Otherwise {

        void otherwise(ControlFlowFunctions otherwise);

    }
    @FunctionalInterface
    public interface ForEach<S> {
        void forEach(S object, ControlFlowFunctions renderable);
        default void execute(Object object, ControlFlowFunctions renderable) {
            forEach((S) object, renderable);
        }
    }
}
