package process.order;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.procs.GetUserOrderedMenu;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.appointment.AppointmentModule;
import process.menu.AvailableMenuUIDisplay;
import process.waiting.WaitingModule;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.NotificationUIDisplay;
import ui.status.UIStatus;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类名:     CreateNewOrderModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class CreateNewOrderModule extends ExecWithSender {
    public CreateNewOrderModule(Recevier<Exec> sender) {
        super(sender);
    }

    @Override
    public void exec() {
        int orderIDint = new GetAvailablePrimarykey("订单表", "订单号").exec();
        String orderId = String.valueOf(orderIDint);

        Table table = new TableGetter("订单表").getTable();
        MuteableRecord record = table.getEmptyRecord();

        record.updateAttribute(new KeyPair<>(record.getPrimaryKey(), orderId));
        table.insertRecord(record);

        System.out.println("您的订单号是:" + orderId);

        AtomicReference<Boolean> isHasAppointment = new AtomicReference<>(false);
        new FormHandler(new NotificationUIDisplay("你是否有预约", "1.有\n2.无"),
            new UIOperations() {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        send(new AppointmentModule(getSender(), orderId));
                        isHasAppointment.set(true);
                    }
                }
            }).exec();

        if (isHasAppointment.get()) {
            return;
        }

        // 进入等待模块
        new WaitingModule(getSender(), orderId);

        new FormHandler(new AvailableMenuUIDisplay(), new UIOperations() {
            private final Table availableMenu = new TableGetter("可用菜品表").getTable();
            private final int availableMenuSize = availableMenu.size();
            private final LinkedList<ImmutableRecord> records = new LinkedList<>();

            private final Table table = new TableGetter("已点餐表").getTable();

            int primaryKey = new GetAvailablePrimarykey(table.tableName(), table.getEmptyRecord().getPrimaryKey()).exec();

            @Override
            public void userInput() {
                MuteableRecord r = table.getEmptyRecord();
                System.out.println("请输入想吃的菜品编号:(以 0 结束)");
                System.out.println(">>>");
                int choice;
                int size;
                String note;
                try {
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    if (choice == 0) {
                        getStatusController().setStatus(UIStatus.HANDLER_USER_INPUT);
                        return;
                    }
                    if (choice > availableMenuSize || choice < 0) {
                        throw new IllegalArgumentException("菜品号不合法");
                    }
                    System.out.println("请输入想吃的菜品份数:");
                    System.out.println(">>>");
                    size = scanner.nextInt();
                    if (size <= 0) {
                        throw new IllegalArgumentException("菜品数量不合法");
                    }
                    note = scanner.next();
                } catch (Exception e) {
                    System.out.println("输入有误，请重新输入！");
                    getStatusController().setStatus(UIStatus.DISPLAY);
                    return;
                }

                r.updateAttribute(new KeyPair<>(r.getPrimaryKey(), String.valueOf(primaryKey++)));
                r.updateAttribute(new KeyPair<>("菜品编号", String.valueOf(choice)));
                r.updateAttribute(new KeyPair<>("份数", String.valueOf(size)));
                r.updateAttribute(new KeyPair<>("备注", String.valueOf(note)));
                r.updateAttribute(new KeyPair<>("订单号", orderId));

                this.records.add(r);

                ImmutableRecord meal = new TableGetter("菜品表").getTable()
                    .getRecordByPrimaryKey(String.valueOf(choice));
                System.out.println("你已成功将 " + meal.getAttribute("菜品名").getValue() + " " + size + " 份添加到菜单 备注为:" + note);

                this.getStatusController().setStatus(UIStatus.DISPLAY);
            }

            public void recall() {

                System.out.println("请确认你的菜单");
                System.out.println("------------------- 订单 -------------------");
                System.out.println("菜品名      份数      备注");
                for (ImmutableRecord record : this.records) {
                    ImmutableRecord meal = new TableGetter("菜品表").getTable()
                        .getRecordByPrimaryKey(String.valueOf(record.getAttribute("菜品编号").getValue()));
                    System.out.println(record.getAttribute("份数").getValue() + "\t\t"
                        + meal.getAttribute("菜品名").getValue() + "\t\t" + record.getAttribute("备注").getValue());
                }
                System.out.println("");
                System.out.println("------------------- 订单 -------------------");
                System.out.println("请输入 1 确认，任意键取消");

                Scanner scanner = new Scanner(System.in);
                try {
                    if (scanner.nextInt() != 1) {
                        throw new IllegalArgumentException("取消订单");
                    }
                } catch (Exception e) {
                    return;
                }

                for (ImmutableRecord r : records) {
                    table.insertRecord(r);
                }
                System.out.println("您已成功下单");

                Table orderTable = new TableGetter("订单表").getTable();
                ImmutableRecord record = orderTable.getRecordByPrimaryKey(orderId);
                MuteableRecord newrecord = orderTable.getEmptyRecord();
                for (String key : record.getKeys()) {
                    newrecord.updateAttribute(new KeyPair<>(key, record.getAttribute(key).getValue()));
                }
                newrecord.updateAttribute(new KeyPair<>("客户状态", "就餐"));
                orderTable.updateRecord(newrecord);
            }
        }).exec();


    }
}
