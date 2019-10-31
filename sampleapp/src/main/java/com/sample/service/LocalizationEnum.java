package com.sample.service;

import static org.fluentness.service.localization.Language.DE;
import static org.fluentness.service.localization.Language.ES;

public enum LocalizationEnum {

    WELCOME_MESSAGE("Welcome, %s", DE + "Willkommen, %s", ES + "Bienvenido, %s"),
    SUBMIT("Submit", DE + "Absenden", ES + "Enviar"),
    ACTION("Action", DE + "Aktion", ES + "Acción"),
    SEARCH("Search", DE + "Suchen", ES + "Buscar"),
    CANCEL("Cancel", DE + "Abbrechen", ES + "Cancelar"),
    BOOK_LIST("Book list", DE + "Buchliste", ES + "Lista de libros"),
    BOOK_CREATE("Create book", DE + "Buch erstellen", ES + "Crear libro"),
    BOOK_UPDATE("Update book", DE + "Buch editieren", ES + "Editar libro"),
    BOOK_DELETE("Delete book", DE + "Buch entfernen", ES + "Eliminar libro"),
    BOOK_TITLE("Title", DE + "Titel", ES + "Título"),
    BOOK_TITLE_PLACEHOLDER("e.g. Harry Potter", DE + "z.B. Harry Potter", ES + "p.ej. Harry Potter"),
    BOOK_AUTHOR("Author", DE + "Autor", ES + "Autor"),
    BOOK_AUTHOR_PLACEHOLDER("e.g. J.K. Rowling", DE + "z.B. J.K. Rowling", ES + "p.ej. J.K. Rowling"),
    BOOK_GENRE("Genre", DE + "Genre", ES + "Genre"),
    BOOK_GENRE_PLACEHOLDER("e.g. Fantasy", DE + "z.B. Fantasy", ES + "p.ej. Fantasy"),
    BOOK_YEAR("Year", DE + "Jahr", ES + "Año"),
    BOOK_YEAR_PLACEHOLDER("e.g. 1997", DE + "z.B. 1997", ES + "p.ej. 1997"),
    BOOK_IS_NEW("Is new", DE + "Ist neu", ES + "Es nueva"),
    TEST_PHRASE(
        "The quick brown fox jumps over the lazy dog",
        DE + "Sylvia wagt quick den Jux bei Pforzheim.",
        ES + "El veloz murciélago hindú comía feliz cardillo y kiwi."
    );

    LocalizationEnum(String... message) {
        map(message);
    }
}
