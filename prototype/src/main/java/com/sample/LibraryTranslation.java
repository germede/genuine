package com.sample;

import org.fluentness.service.translator.Language;
import org.fluentness.service.translator.Translation;

public enum LibraryTranslation implements Translation {

    submit("Submit", "Enviar", "Absenden"),
    action("Action", "Aktion", "Acción"),
    search("Search", "Suchen", "Buscar"),
    accept("Accept", "Akzeptieren", "Aceptar"),
    cancel("Cancel", "Abbrechen", "Cancelar"),
    select("Select", "Auswählen", "Seleccionar"),
    create("Create", "Erstellen", "Crear"),
    update("Update", "Editieren", "Editar"),
    delete("Delete", "Entfernen", "Eliminar"),
    welcome_message("Welcome, %s", "Willkommen, %s", "Bienvenido, %s"),
    page_not_found("Page not found", "Seite nicht gefunden", "Página no encontrada"),
    server_error("Server error", "Server-Fehler", "Error de servidor"),
    books("Books", "Bucher", "Libros"),
    book_title("Title", "Titel", "Título"),
    book_title_placeholder("e.g. Harry Potter", "z.B. Harry Potter", "p.ej. Harry Potter"),
    book_cover("Cover", "Deckblatt", "Portada"),
    book_genre("Genre", "Genre", "Género"),
    book_genre_placeholder("e.g. Fantasy", "z.B. Fantasy", "p.ej. Fantasy"),
    book_synopsis("Synopsis", "Handlung", "Sinopsis"),
    book_year("Year", "Jahr", "Año"),
    book_year_placeholder("e.g. 1997", "z.B. 1997", "p.ej. 1997"),
    book_is_new("Is new", "Ist neu", "Es nuevo"),
    authors("Authors", "Autoren", "Autores"),
    author_name("Name", "Vorname", "Nombre"),
    author_surname("Surname", "Nachname", "Apellido(s)"),
    author_birthday("Day of Birth", "Geburtsdatum", "Fecha de nacimiento"),
    author_picture("Picture", "Bild", "Foto"),
    author_test("Author test", "Bild", "Foto"),
    author_biography("Biography", "Biografie", "Biografia"),
    users("Users", "Benutzer", "Usuarios"),
    user_username("Username", "Benutzername", "Nombre de usuario"),
    user_password("Password", "Passwort", "Contraseña");

    private final String en;
    private final String de;
    private final String es;

    LibraryTranslation(String en, String de, String es) {
        this.en = en;
        this.de = de;
        this.es = es;
    }

    @Override
    public String translate(Language language) {
        switch (language) {
            case DE: return de;
            case ES: return es;
            default: return en;
        }
    }
}
