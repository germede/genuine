package org.fwf.mvc;

import org.fwf.exc.GetterIsAbsentOrInaccessibleException;
import org.fwf.exc.ModelHasNoMappedTableException;
import org.fwf.log.Log;
import org.fwf.orm.Query;
import org.fwf.orm.QueryHelper;

import java.lang.reflect.InvocationTargetException;

public abstract class Model<T extends Model<T>> {

    public T create() {
        try {
            String table = QueryHelper.retrieveTable(this);
            QueryHelper.ColumnValueListsPair columnValueListsPair = QueryHelper.generateColumnValueListPair(this);
            Query query = new Query()
                    .insert()
                    .into(table, columnValueListsPair.columns)
                    .values(columnValueListsPair.values)
                    .execute();

        } catch (ModelHasNoMappedTableException e) {
            Log.e("Model " + this.getClass().getCanonicalName() + " has no mapped table");
        } catch (GetterIsAbsentOrInaccessibleException e) {
            Log.e("Getter method for " + this.getClass().getCanonicalName() + "->" + e.getFieldName() + " may not exist or be inaccessible");
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.e(e.getMessage(), e);
        }
        return (T)this;
    }

}
