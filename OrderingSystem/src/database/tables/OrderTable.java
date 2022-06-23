package database.tables;

import process.order.status.OrderStatus;

/**
 * 类名:     OrderTable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public enum OrderTable implements Table {
    ;

    @Override
    public String getPrimaryKey() {
        return null;
    }

    @Override
    public String[] getAllAttributesName() {
        return new String[0];
    }
}
