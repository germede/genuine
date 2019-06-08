package com.sample;

import org.fluentness.model.Model;
import org.fluentness.model.ModelProvider;

public class Models implements ModelProvider {

    Model song = properties(
        id -> id(),
        title -> string(),
        artist -> string(),
        album -> string().nullable(),
        year -> integer(),
        is_new -> bool()
    );
//        .repository(
//        return new SqlQuery()
//            .select("*")
//            .from(getModelInstance().getTable())
//        .where(
//                new SqlConstraint("title").like(title)
//            )
//                .execute()
//            .entityList(getModelClass());
//    );
}
