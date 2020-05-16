package com.sample.service;

import org.fluentness.service.translator.AbstractStringTranslator;

public class StringTranslator extends AbstractStringTranslator {

    public static final String
        _submit = "Submit" + de("Absenden") + es("Enviar"),
        _search = "Search" + de("Suchen") + es("Buscar"),
        _accept = "Accept" + de("Akzeptieren") + es("Aceptar"),
        _cancel = "Cancel" + de("Abbrechen") + es("Cancelar"),
        _select = "Select" + de("Auswählen") + es("Seleccionar"),
        _create = "Create" + de("Erstellen") + es("Crear"),
        _update = "Update" + de("Editieren") + es("Editar"),
        _delete = "Delete" + de("Entfernen") + es("Eliminar"),

    _previous = "Previous" + de("Vorheriger") + es("Anterior"),
        _next = "Next" + de("Nächster") + es("Siguiente"),

    _welcome_message = "Welcome" + de("Willkommen") + es("Bienvenido"),
        _login = "Log in" + de("Anmelden") + es("Entrar"),
        _menu = "Menu" + de("Menü") + es("Menú"),
        _page_not_found = "Page not found" + de("Seite nicht gefunden") + es("Página no encontrada"),
        _server_error = "Server error" + de("Server-Fehler") + es("Error de servidor"),

    _files = "Files" + de("Dateien") + es("Archivos"),

    _email = "Email" + de("E-Mail") + es("E-mail"),

    _calendar = "Calendar" + de("Kalender") + es("Calendario"),

    _contacts = "Contacts" + de("Kontakte") + es("Contactos"),

    _tasks = "Tasks" + de("Aufgaben") + es("Tareas"),

    _notes = "Notes" + de("Notizen") + es("Notas"),
        _note_title = "Title" + de("Titel") + es("Título"),
        _note_description = "Description" + de("Beschreibung") + es("Descripción"),

    _bookmarks = "Bookmarks" + de("Lesezeichen") + es("Marcadores"),

    _passwords = "Passwords" + de("Passwörter") + es("Contraseñas"),

    _settings = "Settings" + de("Einstellungen") + es("Configuración"),
        _users = "Users" + de("Benutzer") + es("Usuarios"),
        _user_username = "Username" + de("Benutzername") + es("Nombre de usuario"),
        _user_password = "Password" + de("Passwort") + es("Contraseña");

}
