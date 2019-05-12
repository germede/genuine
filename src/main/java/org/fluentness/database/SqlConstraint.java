package org.fluentness.database;

import java.util.ArrayList;
import java.util.List;

public class SqlConstraint {

    private StringBuilder sql;
    private List<Object> parameters;

    public SqlConstraint(String firstOperand) {
        this.sql = new StringBuilder();
        this.parameters = new ArrayList<>();
        append(firstOperand);
    }

    public List<Object> getParameters() {
        return parameters;
    }

    private SqlConstraint append(String toAppend) {
        sql.append(toAppend);
        return this;
    }

    public String toString() {
        return sql.toString();
    }

    public SqlConstraint isEqualTo(Object secondOperand) {
        parameters.add(secondOperand);
        return append(" = ?");
    }

    public SqlConstraint like(String secondOperand) {
        secondOperand = "%" + secondOperand + "%";
        parameters.add(secondOperand);
        return append(" LIKE ?");
    }

    public SqlConstraint and(SqlConstraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" AND (").append(constraint.toString()).append(")");
    }

    public SqlConstraint or(SqlConstraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" OR (").append(constraint.toString()).append(")");
    }
}
