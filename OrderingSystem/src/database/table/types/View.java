package database.table.types;

import database.record.constructor.recordConstructor.RecordConstructor;

/**
 * 类名:     View
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class View extends StandardTable implements ImmutableTable{
    public View(String name, RecordConstructor constructor) {
        super(name, constructor);
    }
}
