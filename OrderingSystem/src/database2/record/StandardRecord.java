package database2.record;

import database2.exception.KeyNotFoundException;
import database2.keyPair.KeyPair;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 类名:     StandardRecord
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardRecord<K, V, E extends KeyPair<K, V>> implements Record<K, V, E> {
    private final Collection<E> attributes;

    public StandardRecord(Collection<E> attributes) {
        this.attributes = attributes;
    }

    @Override
    public V getValue(K key) throws KeyNotFoundException {
        return getKeyPair(key).getValue();
    }

    @Override
    public E getKeyPair(K key) throws KeyNotFoundException {
        for (E attribute : attributes) {
            if (attribute.getKey().equals(key)) {
                return attribute;
            }
        }
        throw new KeyNotFoundException(key);
    }

    @Override
    public Collection<E> getKeyPairs() {
        return attributes.stream().toList();
    }

    @Override
    public Collection<K> getKeys() {
        Collection<K> keys = new LinkedList<>();
        for (E e : attributes) {
            keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public boolean contains(K key) {
        try {
            E e = getKeyPair(key);
        } catch (KeyNotFoundException e) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : attributes) {
            sb.append(e);
        }
        return sb.toString();
    }
}
