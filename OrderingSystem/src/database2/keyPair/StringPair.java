package database2.keyPair;

import java.util.Objects;

/**
 * 类名:     StringPair
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StringPair extends StandardKeyPair<String, String> implements ComparableKeyPair<String, String> {
    public StringPair(String key, String value) {
        super(key, value);
    }

    @Override
    public int compareTo(ComparableKeyPair<String, String> o) {
        return getKey().compareTo(o.getKey());
    }
}
