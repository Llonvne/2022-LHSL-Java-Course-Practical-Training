package ui.UIOperations;

import java.util.Scanner;

/**
 * 类名:     LookOnlyOperations
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class LookOnlyOperations extends UIOperations {
    public void userInput() {
        System.out.println("请输入 1 继续");
        System.out.print(">>>");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.nextLine().equals("1")) {
        }
    }
}
