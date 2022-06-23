package exec.recall;

import exec.Exec;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.StandardUIDisplay;

/**
 * 类名:     TestRecallable
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class TestRecallable {
    public static void main(String[] args) {
        Recevier<String> receiver = System.out::println;

        Exec exec = new FormHandler(new StandardUIDisplay(
            "header", "content", "footer"
        ), new UIOperations(){
            private final Sender<String> recall = new Sender<>();

            @Override
            public void init() {
                recall.bindRecevier(receiver);
            }

            @Override
            public void recall() {
                recall.send("我完成啦回调！");
            }
        });

        exec.exec();
    }
}
