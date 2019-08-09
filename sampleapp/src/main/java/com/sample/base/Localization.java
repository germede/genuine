package com.sample.base;

import org.fluentness.base.provider.localization.Translate;

import static org.fluentness.base.provider.localization.Language.de;
import static org.fluentness.base.provider.localization.Language.es;

public class Localization implements Provider<String> {

    @Translate(to = es, as = "Bienvenido al sitio")
    @Translate(to = de, as = "Willkommen auf der Seite")
    public final String welcome_message = "Welcome to the site";

    @Translate(to = es, as = "Enviar")
    @Translate(to = de, as = "Submit")
    public final String submit = "Submit";

    @Translate(to = es, as = "Acción")
    @Translate(to = de, as = "Aktion")
    public final String action = "Action";

    @Translate(to = es, as = "Buscar")
    @Translate(to = de, as = "Suchen")
    public final String search = "Search";

    @Translate(to = es, as = "Cancelar")
    @Translate(to = de, as = "Abbrechen")
    public final String cancel = "Cancel";

    @Translate(to = es, as = "Lista de canciones")
    @Translate(to = de, as = "Songliste")
    public final String song_list = "Song list";

    @Translate(to = es, as = "Crear canción")
    @Translate(to = de, as = "Song erstellen")
    public final String song_create = "Create song";

    @Translate(to = es, as = "Editar canción")
    @Translate(to = de, as = "Song editieren")
    public final String song_update = "Update song";

    @Translate(to = es, as = "Eliminar canción")
    @Translate(to = de, as = "Song entfernen")
    public final String song_delete = "Delete song";

    @Translate(to = es, as = "Título")
    @Translate(to = de, as = "Titel")
    public final String song_title = "Title";

    @Translate(to = es, as = "p.ej. My hear will go on")
    @Translate(to = de, as = "z.B. My heart will go on")
    public final String song_title_placeholder = "e.g. My heart will go on";

    @Translate(to = es, as = "Artista")
    @Translate(to = de, as = "Künstler")
    public final String song_artist = "Artist";

    @Translate(to = es, as = "p.ej. Celine Dion")
    @Translate(to = de, as = "z.B. Celine Dion")
    public final String song_artist_placeholder = "e.g. Celine Dion";

    @Translate(to = es, as = "Álbum")
    @Translate(to = de, as = "Album")
    public final String song_album = "Album";

    @Translate(to = es, as = "p.ej. Let's talk about love")
    @Translate(to = de, as = "z.B. Let's talk about love")
    public final String song_album_placeholder = "e.g. Let's talk about love";

    @Translate(to = es, as = "Año")
    @Translate(to = de, as = "Jahr")
    public final String song_year = "Year";

    @Translate(to = es, as = "p.ej. 1997")
    @Translate(to = de, as = "z.B. 1997")
    public final String song_year_placeholder = "e.g. 1997";

    @Translate(to = es, as = "Es nueva")
    @Translate(to = de, as = "Ist neu")
    public final String song_is_new = "Is new";

}
