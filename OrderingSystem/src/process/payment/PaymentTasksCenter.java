package process.payment;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import exec.tasksCenter.StandardTasksCenter;
import exec.tasksCenter.TasksCenter;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.NotificationUIDisplay;

/**
 * 类名:     PaymentTasksCenter
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class PaymentTasksCenter extends ExecWithSender {
    private final String orderId;

    public PaymentTasksCenter(Recevier<Exec> sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    private final TasksCenter tasksCenter = new StandardTasksCenter();

    @Override
    public void exec() {

        // 获得用户支付状态
        Table order = new TableGetter("订单表").getTable();
        ImmutableRecord record = order.getRecordByPrimaryKey(orderId);

        // 检查用户支付状态，如果已支付，提示下次光临
        if (record.getAttribute("支付状态").getValue().equals("已支付")) {
            send(new FormHandler(
                new NotificationUIDisplay("支付结果", "你已经完成订单支付,欢迎下次光临"),
                new UIOperations()
            ));
            // 未支付，进入支付模块
        } else {
            send(new PaymentChooseModule(tasksCenter.getTaskRecevier(), orderId));
        }
    }
}
