package database.table.pool;

import database.table.types.Table;

public interface TablePool extends Iterable<Table> {
    boolean insertTable(Table table);
    Table getTable(String tableName);
}
