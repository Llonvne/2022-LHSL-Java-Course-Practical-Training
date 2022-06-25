package process;

import database.DatabaseHandler;
import database.Init;
import database.record.types.ImmutableRecord;
import database.sqlTools.AdvanceResultSet;
import database.sqlTools.QueryExecute;
import database.table.types.ImmutableTable;
import exec.Tasks;
import java.sql.SQLException;

/**
 * 类名:     process.Main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/6/24
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Tasks tasks = new Tasks();
        tasks.offer(new Init("OrderingSystem"));
        tasks.exec();

//        FormHandler form = new FormHandler(
//            new UserOrderedMenuUIDisplay("1"),new UIOperations()
//        );
//        form.exec();
        AdvanceResultSet resultSet = QueryExecute.executeQuery("CALL 用户下单菜品('1')");
        ImmutableTable table =
            DatabaseHandler.getInstance().getDatabaseHandler()
                .getResultSetTable("客人点餐", resultSet);
        for (ImmutableRecord record : table){
            System.out.println(record);
        }
    }
}
