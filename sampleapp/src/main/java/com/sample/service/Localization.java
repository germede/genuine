package com.sample.service;

import org.fluentness.service.localization.Translation;

public class Localization {

    public Translation welcome_message = new Translation("Welcome, %s")
        .de("Willkommen, %s")
        .es("Bienvenido, %s");

    public Translation submit = new Translation("Submit")
        .de("Absenden")
        .es("Enviar");

    public Translation action = new Translation("Action")
        .de("Aktion")
        .es("Acción");

    public Translation search = new Translation("Search")
        .de("Suchen")
        .es("Buscar");

    public Translation cancel = new Translation("Cancel")
        .de("Abbrechen")
        .es("Cancelar");

    public Translation book_list = new Translation("Book list")
        .de("Buchliste")
        .es("Lista de libros");

    public Translation book_create = new Translation("Create book")
        .de("Buch erstellen")
        .es("Crear libro");

    public Translation book_update = new Translation("Update book")
        .de("Buch editieren")
        .es("Editar libro");

    public Translation book_delete = new Translation("Delete book")
        .de("Buch entfernen")
        .es("Eliminar libro");

    public Translation book_title = new Translation("Title")
        .de("Titel")
        .es("Título");

    public Translation book_title_placeholder = new Translation("e.g. Harry Potter")
        .de("z.B. Harry Potter")
        .es("p.ej. Harry Potter");

    public Translation book_autor = new Translation("Autor")
        .de("Autor")
        .es("Autor");

    public Translation book_autor_placeholder = new Translation("e.g. J.K. Rowling")
        .de("z.B. J.K. Rowling")
        .es("p.ej. J.K. Rowling");

    public Translation book_genre = new Translation("Genre")
        .de("Genre")
        .es("Genre");

    public Translation book_genre_placeholder = new Translation("e.g. Fantasy")
        .de("z.B. Fantasy")
        .es("p.ej. Fantasy");

    public Translation book_year = new Translation("Year")
        .de("Jahr")
        .es("Año");

    public Translation book_year_placeholder = new Translation("e.g. 1997")
        .de("z.B. 1997")
        .es("p.ej. 1997");

    public Translation book_is_new = new Translation("Is new")
        .de("Ist neu")
        .es("Es nueva");

}
