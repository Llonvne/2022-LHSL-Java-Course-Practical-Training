package database.record;

import database.KeyPair;

import java.security.Key;

public interface RecordInterface {
    String getPrimaryKey();

    String[] getKeys();

    KeyPair<String,String> getAttribute(String key);

    KeyPair<String, String> updateAttribute(KeyPair<String, String> newAttribute);

    KeyPair<String,String> pushAttribute(KeyPair<String,String> newAttribute);

    boolean deleteAttribute(String attributeName);
}
