package database.keyValue;

public interface ImmutableKeyPair<K, V> {
    K getKey();

    V getValue();

    String toString();
}
