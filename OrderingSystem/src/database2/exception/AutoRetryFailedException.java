package database2.exception;

/**
 * 类名:     AutoRetryFailedException
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AutoRetryFailedException extends DatabaseExecption{
    public AutoRetryFailedException(DatabaseExecption e){
        super("自动尝试后仍然失败！");
    }
}
