package ui.displayables;

import ui.Displayable;

/**
 * 类名：       OrderMenuDisplay
 * 描述：       该类实现餐厅的点餐功能
 * 隶属于：     OrderingSystem
 * 建立事件：   2022/6/25
 * 作者：
 * 邮箱：
 */
public class OrderMenuDisplay implements Displayable {

    public String MenuName;//菜名
    public float price;//单价

    public OrderMenuDisplay(String MenuName, String price){
        this.MenuName = MenuName;
    }

    @Override
    public void display(){
        System.out.println(">>> 您所点的菜品如下：");
        System.out.println(">>> 温馨提示：如若顾客已确认，请尽快下单哦！");
    }
}
