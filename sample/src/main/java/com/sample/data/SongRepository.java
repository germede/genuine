package com.sample.data;

import org.fluentness.data.repository.Repository;

import javax.persistence.Query;
import java.util.List;

public class SongRepository implements Repository<Song> {

    public List<Song> findByTitle(String title) {
        Query query = em().createQuery("SELECT s FROM Song s WHERE s.title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }
}
