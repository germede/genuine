package org.fwf.orm;

import java.util.List;

public class Query {

    private StringBuilder sql;
    private List parameters;

    public Query() {
        sql = new StringBuilder();
    }

    public Query select(String select) {
        sql.append("SELECT ").append(select);
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
        sql.append("VALUES (").append(placeholders).append(")");
        return this;
    }

    public Query execute() {
        if (sql.toString().startsWith("SELECT")) {
//            Database.executeSelect(sql, )
        } else {
            Database.execute(sql.toString(),parameters);
        }
        return this;
    }

}
