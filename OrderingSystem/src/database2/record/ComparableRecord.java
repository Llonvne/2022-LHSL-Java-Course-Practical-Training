package database2.record;

import database2.keyPair.ComparableKeyPair;
import database2.keyPair.KeyPair;

public interface ComparableRecord<K extends Comparable<K>, V, E extends KeyPair<K, V>> extends
    Record<K, V, E> {
}
