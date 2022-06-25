package process;

import exec.Exec;
import exec.Tasks;
import exec.TasksWithNotEmptyRecevier;
import process.login.LoginTask;

/**
 * 类名:     process.Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ExecProccessor{
    private volatile static ExecProccessor uniqueInstance;
    private ExecProccessor(){}
    public static ExecProccessor getInstance() {
        if (uniqueInstance == null){
            synchronized (ExecProccessor.class){
                if (uniqueInstance == null){
                    uniqueInstance = new ExecProccessor();
                }
            }
        }
        return uniqueInstance;
    }


}
