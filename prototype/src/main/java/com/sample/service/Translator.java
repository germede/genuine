package com.sample.service;

import org.fluentness.service.translator.AbstractTranslator;

import static org.fluentness.service.translator.TranslationFactory.de;
import static org.fluentness.service.translator.TranslationFactory.es;

public class Translator extends AbstractTranslator {

    public static final String
        submit = "Submit" + de("Enviar") + es("Absenden"),
        search = "Search" + de("Suchen") + es("Buscar"),
        accept = "Accept" + de("Akzeptieren") + es("Aceptar"),
        cancel = "Cancel" + de("Abbrechen") + es("Cancelar"),
        select = "Select" + de("Auswählen") + es("Seleccionar"),
        create = "Create" + de("Erstellen") + es("Crear"),
        update = "Update" + de("Editieren") + es("Editar"),
        delete = "Delete" + de("Entfernen") + es("Eliminar"),

        welcome_message = "Welcome" + de("Willkommen") + es("Bienvenido"),
        page_not_found = "Page not found" + de("Seite nicht gefunden") + es("Página no encontrada"),
        server_error = "Server error" + de("Server-Fehler") + es("Error de servidor"),

        notes = "Notes" + de("Notizen") + es("Notas"),
        note_title = "Title" + de("Titel") + es("Título"),
        note_description = "Cover" + de("Deckblatt") + es("Portada"),

        authors = "Authors" + de("Autoren") + es("Autores"),
        author_name = "Name" + de("Vorname") + es("Nombre"),
        author_surname = "Surname" + de("Nachname") + es("Apellido(s)"),
        author_birthday = "Day of Birth" + de("Geburtsdatum") + es("Fecha de nacimiento"),
        author_picture = "Picture" + de("Bild") + es("Foto"),
        author_test = "Author test" + de("Bild") + es("Foto"),
        author_biography = "Biography" + de("Biografie") + es("Biografia"),

        users = "Users" + de("Benutzer") + es("Usuarios"),
        user_username = "Username" + de("Benutzername") + es("Nombre de usuario"),
        user_password = "Password" + de("Passwort") + es("Contraseña");

}
