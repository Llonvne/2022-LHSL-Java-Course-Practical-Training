package database.unifiedDatabaseOperations;

import database.record.constructor.recordConstructor.RecordConstructor;
import database.record.types.ImmutableRecord;
import database.table.TableFactory;
import database.table.types.Table;

import java.sql.SQLException;

public class StandardUnifiedDatabaseOperations implements UnifiedDatabaseOperations{
    private final TableFactory tableFactory;
    public StandardUnifiedDatabaseOperations(TableFactory tableFactory){
        this.tableFactory = tableFactory;
    }

    private Table getTable(ImmutableRecord record){
        Table target = tableFactory.getTable(record.getName());
        if (!record.isStructureEqual(target.getEmptyRecord())){
            throw new IllegalArgumentException("表结构不一致！");
        }
        return target;
    }

    @Override
    public void insertRecord(ImmutableRecord record) throws SQLException {
        Table t = getTable(record);
        t.insertRecord(record);
    }

    @Override
    public boolean contains(ImmutableRecord record) throws SQLException {
        return this.getTable(record.getName()).contains(record);
    }

    @Override
    public ImmutableRecord getRecordByPrimaryKey(String tableName, String primaryKey) throws SQLException {
        Table target = tableFactory.getPools().getTable(tableName);
        return target.getRecordByPrimaryKey(primaryKey);
    }

    @Override
    public void remove(ImmutableRecord record) throws SQLException {
        Table target = getTable(record);
        target.remove(record);
    }

    @Override
    public void update(ImmutableRecord record) throws SQLException {
        this.getTable(record.getName()).updateRecord(record);
    }

    @Override
    public Table getTable(String tableName) {
        return tableFactory.getPools().getTable(tableName);
    }

    @Override
    public Table createTable(String tableName, RecordConstructor recordConstructor) {
        return this.tableFactory.generaterTable(tableName,recordConstructor);
    }
}
