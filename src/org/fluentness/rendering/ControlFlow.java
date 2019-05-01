package org.fluentness.rendering;

public interface ControlFlow {
//    @Override
//    public String render() {
//
//         translate
//        Translations translations = ClassRegister.getTranslations().get(language);
//        if (translations != null) {
//            Matcher matcher = Pattern.compile("###(\\w+)###").matcher(document);
//            while (matcher.find()) {
//                String key = matcher.group(1);
//                if (translations.contains(key)) {
//                    document.replace(matcher.start(),matcher.end(),translations.get(key));
//                }
//            }
//        }
//        return document.toString();
//    }
//    private String language = Configuration.getString(Configuration.APP_DEFAULT_LANGUAGE);
//
//    public T setLanguage(String language) {
//        this.language = language;
//        return self();
//    }
//
//    public T close(String tag) {
//        return (T) append("</").append(tag).append(">");
//    }
//
//html(
//
//
//)
//
//    new Html()
//        .ol()
//

    default CharSequence when(boolean condition, CharSequence... then) {
        if (condition) {
            return new DomContent(then);
        }
        return "";
    }


//
//    public T when(boolean condition, Then then, Otherwise otherwise) {
//        if (condition) {
//            then.then(this);
//        } else {
//            otherwise.otherwise(this);
//        }
//        return self();
//    }
//
//    public T forEach(Iterable<?> objects, ForEach<?> forEach) {
//        objects.forEach((Consumer<? super Object>) object -> forEach.execute(object, this));
//        return self();
//    }
//
//    // lambdas



//    @FunctionalInterface
//    public interface Otherwise {
//
//        void otherwise(ControlFlowFunctions otherwise);
//
//    }
//    @FunctionalInterface
//    public interface ForEach<S> {
//        void forEach(S object, ControlFlowFunctions renderable);
//        default void execute(Object object, ControlFlowFunctions renderable) {
//            forEach((S) object, renderable);
//        }
//    }
}
