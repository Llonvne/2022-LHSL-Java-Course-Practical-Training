package database;

public interface TableOperations<Record, PrimaryKeyType> {
    boolean insert(Record record);

    boolean delete(Record record);

    Record search(PrimaryKey<PrimaryKeyType> primaryKey);

    Record update(PrimaryKey<PrimaryKeyType> primaryKey, Record newRecord);
}
