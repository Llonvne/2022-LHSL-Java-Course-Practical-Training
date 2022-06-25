package process;

import database.Init;
import exec.Tasks;

/**
 * 类名:     process.Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        tasks.offer(new Init("Ordering"));
        tasks.exec();
    }
}
