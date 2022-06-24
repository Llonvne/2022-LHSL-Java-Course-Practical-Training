package database.record.types;

public interface ConstructRecord {

    void pushAttribute(String attributeName);

    boolean deleteAttribute(String attributeName);
}
