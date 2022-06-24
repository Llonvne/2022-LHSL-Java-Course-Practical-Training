package database.record.types;

import database.KeyPair;

import java.util.*;

/**
 * 类名:     Record
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public final class Record implements MuteableRecord,ConstructRecord {

    public static MuteableRecord generateEmptyRecord(String primaryKey,String[] attributesName){
        Record record = new Record(primaryKey);
        for (String attribute : attributesName){
            record.pushAttribute(attribute);
        }
        return record;
    }

    private final Map<String, String> attributes = new TreeMap<>();

    private final String primaryKey;

    public Record(String primaryKey){
        this.primaryKey = primaryKey;
    }

    @Override
    public String getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public String[] getKeys() {
        return this.attributes.keySet().toArray(new String[0]);
    }

    @Override
    public KeyPair<String, String> getAttribute(String key) {
        if (!attributes.containsKey(key)){
            throw new IllegalArgumentException("非法的字段值");
        }
        return new KeyPair<>(key, this.attributes.get(key));
    }

    @Override
    public KeyPair<String, String> updateAttribute(KeyPair<String, String> newAttribute) {
        if (!attributes.containsKey(newAttribute.getKey())){
            throw new IllegalArgumentException("非法的字段值");
        }
        this.attributes.replace(newAttribute.getKey(), newAttribute.getValue());
        return new KeyPair<>(newAttribute.getKey(), this.attributes.get(newAttribute.getKey()));
    }

    @Override
    public void pushAttribute(String attributeName) {
        KeyPair<String,String> newAttribute = new KeyPair<>(attributeName,"");
        if (this.attributes.containsKey(newAttribute.getKey())){
            this.updateAttribute(newAttribute);
        }
        else {
            this.attributes.put(newAttribute.getKey(),newAttribute.getValue());
        }
    }

    @Override
    public boolean deleteAttribute(String attributeName) {
        if (this.attributes.containsKey(attributeName)){
            this.attributes.remove(attributeName);
            return true;
        }
        return false;
    }

    public boolean isStructureEqual(ImmutableRecord record){
        if (size() != record.size()){
            return false;
        }
        String[] arr1 = getKeys();
        String[] arr2 = record.getKeys();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(getKeys(), record.getKeys());
    }

    public boolean equals(Record record){
        if (!isStructureEqual(record)){
            return false;
        }
        for (Map.Entry<String,String> e : this.attributes.entrySet()){
            if (!Objects.equals(e.getValue(), this.attributes.get(e.getKey()))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.attributes.size();
    }
}
