package database.table.types;

import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;

import java.sql.SQLException;

public interface Table extends ImmutableTable {
    boolean insertRecord(ImmutableRecord e);

    boolean remove(ImmutableRecord e);

    MuteableRecord getEmptyRecord();

    boolean updateRecord(ImmutableRecord e);

    ImmutableRecord getRecordByPrimaryKey(String primaryKey);
}
