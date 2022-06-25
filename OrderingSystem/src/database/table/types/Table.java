package database.table.types;

import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;

import java.sql.SQLException;

public interface Table extends ImmutableTable {
    boolean insertRecord(ImmutableRecord e) throws SQLException;

    boolean remove(ImmutableRecord e) throws SQLException;

    MuteableRecord getEmptyRecord();

    boolean updateRecord(ImmutableRecord e) throws SQLException;
}
