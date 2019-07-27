package com.sample.data;

import org.fluentness.data.repository.Repository;

import java.util.List;

public class SongRepository implements Repository<Song> {

    public List<Song> findByTitle(String title) {
        return null;
    }
}
