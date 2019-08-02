package com.sample.data;

import org.fluentness.base.service.persistence.Persistence;
import org.fluentness.data.repository.Repository;

import javax.persistence.Query;
import java.util.List;

public class SongRepository implements Repository<Song> {

    private Persistence persistenceService;

    public SongRepository(Persistence persistenceService) {
        this.persistenceService = persistenceService;
    }

    public void create(Song song) {
        persistenceService.create(song);
    }

    public void update(Song song) {
        persistenceService.update(song);
    }

    public void delete(Song song) {
        persistenceService.delete(song);
    }

    public Song findById(int id) {
        return persistenceService.findById(Song.class, id);
    }

    public List<Song> findAll() {
        return persistenceService.findAll(Song.class);
    }

    public List<Song> findByTitle(String title) {
        Query query = persistenceService.getEntityManager().createQuery("SELECT s FROM Song s WHERE s.title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }
}
