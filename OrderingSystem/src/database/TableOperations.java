package database;

public interface TableOperations<Record, PrimaryKeyType> {
    boolean insert(Record record);

    boolean delete(Record record);

    Record search(String primaryKey);

    Record update(String primaryKey, Record newRecord);
}
