package database.tables;

public interface Table {
    String getPrimaryKey();

    String[] getAllAttributesName();
}
