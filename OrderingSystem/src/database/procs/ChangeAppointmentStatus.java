package database.procs;

/**
 * 类名:     ChangeAppointmentStatus
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class ChangeAppointmentStatus implements Proc<Boolean> {
    private String appointmentId;
    private String status;
    private String statusname;

    public ChangeAppointmentStatus(String appointmentId, String statusname, String status) {
        this.appointmentId = appointmentId;
        this.status = status;
        this.statusname = statusname;
    }

    @Override
    public Boolean exec() {
        return true;
    }
}
