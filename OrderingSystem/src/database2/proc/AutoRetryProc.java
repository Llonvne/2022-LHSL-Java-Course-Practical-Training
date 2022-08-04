package database2.proc;

import database2.exception.AutoRetryFailedException;
import database2.exception.DatabaseExecption;

/**
 * 类名:     AutoRetry
 * 描述:     自动重试过程
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AutoRetryProc<E> implements Proc<E> {
    private final Proc<E> proc;
    private final int time;

    public AutoRetryProc(Proc<E> proc, int time) throws DatabaseExecption {
        this.proc = proc;
        this.time = time;
    }

    @Override
    public E run() throws DatabaseExecption {
        for (int i = 0; i < time; i++) {
            try {
                return proc.run();
            } catch (DatabaseExecption e) {
                if (i == time - 1) {
                    throw new AutoRetryFailedException(e);
                }
                System.out.println("执行过程失败，正在重试");
            }
        }
        return null;
    }
}
