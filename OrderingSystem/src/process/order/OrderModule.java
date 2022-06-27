package process.order;

import database.TableGetter;
import database.record.types.ImmutableRecord;
import database.table.types.ImmutableTable;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import exec.tasksCenter.StandardTasksCenter;
import exec.tasksCenter.TasksCenter;
import process.menu.UserOrderedMenuUIDisplay;
import process.payment.PaymentTasksCenter;
import ui.FormHandler;
import ui.UIOperations.LookOnlyOperations;
import ui.UIOperations.UIOperations;
import ui.UIOperations.UIOperationsWithSender;
import ui.displayables.NotificationUIDisplay;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类名:     OrderUI
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class OrderModule extends ExecWithSender {
    public String orderId;

    public OrderModule(Recevier<Exec> sender) {
        super(sender);
    }

    public TasksCenter tasks = new StandardTasksCenter();

    @Override
    public void exec() {

        AtomicReference<String> choice = new AtomicReference<>("");
        Recevier<String> recevier = choice::set;
        new FormHandler(new NewOrderUIDisplay(),
            new UIOperationsWithSender<>(recevier) {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    send(choice);
                }
            }).exec();

        if (choice.get().equals("1")) {
            send(new CreateNewOrderModule(getSender()));
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的订单号:");
        orderId = scanner.nextLine();
        ImmutableTable table = new TableGetter("订单表").getTable();

        // 查询用户状态
        Table order = new TableGetter("订单表").getTable();
        ImmutableRecord record = order.getRecordByPrimaryKey(orderId);
        if (Objects.equals(record.getAttribute(record.getPrimaryKey()).getValue(), "")) {
            send(new FormHandler(
                new NotificationUIDisplay("你输入的订单号有误", "1.重新输入\n其他.退出"),
                new UIOperations() {
                    @Override
                    public void userInput() {
                        String choice;
                        choice = scanner.nextLine();
                        if (choice.equals("1")) {
                            send(new OrderModule(getSender()));
                            return;
                        }
                    }
                }));
        }

        String status = record.getAttribute("客户状态").getValue();
        if (status.equals("离开")) {
            send(new FormHandler(new UserOrderedMenuUIDisplay(orderId),
                new UIOperations()));
            send(new FormHandler(() -> System.out.println("欢迎下次光临"), new LookOnlyOperations()));
        } else if (status.equals("就餐")) {
            send(new FormHandler(new UserOrderedMenuUIDisplay(orderId), new UIOperations()));
            send(new FormHandler(
                new NotificationUIDisplay("你是否需要现在支付订单?", "1.现在支付\n其他.不支付"),
                new UIOperations() {
                    @Override
                    public void userInput() {
                        String choice = scanner.nextLine();
                        if (choice.equals("1")) {
                            send(new PaymentTasksCenter(getSender(), orderId));
                        }
                    }
                }));
        }
    }
}
