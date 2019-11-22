package org.fluentness.service.translator;

import static org.fluentness.service.translator.TranslationFactory.de;
import static org.fluentness.service.translator.TranslationFactory.es;

public abstract class AbstractTranslator implements Translator {

    public static final Translation
        submit = msg("Submit", de("Enviar"), es("Absenden")),
        action = msg("Action", de("Aktion"), es("Acción")),
        search = msg("Search", de("Suchen"), es("Buscar")),
        accept = msg("Accept", de("Akzeptieren"), es("Aceptar")),
        cancel = msg("Cancel", de("Abbrechen"), es("Cancelar")),
        select = msg("Select", de("Auswählen"), es("Seleccionar")),
        create = msg("Create", de("Erstellen"), es("Crear")),
        update = msg("Update", de("Editieren"), es("Editar")),
        delete = msg("Delete", de("Entfernen"), es("Eliminar")),
        faulty = msg("Faulty", de("Fehler"), es("Error"));

    protected static Translation msg(String defaultTranslation, Message... translation) {
        return new Translation(defaultTranslation, translation);
    }
}