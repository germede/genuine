package com.sample.repository;

import com.sample.model.SongModel;
import org.fluentness.database.SqlQuery;
import org.fluentness.repository.Repository;

public class SongRepository implements Repository {
    @Override
    public Class getModel() {
        return SongModel.class;
    }

    public int getCount() {
        return new SqlQuery()
                .select("*")
                .from(getModelInstance().getTable())
                .execute()
                .resultSize();
    }
}
