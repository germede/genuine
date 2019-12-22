package com.sample.service;

import org.fluentness.service.localization.AbstractStringLocalization;

import static org.fluentness.base.service.localization.Language.de;
import static org.fluentness.base.service.localization.Language.es;

public class LibraryLocalization extends AbstractStringLocalization {

    @Translate(to = de, as ="Willkommen, %s")
    @Translate(to = es, as ="Bienvenido, %s")
    public final String welcome_message = "Welcome, %s";

    @Translate(to = de, as ="Seite nicht gefunden")
    @Translate(to = es, as ="Página no encontrada")
    public final String page_not_found = "Page not found";

    @Translate(to = de, as ="Server-Fehler")
    @Translate(to = es, as ="Error de servidor")
    public final String server_error = "Server error";

    @Translate(to = de, as ="Bucher")
    @Translate(to = es, as ="Libros")
    public final String books = "Books";

    @Translate(to = de, as ="Titel")
    @Translate(to = es, as ="Título")
    public final String book_title = "Title";

    @Translate(to = de, as ="z.B. Harry Potter")
    @Translate(to = es, as ="p.ej. Harry Potter")
    public final String book_title_placeholder = "e.g. Harry Potter";

    @Translate(to = de, as ="Deckblatt")
    @Translate(to = es, as ="Portada")
    public final String book_cover = "Cover";

    @Translate(to = de, as ="Genre")
    @Translate(to = es, as ="Género")
    public final String book_genre = "Genre";

    @Translate(to = de, as ="z.B. Fantasy")
    @Translate(to = es, as ="p.ej. Fantasy")
    public final String book_genre_placeholder = "e.g. Fantasy";

    @Translate(to = de, as ="Handlung")
    @Translate(to = es, as ="Sinopsis")
    public final String book_synopsis = "Synopsis";

    @Translate(to = de, as ="Jahr")
    @Translate(to = es, as ="Año")
    public final String book_year = "Year";

    @Translate(to = de, as ="z.B. 1997")
    @Translate(to = es, as ="p.ej. 1997")
    public final String book_year_placeholder = "e.g. 1997";

    @Translate(to = de, as ="Ist neu")
    @Translate(to = es, as ="Es nuevo")
    public final String book_is_new = "Is new";

    @Translate(to = de, as ="Autoren")
    @Translate(to = es, as ="Autores")
    public final String authors = "Authors";

    @Translate(to = de, as ="Vorname")
    @Translate(to = es, as ="Nombre")
    public final String author_name = "Name";

    @Translate(to = de, as ="Nachname")
    @Translate(to = es, as ="Apellido(s)")
    public final String author_surname = "Surname";

    @Translate(to = de, as ="Geburtsdatum")
    @Translate(to = es, as ="Fecha de nacimiento")
    public final String author_birthday = "Day of Birth";

    @Translate(to = de, as ="Bild")
    @Translate(to = es, as ="Foto")
    public final String author_picture = "Picture";

    @Translate(to = de, as ="Biografie")
    @Translate(to = es, as ="Biografia")
    public final String author_biography = "Biography";

    @Translate(to = de, as ="Benutzer")
    @Translate(to = es, as ="Usuarios")
    public final String users = "Users";

    @Translate(to = de, as ="Benutzername")
    @Translate(to = es, as ="Nombre de usuario")
    public final String user_username = "Username";

    @Translate(to = de, as ="Passwort")
    @Translate(to = es, as ="Contraseña")
    public final String user_password = "Password";

}
