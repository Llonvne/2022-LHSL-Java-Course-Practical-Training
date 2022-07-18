package database2.keyPair;

public interface KeyPair<K, E> {
    K getKey();

    E getValue();

    boolean equals(KeyPair<K, E> other);
}
