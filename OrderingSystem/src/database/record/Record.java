package database.record;

import database.KeyPair;

import java.util.Map;
import java.util.TreeMap;

/**
 * 类名:     Record
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public abstract class Record implements RecordInterface {
    private final Map<String, String> attributes = new TreeMap<String, String>();

    @Override
    public final String[] getKeys() {
        return this.attributes.keySet().toArray(new String[0]);
    }

    @Override
    public final KeyPair<String, String> getAttribute(String key) {
        return new KeyPair<>(key, this.attributes.get(key));
    }

    @Override
    public final KeyPair<String, String> updateAttribute(KeyPair<String, String> newAttribute) {
        this.attributes.replace(newAttribute.getKey(), newAttribute.getValue());
        return new KeyPair<>(newAttribute.getKey(), this.attributes.get(newAttribute.getKey()));
    }

    @Override
    public final KeyPair<String, String> pushAttribute(KeyPair<String, String> newAttribute) {
        if (this.attributes.containsKey(newAttribute.getKey())){
            this.updateAttribute(newAttribute);
        }
        else {
            this.attributes.put(newAttribute.getKey(),newAttribute.getValue());
        }
        return new KeyPair<>(newAttribute.getKey(), this.attributes.get(newAttribute.getKey()));
    }

    @Override
    public final boolean deleteAttribute(String attributeName) {
        if (this.attributes.containsKey(attributeName)){
            this.attributes.remove(attributeName);
            return true;
        }
        return false;
    }
}
