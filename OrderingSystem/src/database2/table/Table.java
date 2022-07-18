package database2.table;

import database2.exception.DatabaseExecption;
import database2.exception.KeyNotFoundException;
import database2.keyPair.KeyPair;
import database2.record.Record;

/**
 * 表接口
 *
 * @param <K> 键值对的键类型
 * @param <V> 键值对的值类型
 * @param <E> 键值对组合方式
 * @param <R> 记录类型
 */
public interface Table<K, V, E extends KeyPair<K, V>, R extends Record<K, V, E>>
    extends Iterable<R> {

    void insert(R r);

    boolean contains(R r);

    Table<K, V, E, R> searchByAttribute(KeyPair<K, V> attribute) throws KeyNotFoundException;

}
