package org.fluentness.service.persistence;

public class Query<M> {

    private final String query;

    public Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
