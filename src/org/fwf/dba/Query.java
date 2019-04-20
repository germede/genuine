package org.fwf.dba;

import java.util.ArrayList;
import java.util.List;

public class Query {

    private StringBuilder sql;
    private List<Object> parameters;

    public Query() {
        sql = new StringBuilder();
        parameters = new ArrayList<>();
    }

    private Query append(String toAppend) {
        sql.append(toAppend);
        return this;
    }

    public String toString() {
        return sql.toString();
    }

    public Query insert() {
        return append("INSERT");
    }

    public Query select() {
        return append("SELECT *");
    }

    public Query select(List<String> columns) {
        return append("SELECT ").append(String.join(", ", columns));
    }

    public Query update(String table) {
        return append("UPDATE ").append(table);
    }

    public Query delete() {
        return append("DELETE");
    }

    public Query into(String table, List<String> columns) {
        return append(" INTO ").append(table).append(" (").append(String.join(",", columns)).append(")");
    }

    public Query values(List<Object> values) {
        parameters.addAll(values);
        String placeholders = "?";
        for (int i = 1; i < values.size(); i++) {
            placeholders = placeholders.concat(", ?");
        }
        return append(" VALUES (").append(placeholders).append(")");
    }

    public Query from(String table) {
        return append(" FROM ").append(table);
    }

    public Query set(List<String> columns, List<Object> values) {
        parameters.addAll(values);
        String toAppend = columns.get(0) + " = ?";
        for (int i = 1; i < values.size(); i++) {
            toAppend = toAppend.concat(", ").concat(columns.get(i).concat(" = ?"));
        }
        return append(" SET ").append(toAppend);
    }

    public Query where(Constraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" WHERE ").append(constraint.toString());
    }

    public Query orderBy(List<String> columns) {
        return append(" ORDER BY ").append(String.join(", ", columns));
    }

    public QueryResult execute() {
        String query = toString();
        return Database.execute(query, parameters);
    }

    public static class ColumnsValuesPairs {
        private List<String> columns = new ArrayList<>();
        private List<Object> values = new ArrayList<>();

        public void add(String column, Object value) {
            columns.add(column);
            values.add(value);
        }

        public List<String> getColumns() {
            return columns;
        }

        public List<Object> getValues() {
            return values;
        }
    }
}
