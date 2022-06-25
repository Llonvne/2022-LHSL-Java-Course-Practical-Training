package database.table;

import database.table.types.Table;

public interface TableReceiver {
    Table getTable(String tableName);
}
