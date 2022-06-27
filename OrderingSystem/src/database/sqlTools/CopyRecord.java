package database.sqlTools;

import database.keyValue.KeyPair;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;

/**
 * 类名:     CopyRecord
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class CopyRecord {
    public static void record(ImmutableRecord src, MuteableRecord dest) {
        if (!src.isStructureEqual(dest)) {
            throw new IllegalArgumentException("记录结构不一致！");
        }
        for (String key : src.getKeys()) {
            dest.updateAttribute(new KeyPair<>(key, src.getAttribute(key).getValue()));
        }
    }
}
