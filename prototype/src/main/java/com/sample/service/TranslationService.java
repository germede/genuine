package com.sample.service;

import org.fluentness.service.translation.AbstractTranslationService;
import org.fluentness.service.translation.Translation;

public class TranslationService extends AbstractTranslationService {

    public static final Translation
        welcome_message = msg("Welcome, %s").de("Willkommen, %s").es("Bienvenido, %s"),
        submit = msg("Submit").de("Enviar").es("Absenden"),
        action = msg("Action").de("Aktion").es("Acción"),
        search = msg("Search").de("Suchen").es("Buscar"),
        cancel = msg("Cancel").de("Abbrechen").es("Cancelar"),
        create = msg("Create").de("Erstellen").es("Crear"),
        update = msg("Update").de("Editieren").es("Editar"),
        delete = msg("Delete").de("Entfernen").es("Eliminar"),
        books = msg("Books").de("Bucher").es("Libros"),
        book_title = msg("Title").de("Titel").es("Título"),
        book_title_placeholder = msg("e.g. Harry Potter").de("z.B. Harry Potter").es("p.ej. Harry Potter"),
        book_author = msg("Author").de("Author").es("Autor"),
        book_author_placeholder = msg("e.g. J.K. Rowling").de("z.B. J.K. Rowling").es("p.ej. J.K. Rowling"),
        book_genre = msg("Genre").de("Genre").es("Género"),
        book_genre_placeholder = msg("e.g. Fantasy").de("z.B. Fantasy").es("p.ej. Fantasy"),
        book_year = msg("Year").de("Jahr").es("Año"),
        book_year_placeholder = msg("e.g. 1997").de("z.B. 1997").es("p.ej. 1997"),
        book_cover = msg("Cover").de("Deckblatt").es("Portada"),
        book_is_new = msg("Is new").de("Ist neu").es("Es nuevo"),
        authors = msg("Authors").de("Autoren").es("Autores"),
        author_name = msg("Name").de("Name").es("Nombre"),
        author_biography = msg("Biography").de("Biografie").es("Biografia"),
        users = msg("Users").de("Benutzer").es("Usuarios"),
        user_username = msg("Username").de("Benutzername").es("Nombre de usuario"),
        user_password = msg("Password").de("Passwort").es("Contraseña");

}
