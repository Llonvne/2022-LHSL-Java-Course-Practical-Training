package database.table;

import database.table.types.Table;

public interface TableGetter {
    Table getTable(String tableName);
}
