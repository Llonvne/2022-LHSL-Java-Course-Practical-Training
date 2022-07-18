package database2.keyPair;

public interface ComparableKeyPair<K extends Comparable<? super K>, V> extends Comparable<ComparableKeyPair<K, V>> {
    K getKey();

    V getValue();
}