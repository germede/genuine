package com.sample.base;

import org.fluentness.base.service.localization.AbstractLocalizationService;
import org.fluentness.base.service.localization.Translate;

import static org.fluentness.base.service.localization.Language.de;
import static org.fluentness.base.service.localization.Language.es;

public class LocalizationService extends AbstractLocalizationService {

    @Translate(to = es, as = "Bienvenido al sitio")
    @Translate(to = de, as = "Willkommen auf der Seite")
    public String welcome_message = "Welcome to the site";

    @Translate(to = es, as = "Enviar")
    @Translate(to = de, as = "Submit")
    public String submit = "Submit";

    @Translate(to = es, as = "Acción")
    @Translate(to = de, as = "Aktion")
    public String action = "Action";

    @Translate(to = es, as = "Buscar")
    @Translate(to = de, as = "Suchen")
    public String search = "Search";

    @Translate(to = es, as = "Cancelar")
    @Translate(to = de, as = "Abbrechen")
    public String cancel = "Cancel";

    @Translate(to = es, as = "Lista de canciones")
    @Translate(to = de, as = "Songliste")
    public String song_list = "Song list";

    @Translate(to = es, as = "Crear canción")
    @Translate(to = de, as = "Song erstellen")
    public String song_create = "Create song";

    @Translate(to = es, as = "Editar canción")
    @Translate(to = de, as = "Song editieren")
    public String song_update = "Update song";

    @Translate(to = es, as = "Eliminar canción")
    @Translate(to = de, as = "Song entfernen")
    public String song_delete = "Delete song";

    @Translate(to = es, as = "Título")
    @Translate(to = de, as = "Titel")
    public String song_title = "Title";

    @Translate(to = es, as = "p.ej. My hear will go on")
    @Translate(to = de, as = "z.B. My heart will go on")
    public String song_titleP_laceholder = "e.g. My heart will go on";

    @Translate(to = es, as = "Artista")
    @Translate(to = de, as = "Künstler")
    public String song_artist = "Artist";

    @Translate(to = es, as = "p.ej. Celine Dion")
    @Translate(to = de, as = "z.B. Celine Dion")
    public String song_artist_placeholder = "e.g. Celine Dion";

    @Translate(to = es, as = "Álbum")
    @Translate(to = de, as = "Album")
    public String song_album = "Album";

    @Translate(to = es, as = "p.ej. Let's talk about love")
    @Translate(to = de, as = "z.B. Let's talk about love")
    public String song_album_placeholder = "e.g. Let's talk about love";

    @Translate(to = es, as = "Año")
    @Translate(to = de, as = "Jahr")
    public String song_year = "Year";

    @Translate(to = es, as = "p.ej. 1997")
    @Translate(to = de, as = "z.B. 1997")
    public String song_year_placeholder = "e.g. 1997";

    @Translate(to = es, as = "Es nueva")
    @Translate(to = de, as = "Ist neu")
    public String song_is_new = "Is new";

}
