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
        book_list = msg("Book list").de("Buchliste").es("Lista de libros"),
        book_create = msg("Create book").de("Buch erstellen").es("Crear libro"),
        book_update = msg("Update book").de("Buch editieren").es("Editar libro"),
        book_delete = msg("Delete book").de("Buch entfernen").es("Eliminar libro"),
        book_title = msg("Title").de("Titel").es("Título"),
        book_title_placeholder = msg("e.g. Harry Potter").de("z.B. Harry Potter").es("p.ej. Harry Potter"),
        book_author = msg("Author").de("Author").es("Autor"),
        book_author_placeholder = msg("e.g. J.K. Rowling").de("z.B. J.K. Rowling").es("p.ej. J.K. Rowling"),
        book_genre = msg("Genre").de("Genre").es("Género"),
        book_genre_placeholder = msg("e.g. Fantasy").de("z.B. Fantasy").es("p.ej. Fantasy"),
        book_year = msg("Year").de("Jahr").es("Año"),
        book_year_placeholder = msg("e.g. 1997").de("z.B. 1997").es("p.ej. 1997"),
        book_is_new = msg("Is new").de("Ist neu").es("Es nuevo");

}
