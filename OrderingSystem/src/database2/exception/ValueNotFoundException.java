package database2.exception;


/**
 * 类名:     PrimaryKeyRecordNotFoundException
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ValueNotFoundException extends DatabaseExecption {
    public ValueNotFoundException(Object key, Object value) {
        super("键" + key + "值为" + value + "未找到！");
    }
}
