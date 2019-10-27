package com.sample.service;

import org.fluentness.service.localization.Language;
import org.fluentness.service.localization.BaseLocalizationService;

public class LocalizationService extends BaseLocalizationService {

    @Override
    protected void configure() {
        add("welcome_message").en("Welcome, %s").de("Willkommen, %s").es("Bienvenido, %s");
        add("submit").en("Submit").de("Submit").es("Enviar");
        add("action").en("Action").de("Aktion").es("Acción");
        add("search").en("Search").de("Suchen").es("Buscar");
        add("cancel").en("Cancel").de("Abbrechen").es("Cancelar");
        add("book_list").en("Book list").de("Buchliste").es("Lista de libros");
        add("book_create").en("Create book").de("Buch erstellen").es("Crear libro");
        add("book_update").en("Update book").de("Buch editieren").es("Editar libro");
        add("book_delete").en("Delete book").de("Buch entfernen").es("Eliminar libro");
        add("book_title").en("Title").de("Titel").es("Título");
        add("book_title_placeholder").en("e.g. Harry Potter").de("z.B. Harry Potter").es("p.ej. Harry Potter");
        add("book_autor").en("Autor").de("Autor").es("Autor");
        add("book_autor_placeholder").en("e.g. J.K. Rowling").de("z.B. J.K. Rowling").es("p.ej. J.K. Rowling");
        add("book_genre").en("Genre").de("Genre").es("Genre");
        add("book_genre_placeholder").en("e.g. Fantasy").de("z.B. Fantasy").es("p.ej. Fantasy");
        add("book_year").en("Year").de("Jahr").es("Año");
        add("book_year_placeholder").en("e.g. 1997").de("z.B. 1997").es("p.ej. 1997");
        add("book_is_new").en("Is new").de("Ist neu").es("Es nueva");
    }

    @Override
    public Language getDefaultLanguage() {
        return Language.EN;
    }

    @Override
    public Language getCurrentLanguage() {
        return Language.EN;
    }
}
