package org.fluentness.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface View extends CharSequence {

    @Override
    default int length() {
        return render().length();
    }

    @Override
    default char charAt(int i) {
        return render().charAt(i);
    }

    @Override
    default CharSequence subSequence(int i, int i1) {
        return render().subSequence(i, i1);
    }

    // rendering
    default String render() {
//        return ViewCacher.cache(getTemplate());
        return getTemplate().render();
    }

    // return parent view if present, otherwise return itself
    default View getTemplate() {
//        try {
//            if (this.getClass().getMethod("getView").isAnnotationPresent(Template.class)) {
//                View template = this.getClass().getMethod("getView").getAnnotation(Template.class).value().newInstance();
//                template.injectPlaceholder(this);
//                return template;
//            }
//        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
//            Logger.error(this.getClass(), e);
//        }
        return this;
    }

    default View injectAttribute(String name, Object value) {
//        try {
//            for (Field field : this.getClass().getDeclaredFields()) {
//                if (field.getName().equals(name) && field.isAnnotationPresent(Parameter.class)) {
//                    field.setAccessible(true);
//                    field.set(this, value);
//                    field.setAccessible(false);
//                }
//            }
//        } catch (IllegalAccessException e) {
//            Logger.error(this.getClass(), e);
//        }
        return this;
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Template {
        Class<? extends View> value();
    }
}
