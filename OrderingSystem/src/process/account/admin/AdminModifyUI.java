package process.account.admin;

import database.TableGetter;
import database.commonOperations.DeleteOperations;
import database.commonOperations.InsertOperations;
import database.commonOperations.UpdateOperations;
import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;
import database.table.types.Table;
import ui.Displayable;

import java.sql.SQLException;
import java.util.LinkedList;
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
public class AdminModifyUI implements Displayable {

    @Override
    public void display() {
        try {
            AdvanceResultSet resultSet = QueryExecute.executeQuery("select table_name from information_schema.tables where table_schema='" + "OrderingSystem" + "'");
            LinkedList<String> tableNames = new LinkedList<>();
            while (resultSet.getResultSet().next()) {
                tableNames.offer(resultSet.getResultSet().getString("table_name"));
            }
            resultSet.closeAll();

            System.out.println("---------请输入要修改的表名--------");
            for (String table : tableNames) {
                System.out.println(table);
            }
            System.out.println("--------------------------------");
            System.out.println("请输入要修改的表名");
            Scanner scanner = new Scanner(System.in);
            String table = scanner.next();
            Table t = new TableGetter(table).getTable();

            System.out.println("1. 增加");
            System.out.println("2. 删除");
            System.out.println("3. 查看");
            System.out.println("4. 修改");

            String choice = scanner.next();

            if (choice.equals("1")){
                new InsertOperations(t).exec();
            }
            else if (choice.equals("2")){
                new DeleteOperations(t).exec();
            }
            else if (choice.equals("3")){
                UpdateOperations.displayTable(t);
            }
            else if (choice.equals("4")){
                new UpdateOperations(t).exec();
            }
        } catch (SQLException e) {
            throw new RuntimeException("数据库链接失败");
        }
    }
}
