package database.record;

/**
 * 类名:     OrderRecord
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class OrderRecord extends Record {

    @Override
    public String getPrimaryKey() {
        return "OrderNo";
    }

    public static void main(String[] args) {

    }
}
