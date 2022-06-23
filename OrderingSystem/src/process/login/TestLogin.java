package process.login;

import exec.Exec;

/**
 * 类名:     TestLogin
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/23
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TestLogin {
    public static void main(String[] args) {
        Exec execLogin = LoginTask.getLoginTask();
        execLogin.exec();
    }
}
