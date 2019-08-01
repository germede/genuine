package com.sample.data;

import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.persistence.Persistence;
import org.fluentness.data.repository.Repository;

import javax.persistence.Query;
import java.util.List;

public class SongRepository extends Repository<Song> {

    public SongRepository(Persistence persistence, Logger logger) {
        super(persistence, logger);
    }

    public List<Song> findByTitle(String title) {
        Query query = em().createQuery("SELECT s FROM Song s WHERE s.title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }
}
