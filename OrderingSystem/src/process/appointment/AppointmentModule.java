package process.appointment;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.sqlTools.CopyRecord;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;
import process.order.OrderingModule;
import ui.FormHandler;
import ui.UIOperations.UIOperations;
import ui.displayables.NotificationUIDisplay;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类名:     AppointmentModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AppointmentModule extends ExecWithSender {
    private final String orderId;

    public AppointmentModule(Recevier<Exec> sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    @Override
    public void exec() {

        // 询问客户姓名
        System.out.println("请输入你的预约客户姓名");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        // 查询预约表
        Table reserved = new TableGetter("预约表").getTable();
        Table today = new TableGetter("当日预约").getTable();
        ImmutableRecord reserved_record = reserved.getRecordByPrimaryKey(choice);

        // 核对是否是今天预约
        boolean isToday = false;
        for (ImmutableRecord todayRecord : today) {
            if (todayRecord.getAttribute("预约客户姓名").getValue().equals(choice)) {
                isToday = true;
            }
        }

        if (isToday && !Objects.equals(reserved_record.getAttribute(reserved_record.getPrimaryKey()).getValue(), "")
            && reserved_record.getAttribute("是否有效").getValue().equals("有效")) {
            System.out.println("你的预约有效，请开始点单");

            MuteableRecord newRecord = reserved.getEmptyRecord();
            CopyRecord.record(reserved_record, newRecord);
            newRecord.updateAttribute(new KeyPair<>("是否有效", "无效"));
            reserved.updateRecord(newRecord);

            Table table = new TableGetter("订单表").getTable();
            MuteableRecord record = table.getEmptyRecord();
            record.updateAttribute(new KeyPair<>(record.getPrimaryKey(), orderId));
            table.insertRecord(record);

            new OrderingModule(getSender(), orderId).exec();
        } else {
            System.out.println("您的预约不存在或者已失效,或不在今天");
        }
    }
}
