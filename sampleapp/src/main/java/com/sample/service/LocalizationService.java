package com.sample.service;

import org.fluentness.service.localization.AbstractLocalizationService;
import org.fluentness.service.localization.Language;

public class LocalizationService extends AbstractLocalizationService {

//
//    @Translate(to = ES, as = "Bienvenido, %s")
//    @Translate(to = DE, as = "Willkommen, %s")
//    public String welcome_message = "Welcome, %s";
//
//    @Translate(to = ES, as = "Enviar")
//    @Translate(to = DE, as = "Submit")
//    public String submit = "Submit";
//
//    @Translate(to = ES, as = "Acción")
//    @Translate(to = DE, as = "Aktion")
//    public String action = "Action";
//
//    @Translate(to = ES, as = "Buscar")
//    @Translate(to = DE, as = "Suchen")
//    public String search = "Search";
//
//    @Translate(to = ES, as = "Cancelar")
//    @Translate(to = DE, as = "Abbrechen")
//    public String cancel = "Cancel";
//
//    @Translate(to = ES, as = "Lista de libros")
//    @Translate(to = DE, as = "Buchliste")
//    public String book_list = "Book list";
//
//    @Translate(to = ES, as = "Crear libro")
//    @Translate(to = DE, as = "Buch erstellen")
//    public String book_create = "Create book";
//
//    @Translate(to = ES, as = "Editar libro")
//    @Translate(to = DE, as = "Buch editieren")
//    public String book_update = "Update book";
//
//    @Translate(to = ES, as = "Eliminar libro")
//    @Translate(to = DE, as = "Buch entfernen")
//    public String book_delete = "Delete book";
//
//    @Translate(to = ES, as = "Título")
//    @Translate(to = DE, as = "Titel")
//    public String book_title = "Title";
//
//    @Translate(to = ES, as = "p.ej. Harry Potter")
//    @Translate(to = DE, as = "z.B. Harry Potter")
//    public String book_title_placeholder = "e.g. Harry Potter";
//
//    @Translate(to = ES, as = "Autor")
//    @Translate(to = DE, as = "Autor")
//    public String book_autor = "Autor";
//
//    @Translate(to = ES, as = "p.ej. J.K. Rowling")
//    @Translate(to = DE, as = "z.B. J.K. Rowling")
//    public String book_autor_placeholder = "e.g. J.K. Rowling";
//
//    @Translate(to = ES, as = "Genre")
//    @Translate(to = DE, as = "Genre")
//    public String book_genre = "Genre";
//
//    @Translate(to = ES, as = "p.ej. Fantasy")
//    @Translate(to = DE, as = "z.B. Fantasy")
//    public String book_genre_placeholder = "e.g. Fantasy";
//
//    @Translate(to = ES, as = "Año")
//    @Translate(to = DE, as = "Jahr")
//    public String book_year = "Year";
//
//    @Translate(to = ES, as = "p.ej. 1997")
//    @Translate(to = DE, as = "z.B. 1997")
//    public String book_year_placeholder = "e.g. 1997";
//
//    @Translate(to = ES, as = "Es nueva")
//    @Translate(to = DE, as = "Ist neu")
//    public String book_is_new = "Is new";


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
