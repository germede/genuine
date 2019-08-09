package com.sample.data;

import org.fluentness.data.repository.Repository;

import java.util.List;

public class SongRepository implements Repository<Song> {

    @Override
    public Class<Song> getModelClass() {
        return Song.class;
    }

    private PersistenceService persistenceService;

    public SongRepository(PersistenceService persistenceService) {
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
        return persistenceService.findById(getModelClass(), id);
    }

    public List<Song> findAll() {
        return persistenceService.findAll(getModelClass());
    }

    public List<Song> findByTitle(String title) {
        return persistenceService.query("SELECT s FROM Song s WHERE s.title = :title")
                .setParameter("title", title)
                .getResultList();
    }
}
