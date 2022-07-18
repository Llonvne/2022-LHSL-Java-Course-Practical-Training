package database2;

import database.table.types.Table;
import database2.exception.DatabaseExecption;
import database2.exception.KeyNotFoundException;
import database2.exception.ValueNotFoundException;
import database2.keyPair.StringPair;
import database2.record.Record;
import database2.record.StandardRecord;
import database2.table.PrimaryKeyTable;
import database2.table.StandardPrimaryKeyTable;
import database2.table.StandardTable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 类名:     Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(StandardTable.class.getDeclaredMethods()));
    }
}
