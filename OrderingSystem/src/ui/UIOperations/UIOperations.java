package ui.UIOperations;

import ui.status.UIStatusController;

// 该类定义了标准的 UIOperations 实现类
public class UIOperations implements UIOPerationsInterface{

//    定义状态转换控制器
    private final UIStatusController uiStatus = new UIStatusController();

//    获取状态转换控制器
    public final UIStatusController getStatusController(){
        return uiStatus;
    }

//    提供 init userInput recall 钩子用于子类重写
    public void init(){};
    public void userInput(){};
    public void recall(){};
}
