package com.sample;

import org.fluentness.localization.Localization;
import org.fluentness.localization.LocalizationProvider;

public class Localizations implements LocalizationProvider {

    Localization en = translations(
        welcome_message -> "Welcome to the site",
        submit -> "Submit",
        action -> "Action",
        search -> "Search",
        cancel -> "Cancel",
        song_list -> "Song list",
        song_create -> "Create song",
        song_update -> "Update song",
        song_delete -> "Delete song",
        song_title -> "Title",
        song_title_placeholder -> "e.g. My heart will go on",
        song_artist -> "Artist",
        song_artist_placeholder -> "e.g. Celine Dion",
        song_album -> "Album",
        song_album_placeholder -> "e.g. Let's talk about love",
        song_year -> "Year",
        song_year_placeholder -> "e.g. 1997",
        song_is_new -> "Is new"
    );

    Localization de = translations(
        welcome_message -> "Willkommen auf der Seite",
        submit -> "Submit",
        action -> "Aktion",
        search -> "Suchen",
        cancel -> "Abbrechen",
        song_list -> "Songliste",
        song_create -> "Song erstellen",
        song_update -> "Song editieren",
        song_delete -> "Song entfernen",
        song_title -> "Titel",
        song_title_placeholder -> "z.B. My heart will go on",
        song_artist -> "Künstler",
        song_artist_placeholder -> "z.B. Celine Dion",
        song_album -> "Album",
        song_album_placeholder -> "z.B. Let's talk about love",
        song_year -> "Jahr",
        song_year_placeholder -> "z.B. 1997",
        song_is_new -> "Ist neu"
    );

}
