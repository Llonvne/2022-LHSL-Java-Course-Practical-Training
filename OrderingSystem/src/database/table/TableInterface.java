package database.table;

public interface TableInterface<E> {
    boolean insertRecord(E e);
    boolean contains(E e);
    boolean remove(E e);
}
