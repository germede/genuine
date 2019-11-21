package com.sample.service;

import org.fluentness.service.translation.AbstractTranslationService;
import org.fluentness.service.translation.Translation;

import static org.fluentness.service.translation.TranslationFactory.de;
import static org.fluentness.service.translation.TranslationFactory.es;


public class TranslationService extends AbstractTranslationService {

    public static final Translation
        welcome_message = msg("Welcome, %s", de("Willkommen, %s"), es("Bienvenido, %s")),
        page_not_found = msg("Page not found", de("Seite nicht gefunden"), es("Página no encontrada")),
        books = msg("Books", de("Bucher"), es("Libros")),
        book_title = msg("Title", de("Titel"), es("Título")),
        book_title_placeholder = msg("e.g. Harry Potter", de("z.B. Harry Potter"), es("p.ej. Harry Potter")),
        book_cover = msg("Cover", de("Deckblatt"), es("Portada")),
        book_genre = msg("Genre", de("Genre"), es("Género")),
        book_genre_placeholder = msg("e.g. Fantasy", de("z.B. Fantasy"), es("p.ej. Fantasy")),
        book_synopsis = msg("Synopsis", de("Handlung"), es("Sinopsis")),
        book_year = msg("Year", de("Jahr"), es("Año")),
        book_year_placeholder = msg("e.g. 1997", de("z.B. 1997"), es("p.ej. 1997")),
        book_is_new = msg("Is new", de("Ist neu"), es("Es nuevo")),
        authors = msg("Authors", de("Autoren"), es("Autores")),
        author_name = msg("Name", de("Vorname"), es("Nombre")),
        author_surname = msg("Surname", de("Nachname"), es("Apellido(s)")),
        author_birthday = msg("Day of Birth", de("Geburtsdatum"), es("Fecha de nacimiento")),
        author_picture = msg("Picture", de("Bild"), es("Foto")),
        author_biography = msg("Biography", de("Biografie"), es("Biografia")),
        users = msg("Users", de("Benutzer"), es("Usuarios")),
        user_username = msg("Username", de("Benutzername"), es("Nombre de usuario")),
        user_password = msg("Password", de("Passwort"), es("Contraseña"));

}
