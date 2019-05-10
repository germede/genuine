package org.fluentness.database;

import org.fluentness.common.NamedValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public SqlQuery insert() {
        return append("INSERT");
    }

    public SqlQuery select() {
        return append("SELECT *");
    }

    public SqlQuery select(String[] columns) {
        return append("SELECT ").append(String.join(", ", columns));
    }

    public SqlQuery update(String table) {
        return append("UPDATE ").append(table);
    }

    public SqlQuery delete() {
        return append("DELETE");
    }

    public SqlQuery into(String table) {
        return append(" INTO ").append(table);
    }

    public SqlQuery values(NamedValue... namedValues) {
        append(" (");
        append(Arrays.stream(namedValues).map(NamedValue::name).collect(Collectors.joining(", ")));
        append(")");
        parameters.addAll(Arrays.stream(namedValues).map(NamedValue::value).collect(Collectors.toList()));
        String placeholders = "?";
        for (int i = 1; i < namedValues.length; i++) {
            placeholders = placeholders.concat(", ?");
        }
        return append(" VALUES (").append(placeholders).append(")");
    }

    public SqlQuery from(String table) {
        return append(" FROM ").append(table);
    }

    public SqlQuery set(NamedValue... namedValues) {
        parameters.addAll(Arrays.stream(namedValues).map(NamedValue::value).collect(Collectors.toList()));
        append(" SET ");
        append(Arrays.stream(namedValues).map(namedValue -> namedValue.name() + " = ?").collect(Collectors.joining(", ")));
        return this;
    }

    public SqlQuery where(SqlConstraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" WHERE ").append(constraint.toString());
    }

    public SqlQuery orderBy(List<String> columns) {
        if (columns.isEmpty()) {
            return this;
        }
        return append(" ORDER BY ").append(String.join(", ", columns));
    }

    public SqlQuery execute() {
        String query = sql.toString();
        if (query.startsWith("SELECT")) {
            resultList = Database.read(query, parameters);
        } else {
            resultSize = Database.write(query, parameters);
        }
        return this;
    }

    private List<Map<String, Object>> resultList;

    public List<Map<String, Object>> resultList() {
        return resultList;
    }

    private int resultSize;

    public int resultSize() {
        return resultSize;
    }
}
