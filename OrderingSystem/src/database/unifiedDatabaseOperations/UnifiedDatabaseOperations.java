package database.unifiedDatabaseOperations;

import database.record.constructor.recordConstructor.RecordConstructor;
import database.record.types.ImmutableRecord;
import database.sqlTools.AdvanceResultSet;
import database.table.types.ImmutableTable;
import database.table.types.Table;

import java.sql.SQLException;

public interface UnifiedDatabaseOperations {
    void insertRecord(ImmutableRecord record) throws SQLException;

    boolean contains(ImmutableRecord record) throws SQLException;

    ImmutableRecord getRecordByPrimaryKey(String tableName, String primaryKey) throws SQLException;

    void remove(ImmutableRecord record) throws SQLException;

    void update(ImmutableRecord record) throws SQLException;

    Table getTable(String tableName);

    Table createTable(String tableName, RecordConstructor recordConstructor);

    ImmutableTable getResultSetTable(String tableName, AdvanceResultSet resultSet);
}
