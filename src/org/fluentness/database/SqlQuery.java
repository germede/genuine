package org.fluentness.database;

import java.util.ArrayList;
import java.util.List;

public class SqlQuery {

    private StringBuilder sql;
    private List<Object> parameters;

    public SqlQuery() {
        sql = new StringBuilder();
        parameters = new ArrayList<>();
    }

    private SqlQuery append(String toAppend) {
        sql.append(toAppend);
        return this;
    }

    public String toString() {
        return sql.toString();
    }

    public SqlQuery insert() {
        return append("INSERT");
    }

    public SqlQuery select() {
        return append("SELECT *");
    }

    public SqlQuery select(List<String> columns) {
        return append("SELECT ").append(String.join(", ", columns));
    }

    public SqlQuery update(String table) {
        return append("UPDATE ").append(table);
    }

    public SqlQuery delete() {
        return append("DELETE");
    }

    public SqlQuery into(String table, List<String> columns) {
        return append(" INTO ").append(table).append(" (").append(String.join(",", columns)).append(")");
    }

    public SqlQuery values(List<Object> values) {
        parameters.addAll(values);
        String placeholders = "?";
        for (int i = 1; i < values.size(); i++) {
            placeholders = placeholders.concat(", ?");
        }
        return append(" VALUES (").append(placeholders).append(")");
    }

    public SqlQuery from(String table) {
        return append(" FROM ").append(table);
    }

    public SqlQuery set(List<String> columns, List<Object> values) {
        if (columns.isEmpty() || values.isEmpty()) {
            return this;
        }
        parameters.addAll(values);
        String toAppend = columns.get(0) + " = ?";
        for (int i = 1; i < values.size(); i++) {
            toAppend = toAppend.concat(", ").concat(columns.get(i).concat(" = ?"));
        }
        return append(" SET ").append(toAppend);
    }

    public SqlQuery where(Constraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" WHERE ").append(constraint.toString());
    }

    public SqlQuery orderBy(List<String> columns) {
        if (columns.isEmpty()) {
            return this;
        }
        return append(" ORDER BY ").append(String.join(", ", columns));
    }

    public SqlQueryResult execute() {
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
