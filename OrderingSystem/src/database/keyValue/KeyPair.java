package database.keyValue;

/**
 * 类名:     KeyPair
 * 描述:     记录键值对基本类型
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */

// 由范型 K V K表示Key的类型 V表示Value的类型
public class KeyPair<K, V> {
    private K key;
    private V value;

//    提供构造方法
    public KeyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

//    提供标准 Getter Setter 方法
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

//    提供标准 toString 方法
    public String toString() {
        return "{" + getKey() + ": " + getValue() + " }";
    }
}
