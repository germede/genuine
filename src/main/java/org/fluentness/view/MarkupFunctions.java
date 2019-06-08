package org.fluentness.view;

import org.fluentness.common.namedValues.NamedValue;

public interface MarkupFunctions {

    default MarkupAttributes with(NamedValue... attributes) {
        return new MarkupAttributes(attributes);
    }

//    default CharSequence forEachEntityIn(Iterable<? extends Entity> iterable, ForEach<? extends Entity> forEach) {
//        StringBuilder rendered = new StringBuilder();
//        iterable.forEach(item -> rendered.append(forEach.execute(item).render()));
//        return rendered.toString();
//    }

    @FunctionalInterface
    interface ForEach<T> {
        View forEach(T item);

        default View execute(Object object) {
            return forEach((T) object);
        }
    }

}
