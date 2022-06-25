package database.table.types;

import database.record.types.ImmutableRecord;

import java.sql.SQLException;

public interface ImmutableTable extends Iterable<ImmutableRecord>{
    boolean contains(ImmutableRecord e);

    ImmutableRecord getRecordByPrimaryKey(String primaryKey);

    String tableName();
}
