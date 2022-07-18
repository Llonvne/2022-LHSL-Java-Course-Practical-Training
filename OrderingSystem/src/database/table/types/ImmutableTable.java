package database.table.types;

import database.record.types.ImmutableRecord;

public interface ImmutableTable extends Iterable<ImmutableRecord> {
    boolean contains(ImmutableRecord e);

    String tableName();

    int size();
}
