package org.fwf.dto;

import java.util.List;

public class Query {

    private StringBuilder sql;
    private List<Object> parameters;

    public Query() {
        sql = new StringBuilder();
    }

    public Query select() {
        sql.append("SELECT * ");
        return this;
    }

    public Query select(List<String> columns) {
        sql.append("SELECT ").append(String.join(",", columns)).append(" ");
        return this;
    }

    public Query from(String table) {
        sql.append("FROM ").append(table).append(" ");
        return this;
    }

    public Query insert() {
        sql.append("INSERT ");
        return this;
    }

    public Query into(String table, List<String> columns) {
        sql.append("INTO ").append(table).append(" (").append(String.join(",", columns)).append(") ");
        return this;
    }

    public Query values(List<Object> values) {
        parameters = values;
        String placeholders = "?";
        for (int i = 0; i < values.size() - 1; i++){
            placeholders = placeholders.concat(",?");
        }
        sql.append("VALUES (").append(placeholders).append(") ");
        return this;
    }

    public QueryResult execute() {
        return Database.execute(sql.toString(),parameters);
    }

}
