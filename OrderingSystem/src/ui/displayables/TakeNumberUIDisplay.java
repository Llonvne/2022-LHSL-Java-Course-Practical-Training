package ui.displayables;

import ui.Displayable;

/**
 * 类名：       TakeNumberUIDisplay
 * 描述：       该类实现了取号功能
 * 隶属于：     OrderingSystem
 * 建立事件：   2022/06/25
 * 作者：
 * 邮箱：
 */
public class TakeNumberUIDisplay implements Displayable{
    @Override
    public void diaplay(){
        System.out.println(">>> 我的排队号码");
        System.out.println(">>> 等待队列：");//小桌，中桌，大桌
        System.out.println(">>> 取号时间：");
        System.out.println(">>> 等位人数：");
        System.out.println("---- 友情提示：请留意叫号通知，不要过号 ----");
    }
}
