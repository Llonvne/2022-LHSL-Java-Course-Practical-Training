package database.procs;

import database.DatabaseHandler;
import database.TableGetter;
import database.keyValue.KeyPair;
import database.record.types.ImmutableRecord;
import database.record.types.MuteableRecord;
import database.table.types.ImmutableTable;
import database.table.types.Table;

/**
 * 类名:     ChangeAppointmentStatus
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ChangeAppointmentStatus implements Proc {
    private String appointmentId;
    private String status;
    private String statusname;

    public ChangeAppointmentStatus(String appointmentId, String statusname, String status) {
        this.appointmentId = appointmentId;
        this.status = status;
        this.statusname = statusname;
    }

    @Override
    public void exec() {
//        Table table = new TableGetter("预约状态表").getTable();
//        for (ImmutableRecord record : table)
//        MuteableRecord newRecord = table.getEmptyRecord();
//        for (String key : record.getKeys()) {
//            newRecord.updateAttribute(new KeyPair<>(key, record.getAttribute(key).getValue()));
//        }
//        newRecord.updateAttribute(new KeyPair<>(statusname, statusname));
    }
}
