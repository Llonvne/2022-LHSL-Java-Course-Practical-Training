package process.account.admin;

import database.TableGetter;
import database.commonOperations.DeleteOperations;
import database.commonOperations.InsertOperations;
import database.commonOperations.UpdateOperations;
import database.table.types.Table;
import exec.Exec;
import exec.ExecWithSender;
import exec.recall.Recevier;

import java.util.Scanner;

/**
 * 类名:     AdminModifyUI
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/27
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class AdminModifyModule extends ExecWithSender {

    public AdminModifyModule(Recevier<Exec> sender) {
        super(sender);
    }
//    public void display() {
//        //            AdvanceResultSet resultSet = QueryExecute.executeQuery("select table_name from information_schema.tables where table_schema='" + "OrderingSystem" + "'");
////            LinkedList<String> tableNames = new LinkedList<>();
////            while (resultSet.getResultSet().next()) {
////                tableNames.offer(resultSet.getResultSet().getString("table_name"));
////            }
////            resultSet.closeAll();
//
//
//    }

    @Override
    public void exec() {
        System.out.println("---------请输入要修改的表名--------");
        System.out.println("员工表\t已点餐表\t支付方式\t桌型表");
        System.out.println(" ");
        System.out.println("等待表\t菜品表\t订单表\t预约表\t");
        System.out.println(" ");
        System.out.println("以下是仅供查看的表");
        System.out.println("可用菜品表\t当日预约\t有效等待表");
        System.out.println("输入 0 以退出账号");

        System.out.println("--------------------------------");
        System.out.println("请输入要修改的表名");
        Scanner scanner = new Scanner(System.in);
        String table = scanner.next();
        if (table.equals("0")) {
            return;
        }
        Table t = new TableGetter(table).getTable();

        modifyTable(t);

        send(new AdminModifyModule(getSender()));
    }

    private void modifyTable(Table t) {
        boolean out = false;
        while (!out) {

            if (t.getEmptyRecord().getPrimaryKey().equals("")){
                System.out.println("该表仅供查看！");
                UpdateOperations.displayTable(t);
                return;
            }

            System.out.println("1. 增加");
            System.out.println("2. 删除");
            System.out.println("3. 查看");
            System.out.println("4. 修改");
            System.out.println("其他.退出");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            switch (choice) {
                case "1" -> new InsertOperations(t).exec();
                case "2" -> new DeleteOperations(t).exec();
                case "3" -> UpdateOperations.displayTable(t);
                case "4" -> new UpdateOperations(t).exec();
                default -> {
                    out = true;
                }
            }
        }
    }
}
