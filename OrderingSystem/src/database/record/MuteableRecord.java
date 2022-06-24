package database.record;

import database.KeyPair;

public interface MuteableRecord extends ImmutableRecord{
    KeyPair<String, String> updateAttribute(KeyPair<String, String> newAttribute);
}
