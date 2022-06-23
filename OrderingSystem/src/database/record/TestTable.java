package database.record;

import database.KeyPair;
import database.record.types.OrderRecord;

import java.util.Arrays;

/**
 * 类名:     TestTable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TestTable {
    public static void main(String[] args) {
        Record record = new OrderRecord();
        record.pushAttribute(new KeyPair<>("OrderNo","12345"));
        record.pushAttribute(new KeyPair<>("CustomerNo","12345"));
        System.out.println(Arrays.toString(record.getKeys()));
        System.out.println(record.getAttribute("OrderNo"));
        record.updateAttribute(new KeyPair<>(record.getPrimaryKey(),"123456"));
        System.out.println(record.getAttribute("OrderNo"));
        record.deleteAttribute("CustomerNo");
        System.out.println(Arrays.toString(record.getKeys()));
    }
}
