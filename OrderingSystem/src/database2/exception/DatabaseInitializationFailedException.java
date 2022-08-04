package database2.exception;

/**
 * 类名:     DatabaseInitializationFailedException
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class DatabaseInitializationFailedException extends Exception {
    public DatabaseInitializationFailedException(String msg) {
        super(msg);
    }
}
