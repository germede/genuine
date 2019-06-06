package com.sample.localization;

import org.fluentness.localization.Localization;

import java.util.Locale;


public class DeLocalization implements Localization {

    @Override
    public Locale getLocale() {
        return new Locale("DE");
    }

    @Override
    public Translations getTranslations() {
        return translations(
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

}
