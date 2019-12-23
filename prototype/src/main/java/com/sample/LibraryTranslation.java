package com.sample;

import org.fluentness.localization.Translation;

import static org.fluentness.localization.TranslationFactory.de;
import static org.fluentness.localization.TranslationFactory.es;

public final class LibraryTranslation {

    public static final Mytest asdf = () -> "test" -> "asdf";

    public static final Translation
        submit = msg("Submit", es("Absenden"), de("Enviar")),
        action = msg("Action", es("Acción"), de("Aktion")),
        search = msg("Search", es("Buscar"), de("Suchen")),
        accept = msg("Accept", es("Aceptar"), de("Akzeptieren")),
        cancel = msg("Cancel", es("Cancelar"), de("Abbrechen")),
        select = msg("Select", es("Seleccionar"), de("Auswählen")),
        create = msg("Create", es("Crear"), de("Erstellen")),
        update = msg("Update", es("Editar"), de("Editieren")),
        delete = msg("Delete", es("Eliminar"), de("Entfernen")),
        welcome_message = msg("Welcome, %s", es("Bienvenido, %s"), de("Willkommen, %s")),
        page_not_found = msg("Page not found", es("Página no encontrada"), de("Seite nicht gefunden")),
        server_error = msg("Server error", es("Error de servidor"), de("Server-Fehler")),
        books = msg("Books", es("Libros"), de("Bucher")),
        book_title = msg("Title", es("Título"), de("Titel")),
        book_title_placeholder = msg("e.g. Harry Potter", es("p.ej. Harry Potter"), de("z.B. Harry Potter")),
        book_cover = msg("Cover", es("Portada"), de("Deckblatt")),
        book_genre = msg("Genre", es("Género"), de("Genre")),
        book_genre_placeholder = msg("e.g. Fantasy", es("p.ej. Fantasy"), de("z.B. Fantasy")),
        book_synopsis = msg("Synopsis", es("Sinopsis"), de("Handlung")),
        book_year = msg("Year", es("Año"), de("Jahr")),
        book_year_placeholder = msg("e.g. 1997", es("p.ej. 1997"), de("z.B. 1997")),
        book_is_new = msg("Is new", es("Es nuevo"), de("Ist neu")),
        authors = msg("Authors", es("Autores"), de("Autoren")),
        author_name = msg("Name", es("Nombre"), de("Vorname")),
        author_surname = msg("Surname", es("Apellido(s)"), de("Nachname")),
        author_birthday = msg("Day of Birth", es("Fecha de nacimiento"), de("Geburtsdatum")),
        author_picture = msg("Picture", es("Foto"), de("Bild")),
        author_biography = msg("Biography", es("Biografia"), de("Biografie")),
        users = msg("Users", es("Usuarios"), de("Benutzer")),
        user_username = msg("Username", es("Nombre de usuario"), de("Benutzername")),
        user_password = msg("Password", es("Contraseña"), de("Passwort"));

}
