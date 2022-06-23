package ui;

import exec.Exec;
import ui.UIOperations.UIOPerationsInterface;
import ui.status.UIStatus;
import ui.status.UIStatusController;

/**
 * 类名:     FormHandler
 * 描述:     抽象窗体实现，提供钩子供UI调用者实现，并提供状态转换功能
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/21
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class FormHandler implements Exec {

    private final Displayable display;
    private final UIOPerationsInterface uiOperations;

    public FormHandler(Displayable display, UIOPerationsInterface uiOperations) {
        this.display = display;
        this.uiOperations = uiOperations;
    }

    public final void exec() {
        UIStatusController uiStatus = uiOperations.getStatusController();
        while (uiStatus.getStatus() != UIStatus.END) {
            switch (uiStatus.getStatus()) {
                case INIT -> uiOperations.init();
                case DISPLAY -> display.display();
                case HANDLER_USER_INPUT -> uiOperations.userInput();
                case RECALL -> uiOperations.recall();
            }
            uiStatus.next_status();
        }
    }
}
