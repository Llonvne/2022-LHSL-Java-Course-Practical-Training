package database2.exception;

/**
 * 类名:     KeyNotFoundException
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class KeyNotFoundException extends DatabaseExecption {
    public KeyNotFoundException(Object object) {
        super("键值 " + object.toString() + " 未被发现！");
    }
}
