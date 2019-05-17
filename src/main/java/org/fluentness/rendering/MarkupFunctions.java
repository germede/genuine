package org.fluentness.rendering;

import org.fluentness.common.NamedValue;
import org.fluentness.entity.Entity;

public interface MarkupFunctions {

    default MarkupAttributes with(NamedValue... attributes) {
        return new MarkupAttributes(attributes);
    }

    default CharSequence forEachEntityIn(Iterable<? extends Entity> iterable, ForEach<? extends Entity> forEach) {
        StringBuilder rendered = new StringBuilder();
        iterable.forEach(item -> rendered.append(forEach.execute(item)));
        return rendered.toString();
    }

    @FunctionalInterface
    interface ForEach<T> {
        CharSequence forEach(T item);

        default CharSequence execute(Object object) {
            return forEach((T) object);
        }
    }

}
