package database.table;

import database.record.ImmutableRecord;
import database.record.Record;

public interface ImmutableTable extends Iterable<ImmutableRecord>{
    boolean contains(ImmutableRecord e);

    ImmutableRecord getRecordByPrimaryKey(String primaryKey);
}
