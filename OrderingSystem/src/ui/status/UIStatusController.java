package ui.status;

/**
 * 类名:     UIStatusController
 * 描述:     为 UIStatus 类提供了状态转换的方法
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/22
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public final class UIStatusController {

    // 定义了状态
    private UIStatus uiStatus = UIStatus.INIT;

    //  该方法用于具体UI实现更改状态
    public void setStatus(UIStatus uiStatus) {
        this.uiStatus = uiStatus;
    }

    // 用于获取当前状态
    public UIStatus getStatus() {
        return this.uiStatus;
    }

    // 转换到下一个状态
    public void next_status() {
        if (uiStatus == UIStatus.END) {
            return;
        }
        this.uiStatus = UIStatus.values()[uiStatus.ordinal() + 1];
    }
}
