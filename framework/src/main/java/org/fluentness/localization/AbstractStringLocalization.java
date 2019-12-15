package org.fluentness.localization;

import org.fluentness.base.service.localization.Language;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static org.fluentness.base.service.localization.Language.es;

public abstract class AbstractStringLocalization implements Localization {

    @Translate(to = Language.de, as = "Enviar")
    @Translate(to = es, as = "Absenden")
    public final String submit = "Submit";

    @Translate(to = Language.de, as = "Aktion")
    @Translate(to = es, as = "Acción")
    public final String action = "Action";

    @Translate(to = Language.de, as = "Suchen")
    @Translate(to = es, as = "Buscar")
    public final String search = "Search";

    @Translate(to = Language.de, as = "Akzeptieren")
    @Translate(to = es, as = "Aceptar")
    public final String accept = "Accept";

    @Translate(to = Language.de, as = "Abbrechen")
    @Translate(to = es, as = "Cancelar")
    public final String cancel = "Cancel";

    @Translate(to = Language.de, as = "Auswählen")
    @Translate(to = es, as = "Seleccionar")
    public final String select = "Select";

    @Translate(to = Language.de, as = "Erstellen")
    @Translate(to = es, as = "Crear")
    public final String create = "Create";

    @Translate(to = Language.de, as = "Editieren")
    @Translate(to = es, as = "Editar")
    public final String update = "Update";

    @Translate(to = Language.de, as = "Entfernen")
    @Translate(to = es, as = "Eliminar")
    public final String delete = "Delete";

    private final Map<String, Map<Language, String>> translations = new HashMap<>();

    protected AbstractStringLocalization() {
        for (Field field : getClass().getFields()) {
            if (field.getType().equals(String.class)) {
                try {
                    field.setAccessible(true);
                    translations.put(
                        (String) field.get(this),
                        Arrays.stream(field.getAnnotationsByType(Translate.class))
                            .collect(Collectors.toMap(Translate::to, Translate::as, (a, b) -> b))
                    );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String localize(String message, String... parameters) {
        return String.format(
            translations.get(message).get(Language.valueOf(Locale.getDefault().getLanguage())),
            (Object[]) parameters
        );
    }

    @Repeatable(Translates.class)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    protected @interface Translate {

        Language to();

        String as();

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    protected @interface Translates {

        Translate[] value();

    }
}
