package database2.keyPair;

/**
 * 类名:     KeyPair
 * 描述:     标准键值对类型
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardKeyPair<K, V> implements KeyPair<K, V> {
    private K key;
    private V value;

    public StandardKeyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(KeyPair<K, V> other) {
        return this.key.equals(other.getKey());
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return "{" + key.toString() + ": " + value.toString() + "}";
    }
}

