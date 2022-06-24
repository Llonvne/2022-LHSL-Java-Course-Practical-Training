package database.record;

import database.KeyPair;

public interface ConstructRecord extends MuteableRecord{

    KeyPair<String,String> pushAttribute(KeyPair<String,String> newAttribute);

    boolean deleteAttribute(String attributeName);
}
