package process.appointment;

import database.TableGetter;
import database.keyValue.KeyPair;
import database.procs.GetAvailablePrimarykey;
import database.record.types.MuteableRecord;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;

import java.util.Scanner;

/**
 * 类名:     CreateAppointmentModule
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class CreateAppointmentModule extends ExecWithSender {
    public CreateAppointmentModule(Recevier<Exec> sender) {
        super(sender);
    }

    @Override
    public void exec() {
        System.out.println("开始创建新的预约");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String name = scanner.next();
        System.out.println("请输入预约日期");
        String date = scanner.next();
        System.out.println("请输入手机号码");
        String phone = scanner.next();
        System.out.println("请输入桌型");
        String table = scanner.next();
        System.out.println("请输入备注");
        String note = scanner.next();

        Table t = new TableGetter("预约表").getTable();
        MuteableRecord r = t.getEmptyRecord();
        r.updateAttribute(new KeyPair<>("预约客户姓名", name));
        r.updateAttribute(new KeyPair<>("预约号", String.valueOf(
            new GetAvailablePrimarykey(t.tableName(), r.getPrimaryKey()).exec()
        )));
        r.updateAttribute(new KeyPair<>("预约时间", date));
        r.updateAttribute(new KeyPair<>("电话号码", phone));
        r.updateAttribute(new KeyPair<>("备注", note));
        r.updateAttribute(new KeyPair<>("是否有效", "有效"));
        r.updateAttribute(new KeyPair<>("桌型", table));
        t.insertRecord(r);
    }
}
