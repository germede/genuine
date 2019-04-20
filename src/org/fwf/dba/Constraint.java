package org.fwf.dba;

import java.util.ArrayList;
import java.util.List;

public class Constraint {

    private StringBuilder sql;
    private List<Object> parameters;

    public Constraint(String firstOperand) {
        this.sql = new StringBuilder();
        this.parameters = new ArrayList<>();
        append(firstOperand);
    }

    public List<Object> getParameters() {
        return parameters;
    }

    private Constraint append(String toAppend) {
        sql.append(toAppend);
        return this;
    }

    public String toString() {
        return "(".concat(sql.toString()).concat(")");
    }

    public Constraint isEqualTo(Object secondOperand) {
        parameters.add(secondOperand);
        return append(" = ?");
    }

    public Constraint and(Constraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" AND (").append(constraint.toString()).append(")");
    }

    public Constraint or(Constraint constraint) {
        parameters.addAll(constraint.getParameters());
        return append(" OR (").append(constraint.toString()).append(")");
    }

}
