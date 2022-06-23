package ui.displayables;

import ui.Displayable;

/**
 * 类名:     NotificationUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class NotificationUIDisplay implements Displayable {
    public String header;
    public String content;

    public NotificationUIDisplay(String header, String content) {
        this.header = header;
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println("---" + header + "---");
        System.out.println(">>>" + content);
    }

}
