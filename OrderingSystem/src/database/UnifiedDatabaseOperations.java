package database;

import database.record.constructor.recordConstructor.RecordConstructor;
import database.record.types.ImmutableRecord;
import database.table.types.Table;

public interface UnifiedDatabaseOperations {
    void insertRecord(ImmutableRecord record);

    boolean contains(ImmutableRecord record);

    ImmutableRecord getRecordByPrimaryKey(String tableName, String primaryKey);

    void remove(ImmutableRecord record);

    Table getTable(String tableName);

    Table createTable(String tableName, RecordConstructor recordConstructor);
}
