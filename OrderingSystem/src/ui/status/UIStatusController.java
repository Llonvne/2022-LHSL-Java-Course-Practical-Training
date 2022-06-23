package ui.status;

/**
 * 类名:     UIStatusController
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class UIStatusController {
    //  这是 UI 状态枚举类，用于控制状态

    private UIStatus uiStatus = UIStatus.INIT;

    //  该方法用于具体UI实现更改状态
    public final void setStatus(UIStatus uiStatus) {
        this.uiStatus = uiStatus;
    }

    public final UIStatus getStatus() {
        return this.uiStatus;
    }

    public final void next_status() {
        if (uiStatus == UIStatus.END) {
            return;
        }
        this.uiStatus = UIStatus.values()[uiStatus.ordinal() + 1];
    }
}
