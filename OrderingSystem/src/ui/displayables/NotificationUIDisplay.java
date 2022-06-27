package ui.displayables;

import ui.Displayable;

/**
 * 类名:     NotificationUIDisplay
 * 描述:     该类实现了标准的通知模式
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class NotificationUIDisplay implements Displayable {

//    通知头
    public String header;

//    通知正文
    public String content;

//    构造方法
    public NotificationUIDisplay(String header, String content) {
        this.header = header;
        this.content = content;
    }

//    显示方法
    @Override
    public void display() {
        System.out.println("---" + header + "---");
        System.out.println(content);
    }

}
