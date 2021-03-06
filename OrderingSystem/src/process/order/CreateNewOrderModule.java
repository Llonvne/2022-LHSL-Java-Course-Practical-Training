package process.order;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAllTableType;
import database.procs.GetAvailablePrimarykey;
import database.procs.GetTableWaitingList;
import database.procs.GetUserOrderedMenu;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.sqlTools.CopyRecord;
import database.table.types.ImmutableTable;
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
import java.util.List;
import java.util.Objects;
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

        System.out.println("您的订单号是:" + orderId);

        AtomicReference<Boolean> isHasAppointment = new AtomicReference<>(false);
        // 询问是否是有预约
        new FormHandler(new NotificationUIDisplay("你是否有预约", "1.有\n2.无"),
            new UIOperations() {
                @Override
                public void userInput() {
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        isHasAppointment.set(true);
                    }
                }
            }).exec();

        if (isHasAppointment.get()) {
            new AppointmentModule(getSender(), orderId).exec();
            return;
        }

        System.out.println("请输入你的需要的桌型");
        List<String> types = new GetAllTableType().exec();
        for (String t : types) {
            System.out.print(t + " ");
        }
        String choice = "";
        boolean isTypeExist = false;
        while (!isTypeExist) {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();
            if (!types.contains(choice)) {
                System.out.println("输入有误重新输入");
            } else {
                isTypeExist = true;
            }
        }
        ImmutableTable tableWaiting = new GetTableWaitingList(choice).exec();
        if (tableWaiting.size() == 0) {
            System.out.println("您的桌型仍有余量,请开始点餐");
            table.insertRecord(record);
            send(new OrderingModule(getSender(), orderId));
        } else {
            System.out.println("还有 " + tableWaiting.size() + " 桌在等待");
        }
    }
}
