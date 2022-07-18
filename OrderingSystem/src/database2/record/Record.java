package database2.record;

import database2.exception.DatabaseExecption;
import database2.exception.KeyNotFoundException;
import database2.keyPair.KeyPair;

import java.util.Collection;
/**
K 键值对的键类型
 V 键值对的值类型
 E 键值对组合类型
 */
public interface Record<K, V, E extends KeyPair<K, V>> {
    V getValue(K key) throws KeyNotFoundException;

    E getKeyPair(K key) throws KeyNotFoundException;

    Collection<E> getKeyPairs();

    Collection<K> getKeys();

    boolean contains(K key);
}
