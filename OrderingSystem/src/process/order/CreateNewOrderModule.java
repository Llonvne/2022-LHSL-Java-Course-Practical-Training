package process.order;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.appointment.AppointmentModule;
import process.waiting.WaitingModule;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.NotificationUIDisplay;

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
        send(new WaitingModule(getSender(), orderId));

        // 回到等待模块
        send(new OrderModule(getSender()));
    }
}
