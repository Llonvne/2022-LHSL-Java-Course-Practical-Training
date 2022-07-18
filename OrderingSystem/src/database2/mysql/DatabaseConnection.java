package database2.mysql;

import database.sqlTools.AdvanceResultSet;

import java.sql.*;

// 该类将独立管理 Connection
public class DatabaseConnection {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }


    //    此处是数据链接信息，请勿泄露，请勿传入 Git！！！！
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://sh-cynosdbmysql-grp-d1xjool8.sql.tencentcdb.com:21822?useSSL=true&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Hsk13385816616";

    //  尝试加载驱动文件
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库驱动文件加载失败！");
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("数据库链接关闭失败！");
        }
    }
}
