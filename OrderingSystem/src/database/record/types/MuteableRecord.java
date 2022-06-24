package database.record.types;

import database.KeyPair;

public interface MuteableRecord extends ImmutableRecord{
    KeyPair<String, String> updateAttribute(KeyPair<String, String> newAttribute);

    void setTableName(String tableName);
}
