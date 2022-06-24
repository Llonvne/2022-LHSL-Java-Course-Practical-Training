package database.record.types;

import database.KeyPair;

public interface ImmutableRecord {
    String getPrimaryKey();

    String[] getKeys();

    KeyPair<String,String> getAttribute(String key);

    boolean isStructureEqual(ImmutableRecord record);

    boolean equals(Record record);

    int size();
}
