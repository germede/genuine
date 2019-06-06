package com.sample.localization;

import org.fluentness.localization.Localization;

import java.util.Locale;


public class DefaultLocalization implements Localization {

    @Override
    public Locale getLocale() {
        return Locale.getDefault();
    }

    @Override
    public Translations getTranslations() {
        return translations(
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
    }
}
