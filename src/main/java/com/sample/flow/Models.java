package com.sample.flow;

import org.fluentness.data.Model;
import org.fluentness.data.ModelProvider;

public class Models extends ModelProvider {

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
