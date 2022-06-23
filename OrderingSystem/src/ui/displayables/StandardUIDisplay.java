package ui.displayables;

import ui.Displayable;

/**
 * 类名:     StandardUIDisplay
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/21
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class StandardUIDisplay implements Displayable {

    private final String header;
    private final String content;
    private final String footer;

    public StandardUIDisplay(String header, String content, String footer) {
        this.header = header;
        this.content = content;
        this.footer = footer;
    }

    public final void display() {
        System.out.println("---" + header + "---");
        System.out.println(content);
        System.out.println("---" + footer + "---");
    }
}
