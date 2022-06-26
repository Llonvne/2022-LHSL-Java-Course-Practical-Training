package ui.displayables;

import ui.Displayable;

/**
 * 类名：       BillUIDisplay
 * 描述：       该类实现了账单显示功能
 * 隶属于：     OrderingSystem
 * 建立事件：   2022/6/25
 * 作者：
 * 邮箱：
 */
public class BillUIDisplay implements Displayable {

    @Override
    public void display(){
        System.out.println("请问是否还继续下单？");
        int flag = 1;//当flag为1时，选择继续下单
        if  (flag == 1){
            System.out.println("返回点餐页面");
        }
        else {
            System.out.println("确认结账");
        }
//        System.out.println("您一共消费" + sumprice + "元");
    }
}
