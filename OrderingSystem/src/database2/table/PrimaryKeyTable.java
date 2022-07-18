package database2.table;

import database2.exception.DatabaseExecption;
import database2.exception.KeyNotFoundException;
import database2.exception.ValueNotFoundException;
import database2.keyPair.KeyPair;
import database2.record.Record;

public interface PrimaryKeyTable<K, V, E extends KeyPair<K, V>, R extends Record<K, V, E>> extends Table<K, V, E, R> {
    K getPrimaryKey();

    Record<K, V, E> searchByPrimaryKey(V v) throws KeyNotFoundException, ValueNotFoundException;
}
