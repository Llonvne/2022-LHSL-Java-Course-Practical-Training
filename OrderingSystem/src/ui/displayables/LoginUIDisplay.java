package ui.displayables;

import ui.Displayable;

/**
 * 类名:     LoginUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/25
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class LoginUIDisplay implements Displayable {
    @Override
    public void display() {
        System.out.println("----- 订餐系统登入界面 ------");
        System.out.println(">>> 请输入账号密码");
//        System.out.println("1. 我要订餐");
//        System.out.println("2. 查看订单");
    }
}
