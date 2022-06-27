package database.record.types;

import database.keyValue.KeyPair;

public interface ImmutableRecord {
    String getPrimaryKey();

    String[] getKeys();

    KeyPair<String,String> getAttribute(String key);

    boolean isStructureEqual(ImmutableRecord record);

    boolean equals(ImmutableRecord record);

    String getName();

    int size();
}
