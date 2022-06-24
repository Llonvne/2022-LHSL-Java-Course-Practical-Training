package database.record;

import database.KeyPair;

public interface ConstructRecord {

    KeyPair<String,String> pushAttribute(KeyPair<String,String> newAttribute);

    boolean deleteAttribute(String attributeName);
}
