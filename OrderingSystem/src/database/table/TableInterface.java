package database.table;

import database.record.Record;

public interface TableInterface extends ImmutableTable {
    boolean insertRecord(Record e);

    boolean remove(Record e);
}
