package ui.displayables;

import ui.Displayable;

/**
 * 类名:     StandardUIDisplay
 * 描述:     该类定义了标准的窗口显示模式
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/21
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardUIDisplay implements Displayable {

//    窗口头
    private final String header;

//    窗口内容
    private final String content;

//    窗口尾部
    private final String footer;

//    构造方法
    public StandardUIDisplay(String header, String content, String footer) {
        this.header = header;
        this.content = content;
        this.footer = footer;
    }

//    显示方法
    public void display() {
        System.out.println("---" + header + "---");
        System.out.println(content);
        System.out.println("---" + footer + "---");
    }
}
