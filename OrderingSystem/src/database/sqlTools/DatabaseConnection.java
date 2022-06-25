package database.sqlTools;

import java.sql.*;

// 该类将独立管理 Connection
public class DatabaseConnection {
    private volatile static Connection uniqueInstance;

    public static Connection getConnection() throws SQLException {
        if (uniqueInstance == null){
            synchronized (DatabaseConnection.class){
                if (uniqueInstance == null){
                    uniqueInstance = DriverManager.getConnection(DB_URL, USER, PASS);
                }
            }
        }
        return uniqueInstance;
    }


    //    此处是数据链接信息，请勿泄露，请勿传入 Git！！！！
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://sh-cynosdbmysql-grp-d1xjool8.sql.tencentcdb.com:21822?useSSL=true&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Lcosvle1314";

    //  尝试加载驱动文件
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
    }
}
