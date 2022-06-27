package process.welcome;

import ui.Displayable;

/**
 * 类名:     WelcomeUIDisplay
 * 描述:     该类实现了欢迎界面的功能
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class WelcomeUIDisplay implements Displayable {
    @Override
    public void display(){
        System.out.println("------ 您好！欢迎光临LHSL浪漫餐厅！ ------");
        System.out.println("");
        System.out.println("        \uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D    ");
        System.out.println("            ~ ^^^^ ~");
        System.out.println("            {/0  0/}");
        System.out.println("            ( (00) )");
        System.out.println("              ~~~~   ");
        System.out.println("        \uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D\uD83D\uDE3D     ");
        System.out.println(">>>吃自己的饭，让别人流口水去吧   (✿◡‿◡)");
        System.out.println("");
        System.out.println("------ 本店菜品众多，任君选择，祝您用餐愉快！ ------");
    }
}
