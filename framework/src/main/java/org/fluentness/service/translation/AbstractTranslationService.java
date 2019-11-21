package org.fluentness.service.translation;

import java.util.Locale;

public abstract class AbstractTranslationService implements TranslationService {

    public static Translation
        submit = msg("Submit").de("Enviar").es("Absenden"),
        action = msg("Action").de("Aktion").es("Acción"),
        search = msg("Search").de("Suchen").es("Buscar"),
        cancel = msg("Cancel").de("Abbrechen").es("Cancelar"),
        create = msg("Create").de("Erstellen").es("Crear"),
        update = msg("Update").de("Editieren").es("Editar"),
        delete = msg("Delete").de("Entfernen").es("Eliminar");

    @Override
    public String translate(Translation key, String... parameters) {
        return String.format(key.get(Locale.getDefault()), parameters);
    }

    protected static Translation msg(String defaultTranslation) {
        return new Translation(defaultTranslation);
    }

}