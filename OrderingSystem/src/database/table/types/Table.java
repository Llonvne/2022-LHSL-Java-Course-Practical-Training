package database.table.types;

import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;

public interface Table extends ImmutableTable {
    boolean insertRecord(ImmutableRecord e);

    boolean remove(ImmutableRecord e);

    MuteableRecord getEmptyRecord();
}
