package database2.record;

import database2.exception.KeyNotFoundException;
import database2.keyPair.ComparableKeyPair;
import database2.keyPair.KeyPair;

import java.util.Collection;
import java.util.TreeMap;

/**
 * 类名:     StandardTreeMapRecord
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardTreeMapRecord<K extends Comparable<K>, V, E extends KeyPair<K, V>> implements ComparableRecord<K, V, E> {

    private final TreeMap<K, E> attributes = new TreeMap<>();

    public StandardTreeMapRecord(Collection<E> attributes) {
        for (E e : attributes) {
            this.attributes.put(e.getKey(), e);
        }
    }

    @Override
    public V getValue(K key) throws KeyNotFoundException {
        return getKeyPair(key).getValue();
    }

    @Override
    public E getKeyPair(K key) throws KeyNotFoundException {
        E e = this.attributes.get(key);
        if (e == null) {
            throw new KeyNotFoundException(key);
        }
        return e;
    }

    @Override
    public Collection<E> getKeyPairs() {
        return this.attributes.values();
    }

    @Override
    public Collection<K> getKeys() {
        return this.attributes.keySet();
    }

    @Override
    public boolean contains(K key) {
        return this.attributes.containsKey(key);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : getKeyPairs()) {
            sb.append(e);
        }
        return sb.toString();
    }
}
