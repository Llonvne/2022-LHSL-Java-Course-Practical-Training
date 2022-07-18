package database2.proc;

import java.util.Collection;

/**
 * 类名:     LoadDatabase
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/18
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class LoadDatabase implements Proc<Collection<Integer>> {
    private final String databaseName;

    public LoadDatabase(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public Collection<Integer> run() {

        return null;
    }
}
