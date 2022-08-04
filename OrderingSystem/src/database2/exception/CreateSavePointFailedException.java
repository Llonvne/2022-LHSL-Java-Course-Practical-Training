package database2.exception;

/**
 * 类名:     CreateSavePointFailedException
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class CreateSavePointFailedException extends DatabaseExecption {
    public CreateSavePointFailedException() {
        super("尝试执行SQL语句前，创建保存点失败");
    }
}
