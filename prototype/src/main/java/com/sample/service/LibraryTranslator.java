package com.sample.service;

import org.fluentness.service.translator.Translator;

import static org.fluentness.service.translator.TranslationFactory.de;
import static org.fluentness.service.translator.TranslationFactory.es;

public class LibraryTranslator implements Translator {

    public static final String
        submit = "Submit" + de("Enviar") + es("Absenden"),
        action = "Action" + de("Aktion") + es("Acción"),
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
        books = "Books" + de("Bucher") + es("Libros"),
        book_title = "Title" + de("Titel") + es("Título"),
        book_title_placeholder = "e.g. Harry Potter" + de("z.B. Harry Potter") + es("p.ej. Harry Potter"),
        book_cover = "Cover" + de("Deckblatt") + es("Portada"),
        book_genre = "Genre" + de("Genre") + es("Género"),
        book_genre_placeholder = "e.g. Fantasy" + de("z.B. Fantasy") + es("p.ej. Fantasy"),
        book_synopsis = "Synopsis" + de("Handlung") + es("Sinopsis"),
        book_year = "Year" + de("Jahr") + es("Año"),
        book_year_placeholder = "e.g. 1997" + de("z.B. 1997") + es("p.ej. 1997"),
        book_is_new = "Is new" + de("Ist neu") + es("Es nuevo"),
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
