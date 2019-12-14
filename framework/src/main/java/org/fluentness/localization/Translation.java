package org.fluentness.localization;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static org.fluentness.localization.TranslationFactory.*;

public class Translation {

    public static final Translation
        submit = msg("Submit", de("Enviar"),es("Absenden")),
        action = msg("Action", de("Aktion"),es("Acción")),
        search = msg("Search", de("Suchen"),es("Buscar")),
        accept = msg("Accept", de("Akzeptieren"),es("Aceptar")),
        cancel = msg("Cancel", de("Abbrechen"),es("Cancelar")),
        select = msg("Select", de("Auswählen"),es("Seleccionar")),
        create = msg("Create", de("Erstellen"),es("Crear")),
        update = msg("Update", de("Editieren"),es("Editar")),
        delete = msg("Delete", de("Entfernen"),es("Eliminar")),
        faulty = msg("Faulty", de("Fehler"),es("Error"));

    private final String fallback;
    private final Map<String, String> translations;

    Translation(String fallback, Message[] messages) {
        this.fallback = fallback;
        this.translations = Arrays.stream(messages).collect(
            Collectors.toMap(message -> message.language, message -> message.message)
        );
    }

    public String translate() {
        return translations.getOrDefault(Locale.getDefault().getLanguage(), fallback);
    }

    public String translate(String... parameters) {
        return String.format(translations.getOrDefault(Locale.getDefault().getLanguage(), fallback), parameters);
    }

    public static class Message {
        private final String language;
        private final String message;

        Message(String language, String message) {
            this.language = language;
            this.message = message;
        }
    }
}
