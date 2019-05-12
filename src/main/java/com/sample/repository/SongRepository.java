package com.sample.repository;

import com.sample.model.SongModel;
import org.fluentness.database.SqlConstraint;
import org.fluentness.database.SqlQuery;
import org.fluentness.entity.Entity;
import org.fluentness.repository.Repository;

import java.util.List;

public class SongRepository implements Repository {
    @Override
    public Class getModel() {
        return SongModel.class;
    }

    public List<Entity<SongModel>> findByTitle(String title) {
        return new SqlQuery()
                .select("*")
                .from(getModelInstance().getTable())
                .where(
                        new SqlConstraint("title").like(title)
                )
                .execute()
                .entityList(getModel());
    }
}
