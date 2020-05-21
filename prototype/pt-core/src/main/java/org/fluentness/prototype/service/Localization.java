package org.fluentness.prototype.service;

import org.fluentness.service.localization.AbstractLocalization;
import org.fluentness.service.localization.Translation;

public class Localization extends AbstractLocalization {

    public static final Translation
        _submit = msg("Submit", de("Absenden"), es("Enviar")),
        _search = msg("Search", de("Suchen"), es("Buscar")),
        _accept = msg("Accept", de("Akzeptieren"), es("Aceptar")),
        _cancel = msg("Cancel", de("Abbrechen"), es("Cancelar")),
        _select = msg("Select", de("Auswählen"), es("Seleccionar")),
        _create = msg("Create", de("Erstellen"), es("Crear")),
        _update = msg("Update", de("Editieren"), es("Editar")),
        _delete = msg("Delete", de("Entfernen"), es("Eliminar")),

    _previous = msg("Previous", de("Vorheriger"), es("Anterior")),
        _next = msg("Next", de("Nächster"), es("Siguiente")),

    _welcome_message = msg("Welcome", de("Willkommen"), es("Bienvenido")),
        _login = msg("Log in", de("Anmelden"), es("Entrar")),
        _menu = msg("Menu", de("Menü"), es("Menú")),

    _page_not_found = msg("Page not found", de("Seite nicht gefunden"), es("Página no encontrada")),
        _server_error = msg("Server error", de("Server-Fehler"), es("Error de servidor")),

    _files = msg("Files", de("Dateien"), es("Archivos")),

    _email = msg("Email", de("E-Mail"), es("E-mail")),

    _calendar = msg("Calendar", de("Kalender"), es("Calendario")),

    _contacts = msg("Contacts", de("Kontakte"), es("Contactos")),

    _tasks = msg("Tasks", de("Aufgaben"), es("Tareas")),

    _notes = msg("Notes", de("Notizen"), es("Notas")),
        _note_title = msg("Title", de("Titel"), es("Título")),
        _note_description = msg("Description", de("Beschreibung"), es("Descripción")),

    _bookmarks = msg("Bookmarks", de("Lesezeichen"), es("Marcadores")),

    _passwords = msg("Passwords", de("Passwörter"), es("Contraseñas")),

    _settings = msg("Settings", de("Einstellungen"), es("Configuración")),

    _users = msg("Users", de("Benutzer"), es("Usuarios")),
        _user_username = msg("Username", de("Benutzername"), es("Nombre de usuario")),
        _user_password = msg("Password", de("Passwort"), es("Contraseña"));

}
